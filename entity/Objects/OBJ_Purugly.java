package entity.Objects;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class OBJ_Purugly extends superObject{
    public BufferedImage img1,img2,img3;
    public OBJ_Purugly(){
        name = "Purugly";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/entity/img_OBJ/purugly_stand_1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }

    public void getPokemonImg(){
        //img Purugly
        try{
            img1=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_up_1.png"));
            img2=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_up_2.png"));
            img3=ImageIO.read(getClass().getResourceAsStream("/entity/PW/potter_down_1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
