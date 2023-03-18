package Main;
import javax.swing.*;
import javax.swing.JPanel;

public class Window extends JPanel{

    private JFrame Window1;
    private GamePanel GamePanel;
    public Window(){
        Window1 = new JFrame("Potter Find the Po");
        GamePanel = new GamePanel();
        Window1.setResizable(false);//zoom in zoom out
        Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window1.add(GamePanel);
        Window1.pack();
        Window1.setLocationRelativeTo(null);//set window to center
        Window1.setVisible(true);
    }
    
}
