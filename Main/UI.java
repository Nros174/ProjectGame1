package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    GamePanel gp;
    Font arial_40;

    public UI(GamePanel gp){
        this.gp=gp;
        arial_40 = new Font("Arial",Font.BOLD,40);  
    }

    public void draw(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("END GAME!!!!! SCORE =  "+gp.player.score,50,50);
    }
    
}
