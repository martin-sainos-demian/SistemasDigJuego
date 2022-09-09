/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enojatenthiperparchis;

/**
 *
 * @author PC
 */
public class All {
    static Game game;
    
    public All(Game game){
        this.game=game;
    }
    
    public static int getDefaultWidth(){
        return game.getSprites().getDefaultWidth();
    }
    public static int getDefaultHeight(){
        return game.getSprites().getDefaultHeight();
    }
}