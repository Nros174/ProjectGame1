package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class UI {
    GamePanel GP;
    Font arial;
    Font bebause;
    BufferedImage Pokeball;
    
    GamePanel position;

    public UI(GamePanel GP){
        this.GP=GP;
        arial = new Font("Arial",Font.BOLD,25);
        bebause = new Font("Bebas Neue",Font.BOLD,25);
        try {
            Pokeball = ImageIO.read(getClass().getResourceAsStream("/UI/Pokeball.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endgame(Graphics2D g2d){
        g2d.setColor(new Color(0,0,0));
        g2d.fillRoundRect(0, 0, 1000, 1000, 0,0);
        g2d.setFont(arial);
        g2d.setColor(Color.white);
        g2d.drawString("END GAME CONGRATULATION YOU CAN LEAVE NOW HIT THE X BUTTON :)",25,position.screenHeight/2);
        
        
    }

    public void crowndetect(Graphics2D g2d){
        g2d.setColor(new Color(0,0,0,200));
        g2d.fillRoundRect(position.screenWidth/2-200, 650, 400, 100, 35,35);
        
        g2d.setFont(bebause);
        g2d.setColor(Color.black);
        g2d.drawString("FIND THE POKEMON",position.screenWidth/2-120,710);
        g2d.setColor(Color.white);
        g2d.drawString("FIND THE POKEMON",position.screenWidth/2-124,710);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        g2d.drawImage(Pokeball, GP.titleSize/2, GP.titleSize/2, GP.titleSize,GP.titleSize,null);

        g2d.setFont(bebause);
        g2d.setColor(Color.black);
        g2d.drawString(" X "+GP.PokemonCount,74,52);
        g2d.setColor(Color.white);
        g2d.drawString(" X "+GP.PokemonCount,74-4,52-1);
    }

}
