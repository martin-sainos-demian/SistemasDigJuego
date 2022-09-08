
package enojatenthiperparchis.game;

import enojatenthiperparchis.states.State;

public class Round {
    private State state;
    public Round(){
        
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}