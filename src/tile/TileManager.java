package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager (GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxScreenzColumn][gp.maxScreenzRow];
		 
		
		getTileImage();
		loadMap();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowman.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision = true;
	
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road.png"));
			
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ginger.png"));
			tile[6].collision = true;

			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house.png"));
			tile[7].collision = true;
			

			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map02.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenzColumn && row < gp.maxScreenzRow) {
				String line = br.readLine();
				
				while(col < gp.maxScreenzColumn) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if(col == gp.maxScreenzColumn) {
					col = 0;
					row ++;
					
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
		
		
		
	}
	public void draw(Graphics2D g2) {
		
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenzColumn && row < gp.maxScreenzRow) {
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize1, gp.tileSize1, null);
			
			col++;
			x += gp.tileSize1;
			
			if(col == gp.maxScreenzColumn) {
				col = 0 ;
				x = 0;
				row++;
				y += gp.tileSize1;
			}
			
		}
		
		
		
		
		
		
		
		
	}
}
