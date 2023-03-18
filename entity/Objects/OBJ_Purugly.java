package entity.Objects;
import java.io.IOException;
import javax.imageio.ImageIO;
public class OBJ_Purugly extends superObject{
    public OBJ_Purugly(){
        name = "crown";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/entity/img_OBJ/purugly_stand_1.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
