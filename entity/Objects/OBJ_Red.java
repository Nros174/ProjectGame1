package entity.Objects;
import java.io.IOException;
import javax.imageio.ImageIO;
public class OBJ_Red extends superObject{
    public OBJ_Red(){
        name = "Red";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/entity/img_OBJ/red_stand_1.gif"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
