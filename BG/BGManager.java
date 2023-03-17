package BG;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

import java.awt.Graphics2D;
public class BGManager {
    GamePanel GP;
    BG[] BG;
    int mapBGNUM[][];
    public BGManager(GamePanel GP){
        this.GP =GP;
        BG = new BG[10];
        mapBGNUM = new int[GP.maxWorldCol][GP.maxWorldRow];
        getBGImg();
        loadMap("/Map/World.txt");//map maze
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
            while(col<GP.maxWorldCol&& row<GP.maxWorldRow){
                String line = br.readLine();
                while(col<GP.maxWorldCol){
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapBGNUM[col][row] =num;
                    col++;
                }
                if(col == GP.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            
        }
    }
    public void draw(Graphics2D g2d){
        int Worldcol =0;
        int Worldrow =0;

        while(Worldcol<GP.maxWorldCol&& Worldrow<GP.maxWorldRow){
            int BGNum = mapBGNUM[Worldcol][Worldrow];
            int WorldX = Worldcol *GP.titleSize;
            int WorldY = Worldrow *GP.titleSize;
            int screenX = WorldX-GP.player.WorldX+GP.player.screenX;
            int screenY = WorldY-GP.player.WorldY+GP.player.screenY;
            g2d.drawImage(BG[BGNum].image,screenX,screenY,GP.titleSize,GP.titleSize,null);
            Worldcol++;

            if(Worldcol == GP.maxWorldCol){
                Worldcol = 0;
                Worldrow++;
            }
        }
    }
}
