package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Heart;

public class UI {

	GamePanel gp;
	Font arial_40, arial_80B;
	BufferedImage heartImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished =false;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Serif", Font.BOLD, 40);
		arial_80B = new Font("Serif", Font.BOLD, 80);

		OBJ_Heart heart = new OBJ_Heart();
		heartImage = heart.image;
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		if(gameFinished == true ) {
		
			
			g2.setFont(arial_40);
			g2.setColor(Color.black);

			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "Congratulations";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			 x = gp.ScreenWidth /2 - textLength / 2;
			 y = gp.ScreenHeight / 2 - (gp.tileSize1 * 3);
			 g2.drawString(text, x, y);
			
			 
			
			 g2.setFont(arial_80B);
			 g2.setColor(Color.black);
			 text = "Wish you A Merry Christmas!";
				textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
				 x = gp.ScreenWidth /2 - textLength / 2;
				 y = gp.ScreenHeight / 2 + (gp.tileSize1 * 2);
				 g2.drawString(text, x, y);
			 
				 gp.gameThread = null;
			
			
		}
		else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(heartImage, gp.tileSize1 /2, gp.tileSize1/2, gp.tileSize1, gp.tileSize1,null);
			g2.drawString("x"+ gp.player.hasHeart,  74, 65);
			
			// message
			if(messageOn == true) {
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize1/2-8, gp.tileSize1* 5+80);
				
				messageCounter++;
				
				
				if (messageCounter >120) {
					messageCounter = 0;
					messageOn = false;
				}	
				
			}
		}
		
	}
}
