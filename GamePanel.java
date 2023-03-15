import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JPanel;
public class GamePanel extends JPanel {
    public static final int originalTilesize =16;//size image
    public static final int scale = 3;
    public static final int titleSize = originalTilesize*scale;//on frame
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow =  12;
    public static final int screenWidth = titleSize*maxScreenCol; //760
    public static final int screenHeight = titleSize*maxScreenRow; //576

    Thread gameTread;//do until stop // again and again 60 : 1sec
    GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        Color MazecColor = new Color(95,195,20);
        this.setBackground(MazecColor);
        this.setDoubleBuffered(true); // for better render
        
    }


}
