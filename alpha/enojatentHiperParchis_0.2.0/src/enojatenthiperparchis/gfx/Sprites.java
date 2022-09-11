
package enojatenthiperparchis.gfx;

import java.awt.image.BufferedImage;

public class Sprites {
    private static final int width=32 , height=32;
    
    public static BufferedImage mouse, botonDef;
    public static BufferedImage boulder;
    public static BufferedImage hueco, huecoFront, huecoBack, sinHueco;
    
    public Sprites(){
        Divide sheet = new Divide(ImageLoader.loadImage("res/img/sprites.png"));
        
        boulder=sheet.crop(0, 0, width, height);
        mouse=sheet.crop(width, 0, width, height);
        botonDef=sheet.crop(0, height, width*2, height);
        
        hueco=sheet.crop(0, height*2, width, height);
        huecoFront=sheet.crop(width, height*2, width, height);
        huecoBack=sheet.crop(width*2, height*2, width, height);
        sinHueco=sheet.crop(width*3, height*2, width, height);
    }
    
    public static int getDefaultWidth(){
        return width;
    }
    public static int getDefaultHeight(){
        return height;
    }
}