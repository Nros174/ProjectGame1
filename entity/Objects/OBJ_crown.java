package entity.Objects;
import java.io.IOException;
import javax.imageio.ImageIO;
public class OBJ_crown extends superObject{
    public OBJ_crown(){
        name = "crown";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/entity/img_OBJ/crown.gif"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
