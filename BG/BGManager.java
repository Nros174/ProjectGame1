package BG;
import Main.GamePanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
public class BGManager {
    GamePanel GP;
    BG[] BG;
    int mapBGNUM[][];
    public BGManager(GamePanel GP){
        this.BG =BG;
        BG = new BG[10];
        mapBGNUM = new int[GP.maxScreenCol][GP.maxScreenRow];
        getBGImg();
        loadMap("/Map/map01.txt");//map maze
    }
    public void getBGImg() {
        try {
            BG[0] = new BG();
            BG[0].image= ImageIO.read(getClass().getResourceAsStream("/BG/img_BG/grass.png"));

            BG[1] = new BG();
            BG[1].image= ImageIO.read(getClass().getResourceAsStream("/BG/img_BG/earth.png"));

            BG[2] = new BG();
            BG[2].image= ImageIO.read(getClass().getResourceAsStream("/BG/img_BG/tree.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath ){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col =0;
            int row =0;
            while(col<GP.maxScreenCol&& row<GP.maxScreenRow){
                String line = br.readLine();
                while(col<GP.maxScreenCol){
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapBGNUM[col][row] =num;
                    col++;
                }
                if(col == GP.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2d){
        int col =0;
        int row =0;
        int x =0;
        int y =0;

        while(col<GP.maxScreenCol&& row<GP.maxScreenRow){
            int BGNum = mapBGNUM[col][row];
            g2d.drawImage(BG[BGNum].image,x,y,GP.titleSize,GP.titleSize,null);
            col++;
            x+= GP.titleSize;

            if(col == GP.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y+= GP.titleSize;
            }
        }
    }
}
