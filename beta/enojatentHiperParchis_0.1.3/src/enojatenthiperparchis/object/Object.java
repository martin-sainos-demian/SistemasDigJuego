
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Object {
    float x, y;
    int id;
    State state;
    All all;
    Rectangle hitbox;
    
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
    
    public abstract void tick();
    public abstract void render(Graphics g);

}