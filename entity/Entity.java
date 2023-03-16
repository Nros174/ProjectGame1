package entity;
import java.awt.image.BufferedImage;
public class Entity {
    public int WorldX,WorldY;

    public int speed;//speed walk

    public BufferedImage U1,U2,D1,D2,L1,L2,R1,R2;
    public String direction;

    public int spriteCounter = 0;
    public int spritNum = 1;
}
