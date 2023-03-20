package Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends JPanel implements ActionListener {
    private JFrame frame;
    private ImageIcon bg,img1,img2;
    private JLabel myLabel;
    private JButton startButton,exitButton;
    GamePanel GP;

    public Start(){
        bg = new ImageIcon(getClass().getResource("/Main/StartMenu/Background1.gif"));
        myLabel = new JLabel(bg);
        myLabel.setSize(500, 288);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Main/StartMenu/BlackHead.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(115, 50, 470, 100);

        startButton = new JButton("Start");
        startButton.setBounds(250, 200, 200, 70);
        exitButton = new JButton("Exit");
        exitButton.setBounds(250, 300, 200, 70);

        try {
            img1 = new ImageIcon(getClass().getResource("/Main/StartMenu/STARTGAME1.png"));
            img2 = new ImageIcon(getClass().getResource("/Main/StartMenu/EXISTGAME1.png"));
            startButton.setIcon(img1);
            exitButton.setIcon(img2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        myLabel.add(imageLabel);
        myLabel.add(startButton);
        myLabel.add(exitButton);
        startButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        frame = new JFrame("Potter's Quiz");
        frame.add(myLabel);
        frame.setSize(700, 523);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//center
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if (source == startButton) {
            // Code to start the game
            Window newGame = new Window(); 
            newGame.setVisible(true);   
            frame.setVisible(false);          
        } else if (source == exitButton) {
            System.exit(0); // Exit the application
        }
    }
    
}
