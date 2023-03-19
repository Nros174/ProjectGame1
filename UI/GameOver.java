package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import Main.GamePanel;
import entity.Players;
public class GameOver {
    GamePanel GP;
    Font arial_40;
    Graphics2D g2d;
    int fontsize=110;


    public GameOver(GamePanel GP){
        this.GP=GP;
        // arial_40 = new Font("Arial",Font.BOLD,40);  
    }

    public void drawGameOver(){
        g2d.setFont(arial_40);
        g2d.setColor(new Color(0,0,0,150));
        g2d.fillRect(0, 0, GP.screenWidth, GP.screenHeight);
        int x;
        int y;
        String text;
        g2d.setFont(g2d.getFont().deriveFont(Font.BOLD,fontsize));
        text = "Game Over";
        //shadow
        g2d.setColor(Color.black);
        x = GP.screenWidth/2-fontsize/2;
        y = GP.screenHeight/2-(GP.titleSize*4);
        g2d.drawString(text, x, y);
        //Main
        g2d.setColor(Color.black);
        g2d.drawString(text, x-4, y-4);
    }
    
}
