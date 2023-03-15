
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Enemy {
private static int x;
private static int y;
public static int getspeedx;
private int speedx=2;
    Enemy(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void drawE(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, 100, 100);
    }

    public void updateE() {
        x+=speedx;
        if(x>Window.WIDTH-100){
            speedx=-2;
        }else if(x<0){
            speedx=2;
        }
        
    }

    public static int getspeeed(int speedx){
            return speedx;
    }

    public static Rectangle getBounds(){
        Rectangle enemyB =new Rectangle(x,y,100,100);
        return enemyB;
    }
}
