package entity.Objects;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class OBJ_Purugly extends superObject{
    public OBJ_Purugly(){
        name = "Purugly";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/entity/img_OBJ/Purugly_stand_1.gif"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }

}
