
package enojatenthiperparchis.object;

import enojatenthiperparchis.All;
import enojatenthiperparchis.round.Round;
import enojatenthiperparchis.states.State;
import java.awt.Graphics;

public class Table extends Object{

    Casilla casillas[][];
    int esp;
    public Player players[];
    int inicial;
    
    public Table(All all, float x, float y, int espacios, int id, Round round, int inicial) {
        super(all, x, y, id, round.getState());
        this.esp=espacios+2;
        this.inicial=inicial;
        this.players=players;
        casillas=new Casilla[(esp*2)+3][(esp*2)+3];
    }
    
    public void innit(){
        for(int x=0;x<casillas.length;x++){
            for(int y=0;y<casillas[x].length;y++){
                casillas[x][y]=new Casilla(all,x*all.getDefaultWidth(),y*all.getDefaultHeight()*2/3
                        ,id+(x*casillas[x].length+y),this);
            }
        }
        
        casillas[1][1].hueco=true;
        for(int i=1;i<casillas.length-1;i++){
            casillas[i][esp+1].hueco=true;
            casillas[i][esp-1].hueco=true;
            casillas[i][esp+3].hueco=true;
            casillas[esp+1][i].hueco=true;
            casillas[esp-1][i].hueco=true;
            casillas[esp+3][i].hueco=true;
        }
        for(int i=1;i<casillas.length-1;i++){
            casillas[i][esp].hueco=false;
            casillas[i][esp+2].hueco=false;
            casillas[esp][i].hueco=false;
            casillas[esp+2][i].hueco=false;
        }
        for(int i=0;i<5;i++){
            casillas[esp-1+i][1].hueco=true;
            casillas[esp-1+i][casillas.length-2].hueco=true;
            casillas[1][esp-1+i].hueco=true;
            casillas[casillas.length-2][esp-1+i].hueco=true;
        }
        
        for(int p=0;p<players.length;p++){
            Canica bolsa[]=new Canica[inicial];
            for(int c=0;c<bolsa.length;c++){
                bolsa[c]=new Canica(all,(c+1)*All.getDefaultWidth(),(p+1)*All.getDefaultWidth(),c,players[p]);
            }
            players[p].setBolsa(bolsa);
        }
        
        settleCanicas();
    }

    public void settleCanicas(){
        for(Casilla[] x:casillas){
            for(Casilla y:x){
                y.canica=null;
            }
        }
        for(Player p:players){
            for(Canica c:p.getBolsa()){
                c.assigned=false;
                for(Casilla[] x:casillas){
                    for(Casilla y:x){
                        if(y.hueco&&y.canica==null
                                &&y.isOverlapping(c)&&!c.assigned){
                            y.setCanica(c);
                            c.x=y.x;
                            c.y=y.y;
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void tick() {
        super.updateHitbox();
        for(Player p:players){
            if(p!=null)
                p.tick();
        }
        for(Casilla[] x:casillas){
            for(Casilla y:x){
                if(y!=null)
                    y.tick();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        for(Casilla[] x:casillas){
            for(Casilla y:x){
                y.render(g);
            }
        }
        for(Player p:players){
            p.render(g);
        }
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

    public Player[] getPlayers() {
        return players;
    }
    public void setPlayers(Player[] players) {
        this.players=players;
    }
}