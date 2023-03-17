package Main;

import BG.BG;
import entity.Entity;

public class CollisionChecker {
    GamePanel GP;
    public CollisionChecker(GamePanel GP ){
        this.GP = GP;
    }
    //check player(soliArea) and tree
    public void CheckBG(Entity entity){
        int entityLeftWoldX = entity.WorldX + entity.soidArea.x;
        int entityRightWoldX = entity.WorldX + entity.soidArea.x + entity.soidArea.width;
        int entityTopWoldY = entity.WorldY + entity.soidArea.y;
        int entityBottomWoldY = entity.WorldY + entity.soidArea.y + entity.soidArea.height;

        int entityLeftCol = entityLeftWoldX/GP.titleSize;
        int entityRightCol = entityRightWoldX/GP.titleSize;
        int entityTopRow = entityTopWoldY/GP.titleSize;
        int entitybottomRow = entityBottomWoldY/GP.titleSize;

        int BGNum1 , BGNum2;
        switch(entity.direction){
            case "up":
            entityTopRow = (entityTopWoldY - entity.speed) / GP.titleSize;
            BGNum1 = GP.BGM.mapBGNUM[entityLeftCol][entityTopRow];
            BGNum2 = GP.BGM.mapBGNUM[entityRightCol][entityTopRow];
            if(GP.BGM.BG[BGNum1].collision == true||GP.BGM.BG[BGNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
            case "down":
            entitybottomRow = (entityBottomWoldY + entity.speed) / GP.titleSize;
            BGNum1 = GP.BGM.mapBGNUM[entityLeftCol][entitybottomRow];
            BGNum2 = GP.BGM.mapBGNUM[entityRightCol][entitybottomRow];
            if(GP.BGM.BG[BGNum1].collision == true||GP.BGM.BG[BGNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
            case "left":
            entityLeftCol = (entityLeftWoldX - entity.speed) / GP.titleSize;
            BGNum1 = GP.BGM.mapBGNUM[entityLeftCol][entityTopRow];
            BGNum2 = GP.BGM.mapBGNUM[entityLeftCol][entitybottomRow];
            if(GP.BGM.BG[BGNum1].collision == true||GP.BGM.BG[BGNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
            case "right":
            entityRightCol = (entityRightWoldX + entity.speed) / GP.titleSize;
            BGNum1 = GP.BGM.mapBGNUM[entityRightCol][entityTopRow];
            BGNum2 = GP.BGM.mapBGNUM[entityRightCol][entitybottomRow];
            if(GP.BGM.BG[BGNum1].collision == true||GP.BGM.BG[BGNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        }
    }
}
