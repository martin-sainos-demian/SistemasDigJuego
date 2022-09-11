/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author PC
 */
public class Casilla extends Object {

    public Canica canica;
    public boolean hueco=false;
    Table table;
    
    public Casilla(All all, float x, float y, int id, Table table){
        super(all, x, y, id, table.getState());
        this.table=table;
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
    public void render(Graphics g){
        render(g,all.sprites().huecoFront[0],all.sprites().huecoBack[0]);
    }
    public void render(Graphics g, BufferedImage front, BufferedImage back) {
        int playerId=-1;
        for(Player p:table.players){
            for(Canica c:p.bolsa){
                if(c==canica){
                    playerId=p.id;
                }
            }
        }
        if(hueco){
            g.drawImage(back,(int)x,(int)y,null);
            if(canica!=null){
                if(playerId!=-1)
                    canica.render(g, true,playerId);
                else
                    canica.render(g, true);
            }
            g.drawImage(front,(int)x,(int)y,null);    
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
