package entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Window;
import java.io.IOException;
import javax.imageio.ImageIO;
import Even.QuizGame;
import Main.GamePanel;
import Main.KeyInput;
import UI.UI;

import java.awt.image.BufferedImage;
public class Players extends Entity{
    GamePanel GP;
    KeyInput key;
    Window Game;
    QuizGame QG;
    public UI ui;



    public final int screenX;
    public final int screenY;

    int Something = 0;

    public Players(GamePanel GP,KeyInput key,QuizGame QG,UI ui) {
        this.ui=ui;
        this.QG = QG;
        this.GP = GP;
        this.key = key;
        screenX = GP.screenWidth/2-(GP.titleSize/2);
        screenY = GP.screenHeight/2-(GP.titleSize/2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = GP.titleSize/2;
        solidArea.height = GP.titleSize/2;
        setdefaultValues();
        getPlayerImg();
    }

    public void getPlayerImg(){
        //img player
        try{
            U1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_up_1.png"));
            U2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_up_2.png"));
            D1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_down_1.png"));
            D2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_down_2.png"));
            L1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_left_1.png"));
            L2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_left_2.png"));
            R1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_right_1.png"));
            R2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_right_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //position and speed andwalk all map
    private void setdefaultValues() {
        WorldX = GP.titleSize*23;//start X
        WorldY = GP.titleSize*23;//Start Y
        speed = 4;
        direction= "down";
    }

    //walk
    public void update(){
        //player img
        if(key.UP==true||key.DP==true||key.LP==true||key.RP==true){
            if(key.RP == true){
                direction = "right";
            }
            else if(key.LP == true){
                direction= "left";

            }
            else if(key.UP == true){
                direction = "up";
            }
            else if(key.DP == true){
                direction = "down";
            }

            //check BG cillostion
            collisionOn = false;
            GP.Checker.CheckBG(this);

            //check OBJ and player
            int OBJIndex = GP.Checker.checkOBJ(this , true);
            pickUpObject(OBJIndex);
            //if collision is false player can move
            if(collisionOn == false){
                switch(direction){
                    case "up": WorldY -= speed; break;
                    case "down": WorldY +=speed; break;
                    case "left": WorldX -= speed; break;
                    case "right": WorldX += speed; break;
                }
            }
            //count step
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


    public void pickUpObject(int i){
        if(i != 999){
            String OBJName = GP.obj[i].name;
            switch(OBJName){
                case "crown": 
                GP.crownhit = true;
                break;
                case "Purugly" :
                GP.obj[i] = null;
                key.UP=false;
                key.DP =false;
                key.LP =false;
                key.RP =false;
                new QuizGame();
                break;
                case "Red" :
                GP.obj[i] = null;
                key.UP=false;
                key.DP =false;
                key.LP =false;
                key.RP =false;
                new QuizGame();
                break;
                case "Suicun" :
                key.UP=false;
                key.DP =false;
                key.LP =false;
                key.RP =false;
                GP.obj[i] = null;
                new QuizGame();
                break;

            }
            

        }
    }


     //draw player
     public void drawPlayer(Graphics2D g2d){
        //walk player img
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
        g2d.drawImage(image,screenX,screenY,GP.titleSize,GP.titleSize,null);//draw solid box

    }
}
