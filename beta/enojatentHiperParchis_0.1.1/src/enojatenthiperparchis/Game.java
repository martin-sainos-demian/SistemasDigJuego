
package enojatenthiperparchis;

import enojatenthiperparchis.gfx.Display;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game {
    static String titulo;
    static int width, heigth;
    static Display display;
    static BufferStrategy buffer;
    static Graphics g;
    
    static boolean running=false;
    
    public Game(String titulo, int width, int heigth){
        this.titulo=titulo;
        this.width=width;
        this.heigth=heigth;
        
        display=new Display(titulo,width,heigth);
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
        
    }
    public static void render(){
        System.out.println("uwu");
        buffer=display.getCanvas().getBufferStrategy();
        if(buffer==null){
            display.getCanvas().createBufferStrategy(2);
            buffer=display.getCanvas().getBufferStrategy();
        }
        g=buffer.getDrawGraphics();
        g.setColor(new Color(255,0,0));
        g.fillRect(0, 0, width, heigth);
        //Dibujar
        
        g.setColor(new Color(0,0,200));
        g.fillRect(0, 0, width/2, heigth);
        //Fin del dibujo
        buffer.show();
        g.dispose();
    }
}