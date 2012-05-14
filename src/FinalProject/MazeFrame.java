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
import java.util.*;

public class MazeFrame extends JFrame implements ActionListener {
    public MazeButton[][] buttons = RunMazeGame.setup.getButtons();

    public MazeFrame() {
        super();
    }
    public MazeFrame(String title) {
        super(title);   
    }
    private Color randomColor() {
        Color randomColor;
        int r = (int) Math.floor(Math.random()*255);
        int g = (int) Math.floor(Math.random()*255);
        int b = (int) Math.floor(Math.random()*255);
        
        randomColor = new Color(r,g,b);
        return randomColor;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            checkMove();
            //do stuff if it is a legal move; let the game go on
        } 
        catch(IllegalMoveException exc) {
            JOptionPane.showMessageDialog(this,"Not a valid move",exc.toString(),JOptionPane.ERROR_MESSAGE);
            //do nothing, let them try again from last legal position
        }
    }
    public void checkMove() throws IllegalMoveException{
        if(illegalMove()) {
            throw new IllegalMoveException();
        }
    }
    public boolean illegalMove() {
        
        return true;
    }
}