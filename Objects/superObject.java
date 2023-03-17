package Objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Main.GamePanel;
public class superObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int WorldX,WorldY;

    public void draw(Graphics2D g2d , GamePanel GP){
            int screenX = WorldX - GP.player.WorldX + GP.player.screenX;
            int screenY = WorldY - GP.player.WorldY + GP.player.screenY;

            if (WorldX + GP.titleSize > GP.player.WorldX - GP.player.screenX
                    && WorldX - GP.titleSize < GP.player.WorldX + GP.player.screenX
                    && WorldY + GP.titleSize > GP.player.WorldY - GP.player.screenY
                    && WorldY - GP.titleSize < GP.player.WorldY + GP.player.screenY) {
                    g2d.drawImage(image, screenX, screenY, GP.titleSize, GP.titleSize, null);
            }
    }
}
