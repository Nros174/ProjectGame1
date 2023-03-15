import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Rectangle;
public class GamePanel extends JPanel implements Runnable {
    public static final int originalTilesize =16;//size image
    public static final int scale = 3;
    public static final int titleSize = originalTilesize*scale;//on frame
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow =  12;
    public static final int screenWidth = titleSize*maxScreenCol; //760
    public static final int screenHeight = titleSize*maxScreenRow; //576
    
    Thread loop;//do until stop // again and again 60 : 1sec
    Enemy enemy;
    

    private static int x = 100;
    private static int y = 100;
    private static int speed = 2;//speed walk
    KeyInput key = new KeyInput();

    GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        Color MazecColor = new Color(95,195,20);
        this.setBackground(MazecColor);
        this.setDoubleBuffered(true); // for better render
        this.addKeyListener(key);
        
        startGame();
        enemy = new Enemy(300, 300);
        setFocusable(true);
        
    }

    public void startGame(){
        loop = new Thread(this);
        loop.start();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        drawPlayer(g2d);//create player
        enemy.drawE(g2d);//create enemy
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
    }

    //draw player
    public void drawPlayer(Graphics2D g2d){
        g2d.setColor(Color.PINK);
        g2d.fillRect(x,y,GamePanel.titleSize,GamePanel.titleSize);//draw solid box
        g2d.dispose();

    }


    //player meet enemy
    public static void colision() {
  
   
    }

     //foever run
     @Override
     public void run() {
         // double drawInterval = 1000000000/FPS;
         // double nextDrawTime = System.nanoTime()+drawInterval;
         while (loop != null) {
             System.out.println("in loop");
             update();
             enemy.updateE();
             // try {
             //     double remainingTime = nextDrawTime - System.nanoTime();
             //     remainingTime = remainingTime/1000000;
             //     Thread.sleep((long)remainingTime);
             // } catch (InterruptedException e) {
             //     e.printStackTrace();
             // }
             repaint();
         }
         
     }


}
