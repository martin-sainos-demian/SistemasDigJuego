
package enojatenthiperparchis.gfx;

import java.awt.image.BufferedImage;

public class Sprites {
    private static final int width=32 , height=32;
    public static BufferedImage boulder;
    
    public Sprites(){
        Divide sheet = new Divide(ImageLoader.loadImage("res/img/sprites.png"));
        
        boulder=sheet.crop(0, 0, width, height);
    }
    
    public static int getDefaultWidth(){
        return width;
    }
    public static int getDefaultHeight(){
        return height;
    }
}