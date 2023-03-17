package Main;

import Objects.OBJ_crown;

public class AssetSetter {
    GamePanel GP;
    public AssetSetter(GamePanel GP){
        this.GP = GP;
    }

    //set x y obj
    public void setObject(){
        GP.obj[0] = new OBJ_crown();
        GP.obj[0].WorldX = 27*GP.titleSize;
        GP.obj[0].WorldY = 27*GP.titleSize;

    }
}
