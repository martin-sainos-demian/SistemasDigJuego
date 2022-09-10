
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.round.Round;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Table extends Object{

    public Table(All all, float x, float y, int id, Round round) {
        super(all, x, y, id, round.getState());
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}