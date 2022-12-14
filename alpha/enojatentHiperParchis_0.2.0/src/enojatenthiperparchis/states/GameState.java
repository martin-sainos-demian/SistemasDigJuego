
package enojatenthiperparchis.states;

import enojatenthiperparchis.All;
import enojatenthiperparchis.Game;
import enojatenthiperparchis.object.Mouse;
import enojatenthiperparchis.round.Round;
import java.awt.Graphics;

public class GameState extends State {

    Round round;
    All all;
    
    public GameState(Game game){
        super(game);
        all=game.getAll();
        mouse=new Mouse(all,0,this, game.mouseInput);
        round=new Round(game.getAll(),2,2,4,this);
    }
    
    @Override
    public void tick() {
        round.tick();
        mouse.tick();
    }

    @Override
    public void render(Graphics g) {
        round.render(g);
        mouse.render(g);
    }

}
