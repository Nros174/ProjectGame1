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
        int entityLeftWoldX = entity.WorldX + entity.solidArea.x;
        int entityRightWoldX = entity.WorldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWoldY = entity.WorldY + entity.solidArea.y;
        int entityBottomWoldY = entity.WorldY + entity.solidArea.y + entity.solidArea.height;

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
    //Chack obj and palyer
    public int checkOBJ(Entity entity,boolean player) {
         int index = 999;
         for(int i=0;i<GP.obj.length;i++){
            if(GP.obj[i] != null){
                entity.solidArea.x = entity.WorldX + entity.solidArea.x;
                entity.solidArea.y = entity.WorldY + entity.solidArea.y;

                GP.obj[i].solidArea.x = GP.obj[i].WorldX + GP.obj[i].solidArea.x;
                GP.obj[i].solidArea.y = GP.obj[i].WorldY + GP.obj[i].solidArea.y;
                int BGNum1 , BGNum2;
        switch(entity.direction){
            case "up":
            entity.solidArea.y -= entity.speed;
            if(entity.solidArea.intersects(GP.obj[i].solidArea)){
                if(GP.obj[i].collision == true){
                    entity.collisionOn = true;
                }
                if(player == true){
                    index = i;
                }
            }
            break;
            case "down":
            entity.solidArea.y += entity.speed;
            if(entity.solidArea.intersects(GP.obj[i].solidArea)){
                if(GP.obj[i].collision == true){
                    entity.collisionOn = true;
                }
                if(player == true){
                    index = i;
                }
            }
            break;
            case "left":
            entity.solidArea.x -= entity.speed;
            if(entity.solidArea.intersects(GP.obj[i].solidArea)){
                if(GP.obj[i].collision == true){
                    entity.collisionOn = true;
                }
                if(player == true){
                    index = i;
                }
            }
            break;
            case "right":
            entity.solidArea.x += entity.speed;
            if(entity.solidArea.intersects(GP.obj[i].solidArea)){
                if(GP.obj[i].collision == true){
                    entity.collisionOn = true;
                }
                if(player == true){
                    index = i;
                }
            }


            break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultX;
        GP.obj[i].solidArea.x = entity.solidAreaDefaultX;
        GP.obj[i].solidArea.y = entity.solidAreaDefaultY;
            }
            
        }

         return index;
    }
}
