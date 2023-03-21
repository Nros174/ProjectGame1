package entity.Objects;
import java.io.IOException;
import javax.imageio.ImageIO;
public class OBJ_Suicun extends superObject{
    public OBJ_Suicun(){
        name = "Suicun";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/entity/img_OBJ/suicun_stand_1.gif"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
