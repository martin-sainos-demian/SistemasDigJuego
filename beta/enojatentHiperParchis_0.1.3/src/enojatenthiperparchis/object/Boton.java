/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import static enojatenthiperparchis.object.Canica.getState;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author PC
 */
public class Boton extends Object{
    
    private Mouse mouse;
    boolean hovered=false, clicked=false;
    BufferedImage images[];
    
    public Boton(All all, float x, float y, int width, int height, int id, State state, Mouse mouse, BufferedImage[] images){
        super(all, x, y, id, state, width, height);
        this.mouse=mouse;
        this.images=images;
    }

    @Override
    public void tick() {
        if(super.hitbox.contains(mouse.x, mouse.y)){
            hovered=true;
            if(mouse.left){
                clicked=true;
            } else {
                clicked=false;
            }
        } else {
            hovered=false;
        }
        if(hovered){
            hovered();
        }
        if(clicked){
            clicked();
        }
        
    }

    @Override
    public void render(Graphics g) {
        if(images!=null){
            if(images.length>2){
                if(images[0]!=null&&!hovered){
                    g.drawImage(images[0], (int)x, (int)y, null);
                }
                if(images[1]!=null&&hovered){
                    g.drawImage(images[1], (int)x, (int)y, null);
                }
                if(images[2]!=null&&clicked){
                    g.drawImage(images[2], (int)x, (int)y, null);
                }
            } else {
                g.drawImage(all.sprites().botonDef, (int)x, (int)y, null);
            }
        } else {
            g.drawImage(all.sprites().botonDef, (int)x, (int)y, null);
        }
    }
    
    public void hovered(){};
    public void clicked(){};
}
