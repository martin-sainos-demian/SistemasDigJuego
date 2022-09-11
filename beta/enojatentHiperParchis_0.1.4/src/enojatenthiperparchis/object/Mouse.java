
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.input.MouseInput;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Mouse extends Object{   

    MouseInput mouseInput;
    public boolean left, right, clickLeft, clickRight;
    
    public Mouse(All all, int id, State state, MouseInput mouseInput){
        super(all,(float)all.getScreenWidth()/2, (float)all.getScreenHeight()/2, id, state);
        this.mouseInput=mouseInput;
    }
    
    @Override
    public void tick() {
        x=mouseInput.x;
        y=mouseInput.y;
        left=mouseInput.left;
        right=mouseInput.right;
        clickLeft=mouseInput.clickLeft;
        clickRight=mouseInput.clickRight;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(all.sprites().mouse, (int)x, (int)y, null);
    }
}