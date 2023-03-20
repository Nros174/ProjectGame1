package entity;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Entity {
    public int WorldX,WorldY;

    public int speed;//speed walk

    public BufferedImage U1,U2,D1,D2,L1,L2,R1,R2;
    public String direction;//direction player

    public int spriteCounter = 0; //distance
    public int spritNum = 1;//Step?

    public Rectangle solidArea;
    public int solidAreaDefaultX , solidAreaDefaultY;
    public boolean collisionOn = false;
}
