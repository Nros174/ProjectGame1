package old;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
public class Maze extends JPanel{
    static LinkedList<Maze> m = new LinkedList<>();   
    Maze temp;
    private int x;
    private int y;
    private int w;
    private int h;
    
    
    Maze(){
        m.add(new Maze(300, 600,30,100));
        m.add(new Maze(100, 600,200,30));
        m.add(new Maze(100, 400,30,200));
        m.add(new Maze(100, 500,800,30));
        m.add(new Maze(400, 500,30,100));
        m.add(new Maze(850, 400,100,30));
        m.add(new Maze(600, 400,150,30));
        m.add(new Maze(250, 300,30,50));
    }

    Maze(int x,int y,int w,int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

    }

    public void draw(Graphics2D g2d) {
        for(int i =0;i<m.size();i++){
            temp=m.get(i);
            temp.drawM(g2d);
        }
    }

    public void drawM(Graphics2D g2d){
        Color MazecColor = new Color(95,195,20);
        g2d.setColor(MazecColor);
        g2d.fillRect(x,y,w,h);//draw solid box
        
    }

    public Rectangle getBounds() {
        Rectangle MB = new Rectangle(x,y,w,h);
        return MB;
    }

    public static LinkedList<Maze> getMazeB(){
        return m;
    }
}
