
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Canica extends Object {
    static Player player;
    
    public Canica(All all, float x, float y, int id, Player player) {
        super(all, x, y, id, getState());
        this.player=player;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }
    
    public static State getState(){
        return player.getState();
    }
}