package Main;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import BG.BGManager;
import entity.Players;
import entity.Objects.superObject;
import Even.QuizGame;
public class GamePanel extends JPanel implements Runnable {
    private QuizGame quizGame;  
    public static final int originalTilesize =16;//size image 16*16
    public static final int scale = 3;
    public static final int titleSize = originalTilesize*scale;//on frame
    public static final int maxScreenCol = 20;
    public static final int maxScreenRow =  16;
    public static final int screenWidth = titleSize*maxScreenCol; //760
    public static final int screenHeight = titleSize*maxScreenRow; //576
    public static int scorecount;
    private int pokemoncount;
    
    Thread loop;//do until stop // again and again 60 : 1sec
    int FPS = 60;
    KeyInput key = new KeyInput();

    public Players player = new Players(this, key);

    //World setting
    BGManager BGM = new  BGManager(this);
    public final int maxWorldCol  = 50;
    public final int maxWorldRow  = 50;
    public final int maxWorldWidth  = titleSize*maxScreenCol;
    public final int maxWorldHight  = titleSize*maxScreenRow;
    
    public CollisionChecker Checker = new CollisionChecker(this);

    public superObject obj[] = new superObject[10];
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);

    public GamePanel(){
        scorecount=0;
        pokemoncount=0;
        // this.quizGame=quizGame;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // for better render
        this.addKeyListener(key);
        setupGame();
        startGame();
        setFocusable(true);
        
    }

    public void setupGame(){
        aSetter.setObject();
    }

    public void startGame(){
        loop = new Thread(this);
        loop.start();
    }

    //walk
    public void update(){
        player.update();
    }

    //increase score
    public void increasescore(){
        scorecount++;
        pokemoncount++;
    }

     //foever run      
    @Override
    public void run() {
        //FPS
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;
        while (loop != null) {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update(); //update player
                repaint(); //draw again
                delta --;
                drawCount++;
            }
            if(timer>=1000000000){
                System.out.println("FPS : "+drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
     }

      //camera
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        BGM.draw(g2d);//BG
        for(int i =0;i<obj.length;i++){
            if(obj[i] != null ){
                obj[i].draw(g2d,this);
            }  
        }//obj
        player.drawPlayer(g2d);//create player
        // if(pokemoncount==3){
        // ui.draw(g2d);
        // }
        //UI
        // if(countscoreforGP.score == 3){
        //     ui.draw(g2d);
        // }
        // if(countpokemon.countpokemonentity == 3 ){
        //     System.out.println("HI");

        // }
            
        
        g2d.dispose();//delete
    }


}
