package Main;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.UIDefaults.ProxyLazyValue;

import BG.BGManager;
import entity.Players;
public class GamePanel extends JPanel implements Runnable {
    public static final int originalTilesize =16;//size image 16*16
    public static final int scale = 3;
    public static final int titleSize = originalTilesize*scale;//on frame 48*48
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow =  12;
    public static final int screenWidth = titleSize*maxScreenCol; //760
    public static final int screenHeight = titleSize*maxScreenRow; //576
    
    Thread loop;//do until stop // again and again 60 : 1sec
    int FPS = 60;
    KeyInput key = new KeyInput();

    public Players player = new Players(this, key);

    //World setting
    BGManager BGM = new  BGManager(this);
    public final int maxWorldCol  = 50;
    public final int maxWorldRow  = 50;
    public final int maxWorldWidth  = titleSize*maxScreenCol;
    public final int maxWorldHight  = titleSize*maxScreenRow;

    GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true); // for better render
        this.addKeyListener(key);
<<<<<<< HEAD
        
        // startGame();
=======
        startGame();
>>>>>>> 3ec093e2054666da2b69641543bea82cfc16e3d0
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
        BGM.draw(g2d);
        player.drawPlayer(g2d);//create player
        g2d.dispose();
    }

    //walk
    public void update(){
        player.update();
    }

   


     //foever run      
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;
        while (loop != null) {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta --;
                drawCount++;
            }
            if(timer>=1000000000){
                System.out.println("FPS : "+drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
     }


}
