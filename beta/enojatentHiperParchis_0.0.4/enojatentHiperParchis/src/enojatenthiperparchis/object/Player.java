
package enojatenthiperparchis.object;

import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Player extends Object {

    public Player(float x, float y, int id, Table table) {
        super(x, y, id, table.getState());
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }
}