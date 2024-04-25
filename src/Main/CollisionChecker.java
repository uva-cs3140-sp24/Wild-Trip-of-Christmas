package Main;

import Entity.Entity;

public class CollisionChecker {

	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.x + entity.solidArea.x;
		int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.y + entity.solidArea.y;
		int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize1;
		int entityRightCol = entityRightWorldX/gp.tileSize1;
		int entityTopRow = entityTopWorldY/gp.tileSize1;
		int entityBottomRow = entityBottomWorldY/gp.tileSize1;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/ gp.tileSize1;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/ gp.tileSize1;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/ gp.tileSize1;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/ gp.tileSize1;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for (int i = 0; i < gp.obj.length ;i++) {
		
			if ( gp.obj[i]!= null) {
				// get entity's solid area position
				entity.solidArea.x = entity.x + entity.solidArea.x;
				entity.solidArea.y = entity.y + entity.solidArea.y;
				
				// get the object's solid area position
		        gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
		        gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;
		
		        switch(entity.direction) {
		        case "up":
		        	entity.solidArea.y -= entity.speed;
		        	if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
		        		if(gp.obj[i].collision == true) {
		        			 entity.collisionOn = true;
		        		}
		        		if(player == true) {
		        			index = i;
		        		}
		        	}
		        	break;
		        	
		        case "down":
		        	entity.solidArea.y += entity.speed;
		        	if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
		        		if(gp.obj[i].collision == true) {
		        			 entity.collisionOn = true;
		        		}
		        		if(player == true) {
		        			index = i;
		        		}
		        	}
		        	break;
		        	
		        case "left":
		        	entity.solidArea.x -= entity.speed;
		        	if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
		        		if(gp.obj[i].collision == true) {
		        			 entity.collisionOn = true;
		        		}
		        		if(player == true) {
		        			index = i;
		        		}
		        	}
		        	break;
		        	
		        case "right":
		        	entity.solidArea.x += entity.speed;
		        	if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
		        		if(gp.obj[i].collision == true) {
		        			 entity.collisionOn = true;
		        		}
		        		if(player == true) {
		        			index = i;
		        		}
		        	break;
		        	}
		        }
		        entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
		        }
		      }
		return index;	
		  }	
        }
	
	    

