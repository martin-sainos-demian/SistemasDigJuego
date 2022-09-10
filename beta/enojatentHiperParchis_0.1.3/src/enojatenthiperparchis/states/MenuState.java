
package enojatenthiperparchis.states;

import enojatenthiperparchis.All;
import enojatenthiperparchis.Game;
import enojatenthiperparchis.object.Boton;
import enojatenthiperparchis.object.Mouse;
import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State {
    private Mouse mouse;
    private Boton[] botones;
    private All all;
    
    public MenuState(Game game){
        super(game);
        all=game.getAll();
        mouse=new Mouse(all,0,this, game.mouseInput);
        botones=new Boton[1];
        botones[0]=new Boton(game.getAll()
                ,(all.getScreenWidth())/2,0,all.getDefaultWidth()*2
                ,all.getDefaultHeight(),1,this,mouse,null)
                {@Override
                public void clicked(){
                    System.out.println("uwu");
                    game.nextState();
                }};
        
        
    }
    
    @Override
    public void tick() {
        for(Boton b : botones){
            b.tick();
        }
        mouse.tick();
    }

    @Override
    public void render(Graphics g) {
        for(Boton b : botones){
            b.render(g);
        }
        mouse.render(g);
    }
    
}
