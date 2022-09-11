/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import java.awt.Graphics;

/**
 *
 * @author PC
 */
public class Casilla extends Object {

    public Canica canica;
    public boolean hueco=false;
    
    public Casilla(All all, float x, float y, int id, Table table){
        super(all, x, y, id, table.getState());
    }
    public Casilla(All all, float x, float y, int id, Table table, boolean hueco){
        this(all,x,y,id,table);
        this.hueco=hueco;
    }
    
    @Override
    public void tick() {
        super.updateHitbox();
        if(!hueco){
            canica=null;
        }
    }

    @Override
    public void render(Graphics g) {
        if(hueco){
            g.drawImage(all.sprites().huecoBack,(int)x,(int)y,null);
            if(canica!=null){
                canica.render(g, true);
            }
            g.drawImage(all.sprites().huecoFront,(int)x,(int)y,null);    
        }else{
            g.drawImage(all.sprites().sinHueco,(int)x,(int)y,null);
        }
    }
    
    public void setCanica(Canica canica){
        if(hueco){
            this.canica=canica;
            canica.assigned=true;
        }
        if(canica==null){
            this.canica.assigned=false;
        }
    }
}
