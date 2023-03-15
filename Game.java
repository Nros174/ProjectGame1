import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


import javax.swing.*;
public class Game  extends JPanel implements Runnable {
    Thread loop;
    Player player;
    Enemy enemy;
    // Maze maze;
    int FPS = 60;
    public Game(){
        startGame();
        // maze = new Maze();
        keybort();
        player = new Player(100, 100);
        enemy = new Enemy(300, 300);
        setFocusable(true);
    }

    private void keybort(){
        KeyInput key = new KeyInput();
        this.addKeyListener(key);
    }

    public void startGame(){
        loop = new Thread();
        loop.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
    //     g2d.drawString("HI GG", 400, 100);//drawtext
    //     g2d.drawRect(450, 200, 150, 50);//drawbox
        Color GroundColor = new Color(193,243,118);
        g2d.setColor(GroundColor);
        g2d.fillRect(0,0,Window.WIDTH,Window.HEIGHT);
        // maze.draw(g2d);
        player.drawP(g2d);//create player
        enemy.drawE(g2d);//create enemy
    }

    //foever run
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime()+drawInterval;
        while (loop != null) {
            System.out.println("in loop");
            player.update();
            enemy.updateE();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                Thread.sleep((long)remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
        
    }

}
