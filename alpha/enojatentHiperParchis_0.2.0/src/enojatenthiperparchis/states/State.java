
package enojatenthiperparchis.states;

import enojatenthiperparchis.Game;
import enojatenthiperparchis.object.Mouse;
import java.awt.Graphics;

public abstract class State {
    public Mouse mouse;
    Game game;
    Object selected;
    
    public State(Game game){
        this.game=game;
        mouse=new Mouse(game.getAll(),0,this,game.mouseInput);
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public Game getGame() {
        return game;
    }

    public Object getSelected() {
        return selected;
    }

    public void setSelected(Object selected) {
        this.selected = selected;
    }

}
