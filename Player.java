import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Player {
   private static int x;
   private static int y;
   private static int speed = 0;//speed walk
//    private static LinkedList<Maze> m = Maze.getMazeB();
    private KeyInput key ;
    public Player(int x,int y){
        this.x = x;
        this.y = y;
    }

    //walk
    public void update(){
        if(key.RP == true){
            x += speed;
        }
        else if(key.LP == true){
            x -= speed;
        }
        else if(key.UP == true){
            y -= speed;
        }
        else if(key.DP == true){
            y +=speed;
        }

        if(x<0){
            x = 0;
        }else if(y<0){
            y=0;
        }else if(x>915){
            x=915;
        }else if(y>650){
            y=650;
        }
        colision();
    }

    //draw player
    public void drawP(Graphics2D g2d){
        g2d.setColor(Color.PINK);
        g2d.fillRect(x,y,32,32);//draw solid box
        g2d.draw(getBounds());
    }

    public static Rectangle getBounds(){
        Rectangle playerB = new Rectangle(x,y,32,32);
        return playerB;
    }

    //player meet enemy
    public static void colision() {
        //player and maze
        // for(Maze i : m){
        //     if(getBounds().intersects(i.getBounds())){
        //         speedx = 2;
        //         speedy = 2;
        //         x-=speedx;
        //         y-=speedy;
                
                
        //     }
        // }
        //player and enemy
        if(getBounds().intersects(Enemy.getBounds())){
            System.out.println("!!!!");
            
        }
        
        // for(Maze i : m){
        //     if(Enemy.getBounds().intersects(i.getBounds())){
        //         Enemy.getspeedx = -2;
                
        //     }
        // }
    }

}
