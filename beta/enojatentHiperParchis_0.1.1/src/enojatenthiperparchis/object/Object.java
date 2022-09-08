
package enojatenthiperparchis.object;

import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public abstract class Object {
    float x, y;
    int id;
    State state;
    
    public Object(float x, float y, int id, State state){
        this.x=x;
        this.y=y;
        this.id=id;
        this.state=state;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
}