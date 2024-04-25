package Main;

import object.OBJ_Boots;
import object.OBJ_Heart;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp =gp;
		
		
	}
	public void setObject() {
		gp.obj[0]= new OBJ_Heart();
		gp.obj[0].x = 5 * gp.tileSize1;
		gp.obj[0].y = 3 * gp.tileSize1;
		
		gp.obj[1]= new OBJ_Heart();
		gp.obj[1].x = 7 * gp.tileSize1;
		gp.obj[1].y = 11 * gp.tileSize1;
		
		gp.obj[2]= new OBJ_Heart();
		gp.obj[2].x = 2 * gp.tileSize1;
		gp.obj[2].y = 16 * gp.tileSize1;
		
		gp.obj[3]= new OBJ_Heart();
		gp.obj[3].x = 16 * gp.tileSize1;
		gp.obj[3].y = 2 * gp.tileSize1;
			
		gp.obj[4]= new OBJ_Heart();
		gp.obj[4].x =22 * gp.tileSize1;
		gp.obj[4].y = 4 * gp.tileSize1;
			
		gp.obj[5]= new OBJ_Heart();
		gp.obj[5].x = 18 * gp.tileSize1;
		gp.obj[5].y = 16 * gp.tileSize1;
		
		
		gp.obj[6]= new OBJ_Boots();
		gp.obj[6].x = 12 * gp.tileSize1;
		gp.obj[6].y = 3 * gp.tileSize1;
		
		gp.obj[7]= new OBJ_Boots();
		gp.obj[7].x = 13 * gp.tileSize1;
		gp.obj[7].y = 12 * gp.tileSize1;
		
		gp.obj[8]= new OBJ_Boots();
		gp.obj[8].x = 20 * gp.tileSize1;
		gp.obj[8].y = 8 * gp.tileSize1;
	
		
		
	}

}
