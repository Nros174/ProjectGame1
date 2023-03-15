import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
public class Window extends JPanel{

    private JFrame Window1;
    private GamePanel GamePanel;
    public Window(){
        Window1 = new JFrame("Inwtaigazaza007");
        GamePanel = new GamePanel();
        Window1.setResizable(false);//zoom in zoom out
        Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window1.add(GamePanel);
        Window1.pack();
        Window1.add(new Game());
        Window1.setLocationRelativeTo(null);//set window to center
        Window1.setVisible(true);//open window
    }
    
}
