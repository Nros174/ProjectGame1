package Main;

import entity.Objects.OBJ_Purugly;
import entity.Objects.OBJ_Red;
import entity.Objects.OBJ_Suicun;
import entity.Objects.OBJ_crown;

public class AssetSetter {
    GamePanel GP;
    public AssetSetter(GamePanel GP){
        this.GP = GP;
    }

    //set x y obj
    public void setObject(){
        GP.obj[0] = new OBJ_crown();
        GP.obj[0].WorldX = 29*GP.titleSize;
        GP.obj[0].WorldY = 25*GP.titleSize;

        GP.obj[1] = new OBJ_Suicun();
        GP.obj[1].WorldX = 31*GP.titleSize;
        GP.obj[1].WorldY = 40*GP.titleSize;

        GP.obj[2] = new OBJ_Red();
        GP.obj[2].WorldX = 37*GP.titleSize;
        GP.obj[2].WorldY = 13*GP.titleSize;

        GP.obj[3] = new OBJ_Purugly();
        GP.obj[3].WorldX = 12*GP.titleSize;
        GP.obj[3].WorldY = 11*GP.titleSize;

    }
}
