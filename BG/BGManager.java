package BG;
import Main.GamePanel;
import java.io.IOException;
import javax.imageio.ImageIO;
public class BGManager {
    GamePanel GP;
    BG[] BG;
    public BGManager(GamePanel GP){
        this.GP =GP;
        BG = new BG[10];
        getBGImg();
    }
    public void getBGImg() {
        try {
            BG[0] = new BG();
            BG[0]= ImageIO.read(getClass().getResourceAsStream("/img_BG/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
