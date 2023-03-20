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
    Font TAGAMEBOY_1;
    Font TAGAMEBOY_2;
    BufferedImage Pokeball;
    
    GamePanel position;

    public UI(GamePanel GP){
        this.GP=GP;
        TAGAMEBOY_1 = new Font("TA Gameboy",Font.BOLD,30);
        TAGAMEBOY_2 = new Font("TA Gameboy",Font.BOLD,25);
        try {
            Pokeball = ImageIO.read(getClass().getResourceAsStream("/UI/Pokeball.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endgame(Graphics2D g2d){
        g2d.setColor(new Color(0,0,0));
        g2d.fillRoundRect(0, 0, 1000, 1000, 0,0);
        g2d.setFont(TAGAMEBOY_1);
        g2d.setColor(Color.white);
        g2d.drawString("END GAME CONGRATULATION!! ",155,position.screenHeight/2);
        g2d.drawString("YOU CAN LEAVE NOW HIT THE X BUTTON :)",45,position.screenHeight/2+50);
        
        
    }

    public void crowndetect(Graphics2D g2d){
        g2d.setColor(new Color(0,0,0,200));
        g2d.fillRoundRect(position.screenWidth/2-200, 650, 400, 100, 35,35);
        
        g2d.setFont(TAGAMEBOY_2);
        g2d.setColor(Color.black);
        g2d.drawString("FIND THE POKEMON",position.screenWidth/2-160,710);
        g2d.setColor(Color.white);
        g2d.drawString("FIND THE POKEMON",position.screenWidth/2-164,710);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        g2d.drawImage(Pokeball, GP.titleSize/2, GP.titleSize/2, GP.titleSize,GP.titleSize,null);

        g2d.setFont(TAGAMEBOY_2);
        g2d.setColor(Color.black);
        g2d.drawString(" X "+GP.PokemonCount,74,52);
        g2d.setColor(Color.white);
        g2d.drawString(" X "+GP.PokemonCount,74-4,52-1);
    }

}
