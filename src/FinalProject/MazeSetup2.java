/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */

import javax.swing.JOptionPane;

public class MazeSetup2 extends MazeSetup{
    private boolean debuging = true;
    
    public MazeSetup2() {
        super("mazeButtonLabels2.txt");
    }
    @Override
    public void checkMove(MazeButton button) throws IllegalMoveException {
        int x1 = getActiveButton().getButtonState().getLocation().getXPos();
        int y1 = getActiveButton().getButtonState().getLocation().getYPos();
        int x2 = button.getButtonState().getLocation().getXPos();
        int y2 = button.getButtonState().getLocation().getYPos();
        int distance = 0;
        try{
            distance = Integer.parseInt(getActiveButton().getText());
           
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(getToReturn(),"You Win!","Win Messege",JOptionPane.PLAIN_MESSAGE);
        }
        System.out.println(checkUTurn(button));
        if((x1 + distance) == x2 && y1 == y2 && !checkUTurn(button))
            return;
        else if((x1 - distance) == x2 && y1 == y2 && !checkUTurn(button))
            return;
        else if((y1 - distance) == y2 && x1 == x2 && !checkUTurn(button))
            return;
        else if((y1 + distance) == y2 && x1 == x2 && !checkUTurn(button))
            return;
       else throw new IllegalMoveException();


    }

    public boolean checkUTurn(MazeButton button) {
        int x1 = getActiveButton().getButtonState().getLocation().getXPos();
        int x2;
        try{
            x2 = getActiveButton().getPreviousButton().getButtonState().getLocation().getXPos();
        } catch (NullPointerException e1) {
            x2 = 0;
            System.out.println("caught null");
        }
        int x3 = button.getButtonState().getLocation().getXPos();
        
        int y1 = getActiveButton().getButtonState().getLocation().getYPos();
        int y2;
        try{
            y2 = getActiveButton().getPreviousButton().getButtonState().getLocation().getYPos();
        } catch (NullPointerException e) {
                y2 = 0;
        }
        int y3 = button.getButtonState().getLocation().getYPos();
        
        System.out.println(between(button));
        if (between(button)) {
            return true;
        } else if(inLineY(button) && (x2 < x1 && x3 < x2)) {
            return true;
        } else if(inLineY(button) && (x3 < x2 && x2 < x1)) {
            return true;
        } else if(inLineX(button) && (y2 < y1 && y3 < y2)) {
            return true;
        } else if(inLineX(button) && (y3 <= y2 && y2 <= y1)) {
            return true;
        } else if ((y2 == y3) && (x2 == x3)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean between(MazeButton toCompare) {
        int x1 = getActiveButton().getButtonState().getLocation().getXPos();
        int x2;
        try{
            x2 = getActiveButton().getPreviousButton().getButtonState().getLocation().getXPos();
        } catch (NullPointerException e1) {
            x2 = 0;
        }
        int x3 = toCompare.getButtonState().getLocation().getXPos();
        
        int y1 = getActiveButton().getButtonState().getLocation().getYPos();
        int y2;
        try{
            y2 = getActiveButton().getPreviousButton().getButtonState().getLocation().getYPos();
        } catch (NullPointerException e) {
                y2 = 0;
        }
        int y3 = toCompare.getButtonState().getLocation().getYPos();
        if(debuging) {
            System.out.print("active button: " +x1);
            System.out.println(y1);
            System.out.print("previous button :" +x2);
            System.out.println(y2);
            System.out.print("button being checked: "+x3);
            System.out.println(y3);
        }
        if((y1 < y3 && y3 < y2) && (x1 == x3 && x3 == x2)) {
            return true;
        } else if((y1 > y3 && y3 > y2) && (x1 == x3 && x3 == x2)) {
            return true;
        } else if ((x1 < x3 && x3 < x2) && (y1 == y2 && y2 == y3)) {
            return true;
        } else if((x1 > x3 && x3 > x2) && (y1 == y2 && y2 == y3)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean inLineX(MazeButton checkInLine) {
        int x1 = getActiveButton().getButtonState().getLocation().getXPos();
        int x2;
        try{
            x2 = getActiveButton().getPreviousButton().getButtonState().getLocation().getXPos();
        } catch (NullPointerException e1) {
            x2 = 1;
        }
        int x3 = checkInLine.getButtonState().getLocation().getXPos();
        
        if(x1 == x2 && x2 == x3)
            return true;
        else
            return false;
        
    }
    public boolean inLineY(MazeButton checkInLine) {
        int y1 = getActiveButton().getButtonState().getLocation().getYPos();
        int y2;
        try{
            y2 = getActiveButton().getPreviousButton().getButtonState().getLocation().getYPos();
        } catch (NullPointerException e) {
                y2 = 1;
        }
        int y3 = checkInLine.getButtonState().getLocation().getYPos();
        if((y1 == y2) && (y2 == y3)) {
            return true;
        } else {
            return false;
        }
    }
   
}
