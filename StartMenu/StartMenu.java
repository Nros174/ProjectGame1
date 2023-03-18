import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Main.GamePanel;
import Main.Window;

import java.awt.FlowLayout;
import java.awt.Font;

public class StartMenu extends JPanel implements ActionListener {
    
    private JFrame StartM;
    GamePanel GP;
    private JLabel Gamename;
    private JPanel panel,imgpanel;
    private JButton startButton, exitButton;
    private int widthbuttons=600;
    private int heightbuttons=100;
    private Icon img1,img2;

    
    
    public StartMenu() {
        StartM = new JFrame("Menu");
        StartM.setSize(760,576);
        StartM.setResizable(false);
        StartM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgpanel = new JPanel();
        panel = new JPanel();
        startgamenow();
        StartM.setVisible(true);
        setFocusable(true);
    }

    public void startgamenow(){
        Gamename = new JLabel(new String("WELCOME TO THE HELL"));
        Gamename.setFont(new Font("Bebas Neue", Font.BOLD, 50));
       // Gamename.setBounds(230,500,500,1000);
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(widthbuttons,heightbuttons));
        startButton.setIcon(img2);
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(widthbuttons,heightbuttons));
        try {
            img1 = new ImageIcon(getClass().getResource("BG/STARTGAME.png"));
            img2 = new ImageIcon(getClass().getResource("BG/EXISTGAME.png"));
            startButton.setIcon(img1);
            exitButton.setIcon(img2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        panel.setPreferredSize(new Dimension(300,215));
        panel.setBackground(Color.black);
        //panel.setLayout(new FlowLayout());
        //panel.setBounds(500,0,800,500);
        panel.add(startButton);
        panel.add(exitButton);

        // Create a JLabel with an ImageIcon as its content
        ImageIcon bgImage = new ImageIcon(getClass().getResource("BG/headgame.jpg"));
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());

        // Add the JLabel to the content pane of the JFrame
        StartM.getContentPane().add(bgLabel);

        // Set the position of the components manually
        Gamename.setBounds(200, 50, 500, 100);
        startButton.setBounds(250, 200, widthbuttons, heightbuttons);
        exitButton.setBounds(450, 200, widthbuttons, heightbuttons);
        panel.setBounds(200, 300, 300, 215);
        StartM.setLayout(new FlowLayout());
        StartM.add(Gamename);
        StartM.add(panel);
        startButton.addActionListener(this);
        exitButton.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if (source == startButton) {
            // Code to start the game
            System.out.println("HI");
            Window newGame = new Window();
            newGame.setVisible(true);  
            StartM.setVisible(false);          
            
            // dispose(); // Close the start menu window
        } else if (source == exitButton) {
            // dispose(); // Close the start menu window
            System.exit(0); // Exit the application
        }
    }
}

