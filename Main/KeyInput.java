package Main;
import java.awt.event.KeyListener;
//event keybort
import java.awt.event.KeyEvent;
public class KeyInput implements KeyListener {

    public boolean UP,DP,LP,RP;

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    //hold button
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT||key ==KeyEvent.VK_D){
           RP = true;
        }
        if(key == KeyEvent.VK_LEFT||key ==KeyEvent.VK_A){
            LP = true;
        }
        if(key == KeyEvent.VK_DOWN||key ==KeyEvent.VK_S){
            DP = true;
        }
        if(key == KeyEvent.VK_UP||key ==KeyEvent.VK_W){
            UP = true;
        }
       
    }

    //leleas button
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT||key ==KeyEvent.VK_D){
            RP = false;
         }
         if(key == KeyEvent.VK_LEFT||key ==KeyEvent.VK_A){
             LP = false;
         }
         if(key == KeyEvent.VK_DOWN||key ==KeyEvent.VK_S){
             DP = false;
         }
         if(key == KeyEvent.VK_UP||key ==KeyEvent.VK_W){
             UP = false;
         }
    }

    
}
