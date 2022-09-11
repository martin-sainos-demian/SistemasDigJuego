
package enojatenthiperparchis;

import enojatenthiperparchis.gfx.*;
import enojatenthiperparchis.input.MouseInput;
import enojatenthiperparchis.states.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game {
    static String titulo;
    static int width, height;
    static Display display;
    static BufferStrategy buffer;
    static Graphics g;
    static State state;
    static State[] stateList;
    public static int currentStateId;
    static Sprites sprites;
    public MouseInput mouseInput;
    static All all;
    
    static boolean running=false;
    
    public Game(String titulo, int width, int height){
        this.titulo=titulo;
        this.width=width;
        this.height=height;
        
        mouseInput=new MouseInput();
        display=new Display(titulo,width,height);
        display.getFrame().addMouseListener(mouseInput);
        display.getFrame().addMouseMotionListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);
        display.getCanvas().addMouseMotionListener(mouseInput);
        
        
        
        sprites=new Sprites();
        all=new All(this);
        setStateList();
        currentStateId=0;
        state=stateList[currentStateId];
    }
    public static void run(){
        if(running){
            return;
        }
        else {
            running=true;
            while(running){
                tick();
                render();
            }
        }
    }
    
    public static void tick(){
        if(state!=null){
            state.tick();
        }
        
        width=display.getFrame().getWidth();
        height=display.getFrame().getHeight();
    }
    public static void render(){
        buffer=display.getCanvas().getBufferStrategy();
        if(buffer==null){
            display.getCanvas().createBufferStrategy(2);
            buffer=display.getCanvas().getBufferStrategy();
        }
        g=buffer.getDrawGraphics();
        g.setColor(new Color(167,54,169));
        g.fillRect(0, 0, width, height);
        //Dibujar
        state.render(g);
        //Fin del dibujo
        buffer.show();
        g.dispose();
    }

    public static Display getDisplay() {
        return display;
    }

    public static BufferStrategy getBuffer() {
        return buffer;
    }

    public static State getState() {
        return state;
    }

    public static Sprites getSprites() {
        return sprites;
    }
    
    void setStateList(){
        stateList=new State[2];
        stateList[0]=new MenuState(this);
        stateList[1]=new GameState(this);
    }
    
    public void nextState(){
        if(currentStateId+1>stateList.length){
            currentStateId=0;
        }
        else{
            currentStateId++;
        }
        state=stateList[currentStateId];
    }

    public static All getAll() {
        return all;
    }

}