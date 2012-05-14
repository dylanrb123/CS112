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

public class State {
    private Location location;
    private Object info;
    private String typeOfMaze;
    private String fromDirection;
    private int distance;
    private ArrayList<String> legalDirections = new ArrayList<>();
    private State previousState;
    private boolean isGoal;

    
    public State(int x, int y) {
        location = new Location(x,y);
    }
    public State(int x, int y, String type) {
        location = new Location(x,y,type);
        typeOfMaze = type;
        
        legalDirections.add("up");
        legalDirections.add("down");
        legalDirections.add("left");
        legalDirections.add("right");
        if(type.equals("Maze2")) {
            legalDirections.remove(fromDirection);
        }

    
    }
    @Override
    public String toString() {
        return ("("+getLocation().getXPos()+","+getLocation().getYPos()+")" +getTypeOfMaze());
    }
    
    public boolean checkSameState(State s) {
        State check = s;
        if(typeOfMaze.equals("Maze2")) {
            if(check.fromDirection.equals(this.fromDirection) && check.getLocation().getXPos() == this.getLocation().getXPos() && check.getLocation().getYPos() == this.getLocation().getYPos())
                return true;
            else return false;
        } else {
            if(check.getLocation().getXPos() == this.getLocation().getXPos() && check.getLocation().getYPos() == this.getLocation().getYPos())
                return true;
            else return false;
        }
    }
    public boolean isGoal() {
        if(typeOfMaze.equals("Maze1")) {
            if(location.getXPos() == 7 && location.getYPos() == 7)
                return true;
            else return false;
        } else {
            if(location.getXPos() == 8 && location.getYPos() == 8)
                return true;
            else return false;
        }
    }

    /**
     * @return the location
     */
    public void setIsGoal(boolean b) {
        isGoal = b;
    }
    public boolean getIsGoal() {
        return isGoal;
    }
    public void setDirection(String s) {
        fromDirection = s;
    
    }
    public void setDistance(int i) {
        //System.out.println(i);
        distance = i;
    }
    public int getDistance() {
        return distance;
    }
    public Location getLocation() {
        return location;
    }
    public ArrayList<Transition> getTransitions() {
        return location.transitions;
    }
    public void setAvailableTransitions() {
        for(Object o : legalDirections) {
            if(distance != 0) {
            Transition transition = new MazeOneTransition((String) o);
            State check = transition.makeTransition(this);
            System.out.println(this);
            System.out.println(transition);
            System.out.println(check);
            System.out.println("Distance: "+distance);
            if(check != null) {
                System.out.println("OH HEY");
                System.out.println(check);
                this.location.transitions.add(transition);

            }
            }
        }
    }
    public void setPreviousState(State s) {
        previousState = s;
    }
    public State getPreviousState() {
        return previousState;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the info
     */
    public Object getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(Object info) {
        this.info = info;
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
    
    
}
