package entity.Objects;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import Main.GamePanel;
public class superObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int WorldX,WorldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDafaultX = 0;
    public int solidAreaDafaultY = 0;
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
