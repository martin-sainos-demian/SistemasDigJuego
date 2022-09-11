
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Canica extends Object {
    static Player player;
    public boolean assigned;
    public boolean clicked=false;
    
    public Canica(All all, float x, float y, int id, Player player) {
        super(all, x, y, id, player.getState());
        this.player=player;
    }

    @Override
    public void tick() {
        super.updateHitbox();
        if(clicked&&(state.getSelected()==null||state.getSelected()==this)){
            state.setSelected(this);
            x=state.mouse.x-(state.mouse.hitbox.width/2);
            y=state.mouse.y-(state.mouse.hitbox.height/2);
            assigned=false;
            if(state.mouse.clickLeft){
                state.setSelected(null);
            }
        }
        if(hitbox.contains(state.mouse.x,state.mouse.y)
                &&(state.getSelected()==null||state.getSelected()==this)){
            if(state.mouse.clickLeft){
                clicked=!clicked;
                player.tabla.settleCanicas();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if(!assigned){
            g.drawImage(all.sprites().boulder, (int)x, (int)y, null);
        }
    }
    public void render(Graphics g, boolean inHole) {
        if(inHole){
            g.drawImage(all.sprites().boulder, (int)x, (int)y, null);
        }
    }
    
    public static State getState(){
        if(player==null){
            System.out.println("▓ Player nulo");
            return null;
        }
        return player.getState();
    }
}