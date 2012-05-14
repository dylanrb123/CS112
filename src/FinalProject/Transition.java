/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

/**
 *
 * @author Dylan Bannon
 */
public abstract class Transition {
    private Coordinate goal;
    private Coordinate moveToCheck;
    
    
    
    public abstract State makeTransition(State s);
    /**
     * @return the goal
     */
    public Coordinate getGoal() {
        return goal;
    }

    /**
     * @param goal the goal to set
     */
    public void setGoal(Coordinate goal) {
        this.goal = goal;
    }

    /**
     * @return the moveToCheck
     */
    public Coordinate getMoveToCheck() {
        return moveToCheck;
    }

    /**
     * @param moveToCheck the moveToCheck to set
     */
    public void setMoveToCheck(Coordinate moveToCheck) {
        this.moveToCheck = moveToCheck;
    }
    
}
