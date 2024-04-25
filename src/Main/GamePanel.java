package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
		final int tileSize0 = 16;
		final int scale = 3;
		
		public final int tileSize1 = tileSize0 * scale;
		public final int maxScreenzColumn = 25;
		public final int maxScreenzRow = 20;
		public final int ScreenWidth = tileSize1 * maxScreenzColumn;
		public  final int ScreenHeight = tileSize1 * maxScreenzRow;
		
		// fps
		int FPS = 60;
		
		// system
		TileManager tileM = new TileManager (this);
		KeyHandler keyhandler = new KeyHandler(); 
		Sound music = new Sound ();
		Sound se = new Sound();
		public CollisionChecker cChecker = new CollisionChecker(this);
		public AssetSetter aSetter = new AssetSetter(this);
		public UI ui = new UI (this);
		Thread gameThread;
		
		
		// entity and object
		public Player player = new Player(this,keyhandler);
        public SuperObject obj[] = new SuperObject[10];
	
		
		public GamePanel() {
			
			this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
			this.setBackground(Color.black);
			this.setDoubleBuffered(true);
			this.addKeyListener(keyhandler);
			this.setFocusable(true);
		}
		
		public void setupGame() {
			aSetter.setObject();
			
			playMusic(0);
			
		}
		
		public void startGameThread() {
			gameThread = new Thread(this);
			gameThread.start();//call the run method
		}

		@Override
		public void run() {
			
			double drawInterval = 1000000000/FPS;
			double nextDrawTime = System.nanoTime()+drawInterval;
			
			
			while(gameThread != null) {		
				//check update and draw the screen
				update();
				
				repaint();
				
				try {
					double remainingTime = nextDrawTime - System.nanoTime();
					remainingTime = remainingTime/1000000;
					
					if(remainingTime < 0) {
						remainingTime = 0;
					}
					
					Thread.sleep((long) remainingTime);
					
					nextDrawTime += drawInterval;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		}
		
		
		public void update() {
			player.update();
		}
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//draw character
			Graphics2D g2 = (Graphics2D)g;
			
			// tile
			tileM.draw(g2);  
			
			// object
			
			for (int i = 0; i <obj.length; i ++) {
				if(obj[i] != null) {
					obj[i].draw(g2,this);
				}
			}
			// player
			player.draw(g2);
			
			// UI
			ui.draw(g2);

			g2.dispose();
		}
		public void playMusic(int i) {
			music.setFile(i);
			music.play();
			music.loop();
		}
		public void stopMusic() {
			music.stop();
		}
		public void playSE(int i) {
			se.setFile(i);
			se.play();
		}
		
	}