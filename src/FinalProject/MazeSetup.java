/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public abstract class MazeSetup implements ActionListener{
    private MazeButton[][] buttons;
    private MazeButton activeButton;
    private int numRows;
    private int numColumns;
    private MazeFrame toReturn;
    private String fileName;
    private String typeOfMaze = "Maze1";
    
    public MazeSetup(String s) {
        fileName = s;
    }
    public MazeFrame init() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(getFileName()));
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.exit(1);
        }
        setNumRows(Integer.parseInt(sc.next()));
        setNumColumns(Integer.parseInt(sc.next()));
        setToReturn(new MazeFrame("Maze Game"));
        Container cont = getToReturn().getContentPane();
        getToReturn().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.setLayout(new GridLayout(getNumColumns(), getNumRows()));
        JMenuBar menuBar;
        JMenu selectorMenu;
        JButton solverButton = new JButton("Solve");
        solverButton.addActionListener(new SolverButtonListener());
        JMenuItem mazeOneItem, mazeTwoItem;
        menuBar = new JMenuBar();
        selectorMenu = new JMenu("Pick a Maze");
        selectorMenu.getAccessibleContext().setAccessibleDescription("Maze Chooser");
        menuBar.add(selectorMenu);
        menuBar.add(solverButton);
        mazeOneItem = new JMenuItem("Maze 1");
        mazeOneItem.getAccessibleContext().setAccessibleDescription("Selects Maze 1");
        mazeOneItem.addActionListener(new RunMazeGame.MazeOneListener());
        selectorMenu.add(mazeOneItem);
        mazeTwoItem = new JMenuItem("Maze 2");
        mazeTwoItem.getAccessibleContext().setAccessibleDescription("Selects Maze 1");
        mazeTwoItem.addActionListener(new RunMazeGame.MazeTwoListener());
        selectorMenu.add(mazeTwoItem);
        getToReturn().setJMenuBar(menuBar);
        
        
        setButtons(new MazeButton[getNumColumns()][getNumRows()]);
        
        for (int i=0;i<getNumColumns();i++) {
            int buttonCol;
            int buttonRow;
            buttonRow = (i+1);
            for(int j=0;j<getNumRows();j++) {
                buttonCol = (j+1);
                MazeButton button = new MazeButton(buttonCol,buttonRow, getTypeOfMaze());
//                if(i==0 && j==0) 
//                    button.getButtonState().getLocation().typeOfLocation = "start";
//                else if((i+1)==buttonCol && (j+1)==buttonRow)
//                    button.getButtonState().getLocation().typeOfLocation = "goal";
//                else button.getButtonState().getLocation().typeOfLocation = "intermediary";
                cont.add(button);
                getButtons()[i][j] = button;
                String toSet = sc.next();
                try {
                    buttons[i][j].getButtonState().setDistance(Integer.parseInt(toSet));
                } catch (NumberFormatException e) {
                    buttons[i][j].getButtonState().setDistance(0);
                }
                buttons[i][j].getButtonState().setAvailableTransitions();
                getButtons()[i][j].setText(toSet);
                Font newTextFont = new Font(getButtons()[i][j].getFont().getName(),getButtons()[i][j].getFont().getStyle(),24);
                getButtons()[i][j].setFont(newTextFont);
                
                //buttons[i][j].addActionListener(toReturn);
                getButtons()[i][j].addActionListener(this);
            }
        }
        getButtons()[0][0].setActiveButton(true);
        setActiveButton(getButtons()[0][0]);
        getActiveButton().setPreviousButton(null);
        return getToReturn();
    }
    public void actionPerformed(ActionEvent e) throws IllegalMoveException{
        MazeButton button = (MazeButton) e.getSource();
        try {
            checkMove(button);
            MazeButton temp = getActiveButton();
            getActiveButton().setActiveButton(false);
            getActiveButton().beenHere();
            setActiveButton(button);
            getActiveButton().setPreviousButton(temp);
            button.setActiveButton(true);
            getToReturn().repaint();
            //System.out.println(button.getButtonState());
        }
        catch (IllegalMoveException exc) {
            JOptionPane.showMessageDialog(getToReturn(),"Not a valid move",exc.toString(),JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @return the buttons
     */
    public void checkMove(MazeButton button) {
        int x1 = getActiveButton().getButtonState().getLocation().getXPos();
        int y1 = getActiveButton().getButtonState().getLocation().getYPos();
        int x2 = button.getButtonState().getLocation().getXPos();
        int y2 = button.getButtonState().getLocation().getYPos();
        int distance = 0;
        try{
            distance = Integer.parseInt(getActiveButton().getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(getToReturn(),"You Win!","Win Messege",JOptionPane.PLAIN_MESSAGE);
        }
        if((x1 + distance) == x2 && y1 == y2)
                return;
            else if((x1 - distance) == x2 && y1 == y2)
                return;
            else if((y1 - distance) == y2 && x1 == x2)
                return;
            else if((y1 + distance) == y2 && x1 == x2)
                return;
            else throw new IllegalMoveException();
    }
    public MazeButton[][] getButtons() {
        return buttons;
    }
    public void setFileName(String s) {
        fileName = s;
    }
    public class SolverButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Solver theSolver = new Solver();
            theSolver.solve(buttons[0][0].getButtonState());
            theSolver.displaySolution();
        }
    }
    /**
     * @return the activeButton
     */
    public MazeButton getActiveButton() {
        return activeButton;
    }

    /**
     * @param activeButton the activeButton to set
     */
    public void setActiveButton(MazeButton activeButton) {
        this.activeButton = activeButton;
    }

    /**
     * @return the numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @param numRows the numRows to set
     */
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    /**
     * @return the numColumns
     */
    public int getNumColumns() {
        return numColumns;
    }

    /**
     * @param numColumns the numColumns to set
     */
    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    /**
     * @param buttons the buttons to set
     */
    public void setButtons(MazeButton[][] buttons) {
        this.buttons = buttons;
    }

    /**
     * @return the toReturn
     */
    public MazeFrame getToReturn() {
        return toReturn;
    }

    /**
     * @param toReturn the toReturn to set
     */
    public void setToReturn(MazeFrame toReturn) {
        this.toReturn = toReturn;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return the typeOfMaze
     */
    public String getTypeOfMaze() {
        return typeOfMaze;
    }

    /**
     * @param typeOfMaze the typeOfMaze to set
     */
    public void setTypeOfMaze(String typeOfMaze) {
        this.typeOfMaze = typeOfMaze;
    }
    public MazeButton getButton(State s){
        MazeButton button = null;
        for (int i=0;i<buttons.length;i++) {
            for (int j=0;j<buttons[i].length;i++) {
                if (buttons[i][j].getState().equals(s)){
                    button = buttons[i][j];
                } 
            }
        }
        return button;
    }
  
}
