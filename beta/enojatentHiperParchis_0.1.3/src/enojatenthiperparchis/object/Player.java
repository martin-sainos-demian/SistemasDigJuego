
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Player extends Object {

    public Player(All all, float x, float y, int id, Table table) {
        super(all, x, y, id, table.getState());
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}