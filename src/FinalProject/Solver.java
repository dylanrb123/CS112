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


public class Solver{
    private LinkedList<State> solverQueue = new LinkedList<>();
    private boolean foundGoal;
    private State goalState;
    private Stack<State> solution = new Stack<>();
    
    public void solve(State startState) {
        ArrayList<Transition> transitions;
        solverQueue.add(startState);
        while(!foundGoal && !solverQueue.isEmpty()) {
            State tempState = solverQueue.remove();
            if(tempState.getIsGoal()) {
                foundGoal = true;
                goalState = tempState;
            }
            transitions = tempState.getTransitions();
            for(Transition t : transitions) {
                
                solverQueue.add(t.makeTransition(tempState));
            }
        }
        System.out.println(goalState);
        getSolution(goalState);
    }
    public void displaySolution() {
        //for(int i=0;i<solution.size();i++) {
       //     System.out.println(solution.pop());
        //}
    }
    public void getSolution(State s) {
        if(s.getPreviousState() != null) {
            solution.add(s.getPreviousState());        
            getSolution(s.getPreviousState());
        }
            
    }
}
