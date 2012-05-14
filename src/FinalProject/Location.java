/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */
import java.util.ArrayList;
public class Location {
    private Coordinate location;
    private String typeOfMaze;
    private int distance;
    ArrayList<Transition> transitions = new ArrayList<>();
    
    public Location() {
    }
    public Location(Coordinate c) {
        location = c;
    }
    public Location(int x, int y) {
        location = new Coordinate(x,y);
    }
    public Location(int x, int y, String s) {
        location = new Coordinate(x,y);
    }
    public boolean sameLocation(int x,int y) {
        if(x==location.getXPos() && y==location.getYPos())
            return true;
        else return false;
    }
    public void setLocation( Coordinate c) {
        location = c;
    }
    public Coordinate getLocation() {
        return location;
    }
    public int getXPos() {
        return location.getXPos();
    }
    public int getYPos() {
        return location.getYPos();
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDistance() {
        return this.distance;
    }

    /**
     * @return the transitions
     */
    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    /**
     * @param transitions the transitions to set
     */
    public void setTransitions(ArrayList<Transition> transitions) {
        this.transitions = transitions;
    }
    
}
