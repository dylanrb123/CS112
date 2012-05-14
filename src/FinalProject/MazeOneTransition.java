/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */
public class MazeOneTransition extends Transition{
    private State newState;
    private String transitionDirection;
    int distance;

    public MazeOneTransition() {}
    public MazeOneTransition(String s) {
        transitionDirection = s;
    }
   
    @Override
    public State makeTransition(State s) {
        int xStart = s.getLocation().getXPos();
        int yStart = s.getLocation().getYPos();
        newState = null;
        distance = s.getDistance();
        
        System.out.println("xStart in transition: "+xStart);
        System.out.println("yStart in transition: "+yStart);
        System.out.println("Distance in transition: "+distance);
        switch (transitionDirection) {
            case "left":
                if((xStart - distance) < 1)
                    newState = null;
                else newState = new State((xStart - distance),yStart,"Maze1");
            case "right":
                if((xStart + distance) > 2)
                    newState = null;
                else newState = new State((xStart + distance),yStart,"Maze1");
            case "down":
                if((yStart + distance) > 2)
                    newState = null;
                else newState = new State(xStart, (yStart + distance),"Maze1");
            case "up":
                if((yStart - distance) < 1)
                    return null;
                else newState = new State(xStart,(yStart - distance),"Maze1");
        }
        
        if(newState != null) {
            newState.setPreviousState(s);
        }
        
        System.out.println("Returning " + newState);
        
        return newState;
    
    }
    public void setTransitionDirection(String s) {
        transitionDirection = s;
    }
    public String getTransitionDirection() {
        return transitionDirection;
    }
    public String toString() {
        return (transitionDirection + ", " + distance);
    }
}