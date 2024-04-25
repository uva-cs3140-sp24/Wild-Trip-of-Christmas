package Main;

import javax.swing.JFrame;

public class project3{
	
	public static void main(String[] args) {
		JFrame pic = new JFrame();
		pic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pic.setResizable(false);
		pic.setTitle("Kulomi’s Christmas Adventure");
		
		GamePanel gamePanel = new GamePanel();
		pic.add(gamePanel);
		
		pic.pack();

		pic.setLocationRelativeTo(null);
		pic.setVisible(true);
		
		gamePanel.setupGame(); 
		gamePanel.startGameThread();
		
		
		
	}
	

	
} 