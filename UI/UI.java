package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Main.GamePanel;

public class UI {
    GamePanel gp;
    Font arial_40;
    Font bebause;
    // Font bebauseshadow;
    GamePanel position;

    public UI(GamePanel gp){
        this.gp=gp;
        arial_40 = new Font("Arial",Font.BOLD,25);
        bebause = new Font("Bebas Neue",Font.BOLD,25);
        // bebauseshadow = new Font("Bebas Neue",Font.BOLD,25);
    }

    public void endgame(Graphics2D g2){

        Color c = new Color(0,0,0);
        g2.setColor(c);
        // g2.fillRoundRect(position.screenWidth/2-200, 650, 400, 100, 35,35);
        g2.fillRoundRect(0, 0, 1000, 1000, 0,0);
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("END GAME CONGRATULATION YOU CAN LEAVE NOW HIT THE X BUTTON :)",25,position.screenHeight/2);
        
        
    }

    public void crowndetect(Graphics2D g2){
        // g2.setFont(bebauseshadow);
        Color c = new Color(0,0,0,220);
        g2.setColor(c);
        g2.fillRoundRect(position.screenWidth/2-200, 650, 400, 100, 35,35);
        
        g2.setFont(bebause);
        g2.setColor(Color.black);
        g2.drawString("FIND THE POKEMON",position.screenWidth/2-120,710);
        g2.setColor(Color.white);
        g2.drawString("FIND THE POKEMON",position.screenWidth/2-124,710);
    }
}
