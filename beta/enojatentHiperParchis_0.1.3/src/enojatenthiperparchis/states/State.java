
package enojatenthiperparchis.states;

import enojatenthiperparchis.Game;
import java.awt.Graphics;

public abstract class State {
    Game game;
    
    public State(Game game){
        this.game=game;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public Game getGame() {
        return game;
    }

}
