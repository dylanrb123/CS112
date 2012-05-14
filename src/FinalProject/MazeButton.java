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
import java.awt.*;

public class MazeButton extends JButton implements ActionListener {
    
    private State buttonState;
    private boolean activeButton;
    private Color initialColor;
    private boolean beenHere;
    private MazeButton previousButton;
    
    public MazeButton(State s) {
        buttonState = s;        
    }
    public MazeButton(int x, int y) {
        buttonState = new State(x,y);
    }
    public MazeButton(int x, int y, String type) {
        buttonState = new State(x,y,type);
        initialColor = this.getBackground();
        addActionListener(this);
    }
    public boolean checkMove(MazeButton compareTo) {
        return true;
    }
    public void checkActive() {
        if(isActiveButton() == true) {
            this.setBackground(Color.GREEN);
        } else if(isBeenHere() == true) {
            this.setBackground(Color.RED);
        } else {
            this.setBackground(getInitialColor());
        }
    }
    public State getState() {
        return getButtonState();
    }
    public void setActiveButton(boolean b) {
        activeButton = b;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        checkActive();

    }
    public void beenHere() {
        setBeenHere(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int x1 = buttonState.getLocation().getXPos();
        int y1 = buttonState.getLocation().getYPos();
        int x2;
        try {
            x2 = previousButton.getButtonState().getLocation().getXPos();
        } catch (NullPointerException ex) {
            x2 = 0;
        }
        int y2;
        try {
            y2 = previousButton.getButtonState().getLocation().getYPos();
        } catch (NullPointerException ex) {
            y2 = 0;
        }
        if(x1 < x2 && y1 == y2) {
            buttonState.setDirection("right");
        } else if(x1 > x2 && y1 == y2) {
            buttonState.setDirection("left");
        } else if(y1 < y2 && x1 == x2) {
            buttonState.setDirection("below");
        } else if(y1 > y2 && x1 == x2) {
            buttonState.setDirection("above");
        }
    }
    public void setPreviousButton(MazeButton previous) {
        previousButton = previous;
    }
    public MazeButton getPreviousButton() {
        return previousButton;
    }

    /**
     * @return the buttonState
     */
    public State getButtonState() {
        return buttonState;
    }

    /**
     * @param buttonState the buttonState to set
     */
    public void setButtonState(State buttonState) {
        this.buttonState = buttonState;
    }

    /**
     * @return the activeButton
     */
    public boolean isActiveButton() {
        return activeButton;
    }

    /**
     * @return the initialColor
     */
    public Color getInitialColor() {
        return initialColor;
    }

    /**
     * @param initialColor the initialColor to set
     */
    public void setInitialColor(Color initialColor) {
        this.initialColor = initialColor;
    }

    /**
     * @return the beenHere
     */
    public boolean isBeenHere() {
        return beenHere;
    }

    /**
     * @param beenHere the beenHere to set
     */
    public void setBeenHere(boolean beenHere) {
        this.beenHere = beenHere;
    }
}
    