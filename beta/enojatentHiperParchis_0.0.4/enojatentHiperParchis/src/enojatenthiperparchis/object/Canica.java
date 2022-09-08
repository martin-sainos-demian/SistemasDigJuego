
package enojatenthiperparchis.object;

import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Canica extends Object {

    public Canica(float x, float y, int id, Player player) {
        super(x, y, id, player.getState());
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }
}