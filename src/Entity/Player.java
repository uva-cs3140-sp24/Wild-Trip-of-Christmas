package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyhandler;
	public int hasHeart = 0;
	public int hasBoots = 0;
	
	public Player(GamePanel gp, KeyHandler keyhandler) {
		this.gp = gp;
		this.keyhandler = keyhandler;
		
		solidArea = new Rectangle(8,16,32,32);
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/toy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/toy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/toy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/toy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/toy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/toy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/toy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/toy_right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyhandler.upPressed == true || keyhandler.downPressed == true || 
				keyhandler.leftPressed == true || keyhandler.rightPressed == true ) {
			if(keyhandler.upPressed == true) {
				direction = "up";	
			}			
			if(keyhandler.downPressed == true) {
				direction = "down";	
			}
			if(keyhandler.leftPressed == true) {
				direction = "left";	
			}
			if(keyhandler.rightPressed == true) {
				direction = "right";	
			}
			
			// check tile collision
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// check object collision
			int objIndex = gp.cChecker.checkObject(this,true);
			pickUpObject (objIndex);
			
			// if collision is false, player can move
			if (collisionOn == false) {
				
				switch(direction) {
				case "up":
					y -= speed;
					break;
				case "down":
					y += speed;
					break;
				case "left":
					x -= speed;
					break;
				case "right":
					x += speed; 
					break;
				}
			}
			
			spriteCounter++;
			// control the velocity
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}	
	}
	
	public void pickUpObject( int i) {
		
		if (i != 999) {
			String objectName = gp.obj[i].name;
			
			 switch(objectName) {
			 case "Heart":
				 gp.playSE(1);
				 hasHeart ++;
				 gp.obj[i] = null;
				 gp.ui.showMessage("You got a heart!");
				 if(hasHeart == 6) {
					 gp.ui.gameFinished = true;
					 gp.stopMusic();
					 gp.playSE(2);
				 }
				 break; 
				 
			 case "Boots":
				 speed += 1;
				 gp.obj[i] = null;
				 gp.ui.showMessage("       Speed up!");
				 break;
			 }
			
		}
	}
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.pink);
		//g2.fillRect(x, y, gp.tileSize1, gp.tileSize1);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if (spriteNum == 1) {
			    image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
			    image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
			image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
			image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize1, gp.tileSize1, null);
	}

}













