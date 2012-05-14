/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */
import java.util.*;

public class Coordinate {
    private int xPos;
    private int yPos;
    String typeOfLocation;
    private ArrayList<Transition> availableTransitions = new ArrayList<>();
    
    
    public Coordinate(int x, int y) {
        xPos = x;
        yPos = y;
    }
    public Coordinate() {}
    public int getXPos() {
        return xPos;
    }
    public void getTransitions() {
        
    }
    public int getYPos() {
        return yPos;
    }
    public void setXPos(int x) {
        xPos = x;
    }
    public void setYPos(int y) {
        yPos = y;
    }
    @Override
    public String toString() {
        String toReturn = ("("+xPos+","+yPos+")");
        return toReturn;
    
        
    }
}
