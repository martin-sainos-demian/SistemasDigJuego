
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Object {
    public float x, y;
    public int id;
    State state;
    All all;
    public Rectangle hitbox;
    
    public Object(All all, float x, float y, int id, State state, int width, int height){
        this.x=x;
        this.y=y;
        this.id=id;
        this.state=state;
        this.all=all;
        hitbox=new Rectangle((int)x, (int)y, width,  height);
    }
    
    public Object(All all, float x, float y, int id, State state){
        this(all, x, y, id, state, all.getDefaultWidth(), all.getDefaultHeight());
    }
    
    public void updateHitbox(){
        hitbox.x=(int)x-all.getCamara().xOff;
        hitbox.y=(int)y-all.getCamara().yOff;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean isOverlapping(Object other) {
    if (hitbox.y >= other.hitbox.y+other.hitbox.height
      || hitbox.y+hitbox.height <= other.hitbox.y) {
        return false;
    }
    if (hitbox.x >= other.hitbox.x+other.hitbox.width
      || hitbox.x+hitbox.width <= other.hitbox.x) {
        return false;
    }
    return true;
}
}