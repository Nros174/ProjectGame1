package entity;
import Main.GamePanel;
import Main.KeyInput;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Players extends Entity{
    GamePanel GP;
    KeyInput key;

    public Players(GamePanel GP,KeyInput key) {
        this.GP = GP;
        this.key = key;
        setdefaultValues();
        getPlayerImg();
    }

    public void getPlayerImg(){
        try{
            U1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_up_1.png"));
            U2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_up_2.png"));
            D1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_down_1.png"));
            D2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_down_2.png"));
            L1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_left_1.png"));
            L2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_left_2.png"));
            R1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_right_1.png"));
            R2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/boy_right_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void setdefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction= "down";
    }

    //walk
    public void update(){
        if(key.UP==true||key.DP==true||key.LP==true||key.RP==true){
            if(key.RP == true){
                direction = "right";
                x += speed;
            }
            else if(key.LP == true){
                direction= "left";
                x -= speed;
            }
            else if(key.UP == true){
                direction = "up";
                y -= speed;
            }
            else if(key.DP == true){
                direction = "down";
                y +=speed;
            }

            if(x<0){
                x = 0;
            }else if(y<0){
                y=0;
            }else if(x>GamePanel.screenWidth-50){
                x=GamePanel.screenWidth-50;
            }else if(y>GamePanel.screenHeight-50){
                y=GamePanel.screenHeight-50;
            }
            spriteCounter++;
            if(spriteCounter>20){
                if(spritNum==1){
                    spritNum=2;
                }else if(spritNum==2){
                    spritNum=1;
                }
                spriteCounter = 0;
            }
        }
    }

     //draw player
     public void drawPlayer(Graphics2D g2d){
        // g2d.setColor(Color.PINK);
        // g2d.fillRect(x,y,GamePanel.titleSize,GamePanel.titleSize);//draw solid box
        BufferedImage image = null;
        switch(direction){
            case"up":
            if(spritNum == 1){
                image = U1;
            }else if(spritNum == 2){
                image = U2;
            }
            break;

            case"down":
            if(spritNum == 1){
                image = D1;
            }else if(spritNum == 2){
                image = D2;
            }
            break;

            case"left":
            if(spritNum == 1){
                image = L1;
            }else if(spritNum == 2){
                image = L2;
            }
            break;

            case"right":
            if(spritNum == 1){
                image = R1;
            }else if(spritNum == 2){
                image = R2;
            }
            break;

            
                
        }
        g2d.drawImage(image,x,y,GamePanel.titleSize,GamePanel.titleSize,null);//draw solid box

    }
}
