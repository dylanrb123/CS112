/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */
import java.awt.event.*;
import javax.swing.*;

public class RunMazeGame {
    private static MazeFrame frame;
    static MazeSetup setup = new MazeSetup1();
    
    public static void main(String[] args) {
        RunMazeGame run = new RunMazeGame();
        run.go();
    }
    public static void go() {
        
        frame = setup.init();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.repaint();
    }
    public static class MazeOneListener  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setup = new MazeSetup1();
            frame.setVisible(false);
            setup.setTypeOfMaze("Maze1");
            go();
        }
    }
    public static class MazeTwoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setup = new MazeSetup2();
            frame.setVisible(false);
            setup.setTypeOfMaze("Maze2");
            go();
        }
    }   
}
