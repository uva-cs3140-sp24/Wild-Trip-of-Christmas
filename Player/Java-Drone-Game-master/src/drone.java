/*
 * Shuaidong Pan
 * span11
 * Project04
 * Lab TR 6:15-7:30
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class drone extends JComponent implements KeyListener, ActionListener{
	Timer t;
	int score=0;
	int fule=0;
	int fule0=200;
	int y = 310;
	int x = 50;
	int V=0;
	int ag=0;
	int a=0;
	int live=3;
	double tm=1;
	Rectangle[] R = new Rectangle[17];
	boolean fly=false;
	boolean crash=false;
	boolean success=false;
	int round=1;
	boolean gameover=false;
	boolean fire=false;
	int timer=1;
    boolean miss=true;
    boolean eat=true;
    boolean eat2=true;
    boolean noboom=true;

	
//set the constructor
	public drone(){

		addKeyListener(this);
		setFocusable(true); 
		t=new Timer(80,this);

	}
//set the fuel rectangle
	public void fuel(Graphics g){
//if fuel is less than 80
		if(fule0>=80){
			g.fillRect(getWidth()-300, 50, fule0, 10);
		}
		else{
			g.setColor(Color.red);
			g.fillRect(getWidth()-300, 50, fule0, 10);
		}
	}
//set the lives box and lives string by using the switch statment
	public void lives(Graphics g){
		switch(live){
		case 3:{
			g.setColor(Color.BLACK);
			g.drawString("Live : "+live, 20, 20);
			g.fillRect(20, 30, 10, 20);
			g.fillRect(35, 30, 10, 20);
			g.fillRect(50, 30, 10, 20);
			break; 
		}
		case 2:{
			g.drawString("Live : "+live, 20, 20);
			g.setColor(Color.BLACK);
			g.fillRect(20, 30, 10, 20);
			g.fillRect(35, 30, 10, 20);
			break;
		}
		case 1:{
			g.drawString("Live : "+live, 20, 20);
			g.setColor(Color.BLACK);
			g.fillRect(20, 30, 10, 20);
			break;
		}
		}
	}
//set the scoer table
public void scoretable(Graphics g){
		
		g.drawString("Your score : "+score, 350, 30);
}

//draw the graphic of the map one
	public void map1(Graphics g){



		g.setColor(Color.lightGray);
		R[0]  = new Rectangle(0,350,getWidth()-150,690);
		R[1]  = new Rectangle(400,250,100,390);
		R[2]  = new Rectangle(0,0,1000,90);
		R[3]  = new Rectangle(600,0,100,190);
		
		g.fillRect(0, 350, getWidth()-150, 700);
		g.fillRect(400, 250, 100, 400);
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 1000,100 );
		g.fillRect(600, 0, 100, 200);
		g.setColor(Color.BLACK);
		g.fillRect(getWidth()-150, 350, 150, 700);
		

	}
//set the map two
	public void map2(Graphics g){

		Graphics2D k= (Graphics2D)g;
		R[0]  = new Rectangle(0,0,80,100);
    	R[1] = new Rectangle(80,0,90,200);
    	R[2] = new Rectangle(170,0,100,150);
    	R[3] = new Rectangle(270,0,100,300);
    	R[4] = new Rectangle(370,0,150,250);
    	R[5] = new Rectangle(570,0,150,100);
        R[6] = new Rectangle(620,0,200,200);
        R[7] = new Rectangle(820,0,100,250);
        R[8] = new Rectangle(920,0,80,200);
        R[9] = new Rectangle(100,370,90,230);
        R[10] = new Rectangle(190,500,100,100);
        R[11] = new Rectangle(290,400,250,200);
        R[12] = new Rectangle(540,350,200,250);
        R[13] = new Rectangle(740,450,110,150);
		R[14] = new Rectangle(0, getHeight()-90, getWidth()-150, 170);
		R[15] = new Rectangle(0,350,100,50);
		k.setColor(Color.lightGray);
		g.fillRect(0,0,80,100);
		g.fillRect(80,0,90,200);
		g.fillRect(170,0,100,150);
		g.fillRect(270,0,100,300);
		g.fillRect(370,0,150,250);
		g.fillRect(520,0,150,100);
		g.fillRect(620,0,200,200);
		g.fillRect(820,0,100,250);
		g.fillRect(100,370,90,230);
		g.fillRect(920,0,80,200);
		g.fillRect(190,500,100,100);
		g.fillRect(290,400,250,200);
		g.fillRect(540,350,200,250);
		g.fillRect(740,450,110,150);
		g.fillRect(0, getHeight()-90, getWidth()-150, 170);
		g.fillRect(0, 350, 100, 50);
		g.setColor(Color.BLACK);
		g.fillRect(getWidth()-150, getHeight()-90, 150,170 );

	}
	
//draw the rocket and make it rotate
	public void rocket(Graphics s){
		s.setColor(Color.black);
		// AffineTransform at = AffineTransform.getTranslateInstance(40, 40);
		Graphics2D k= (Graphics2D)s;
		k.rotate(Math.toRadians(ag), x+15/2, y);
		s.fillRect(x, y, 15, 30);
		s.fillRect(x-5, y+30, 25, 10);
		s.fillRect(x+7,y-20 , 1, 20);
		s.fillRect(x-6,y+15 , 1, 25);
		s.fillRect(x+20, y+15, 1, 25);
		if(fire){
			Random r=new Random();


			for(int o=0;o<50;o++){	
				int fx=r.nextInt(16);
				int fy=r.nextInt(23);
				s.fillOval( (x-5+fy), y+40+fx,2 ,2 );
			}

		}
	}

// add all the draw method to the paint method
	@Override
	public void paintComponent(Graphics g){
		//super.paintComponent (g);
		//use if statement to choose which round are you in
		if(round==1){
			Graphics copy=g.create();
			map1(copy);
			copy.dispose();
			copy=g.create();
			rocket(copy);
			copy.dispose();
			copy=g.create();
			fuel(copy);
			copy.dispose();
			copy=g.create();
			lives(copy);
			copy.dispose();
			//copy=g.create();
			coins(g);
			//g.dispose();
			boomer(g);
			copy=g.create();
			scoretable(copy);
			copy.dispose();
			t.start();
			//use if statement to judge whether the rocket is crashed or not
			if(crash||fule0<0&&live>0){
				Graphics c= g.create();	
				over(g);
				c.dispose();
			
			} 
			//use the if statement to judge whether the player is die or not
			else if(live<0||(live<0&&fule0<=0)) {
				gameover=true;
				if(gameover){
					end(g);
					t.stop();
				}
			}
		}
		
		else if(round==2){
			Graphics copy=g.create();
			map2(copy);
			copy.dispose();
			copy=g.create();
			rocket(copy);
			copy.dispose();
			copy=g.create();
			fuel(copy);
			copy.dispose();
			copy=g.create();
			lives(copy);
			copy.dispose();
			//copy=g.create();
			coins(g);
			//g.dispose();
			boomer(g);
			copy=g.create();
			scoretable(copy);
			copy.dispose();
			t.start();
			if(crash||fule0<0&&live>0){
				Graphics c= g.create();	
				over(c);
				c.dispose();

			} else if(live<0||(live<0&&fule0<=0)){
				gameover=true;
				if(gameover){
					end(g);
					t.stop();
				}
			}

		}
		//to choose whether it is 
		else if(round==0){
			success(g);
			t.stop();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
//use key press to move the rocket and start the game
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int a = e.getKeyCode();

		if (a==KeyEvent.VK_UP){
			fly=true;
			fire=true;
			V=V+2;
			fule=1;
		}
		else if(a==KeyEvent.VK_DOWN){
			fly=true;
			fire=true;
			V=V-2;
			fule=1;
		}
		else if(a==KeyEvent.VK_RIGHT){
			fly=true;
			fire=false;
			ag=ag+10;
		}
		else if(a==KeyEvent.VK_LEFT){
			fly=true;
			fire=false;
			ag=ag-10;
		}
		else if(a==KeyEvent.VK_ENTER){
			crash=false;
			fly=false;
		}

	}
	
// use the key released method to make the velocity of the rocket and fuel change to 0 
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		V=0;
		fule=0;
		tm=1;
		fire=false;
	}
// end method to show the final score and the game over pic
	public void end(Graphics g){
		g.setColor(Color.LIGHT_GRAY );
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		Font f=new Font("Time New Roman", Font.BOLD,20);
		g.setFont(f);
		g.drawString("Your score is "+score, 400, 50);
		BufferedImage rocket = LoadImage("src/gameover.JPG");
		g.drawImage(rocket, 250, 100, this);
	}
//  the method used to read a Image
	public BufferedImage LoadImage(String filename){
		BufferedImage img = null;
		try{
			img = ImageIO.read(new File(filename));
		}catch(IOException e){
			System.out.println("File cannot find");
		}
		return img;
	}
//  the over method to input the image 
	public void over(Graphics g){

		BufferedImage rocket = LoadImage("src/kkk.JPG");
		g.drawImage(rocket, 250, 100, this);

	}
// set the success method to print the final score and the victory picture
	public void success(Graphics g){

		g.setColor(Color.LIGHT_GRAY );
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		Font f=new Font("Time New Roman", Font.BOLD,20);
		g.setFont(f);
		g.drawString("Your score is "+score, 400, 50);
		BufferedImage success=LoadImage("src/success.jpg");
		g.drawImage(success, 250, 100, this);

	}
// draw a boomer
	public void boomer(Graphics g){
		if(noboom){
		BufferedImage boomer = LoadImage("src/bommer.png");
		g.drawImage(boomer, 200, 200, this);
		}
	
		}
//draw a coins which is twirling and change the position with time 
	public void coins(Graphics g){
	 
	    BufferedImage coins1 =LoadImage("src/1.png");
	    BufferedImage coins2 =LoadImage("src/2.png");
	    BufferedImage coins3 =LoadImage("src/3.png");
		if(miss){
			Random r= new Random();
			int k=r.nextInt(100)+650;
	    if(timer%6==1){
	    	g.drawImage(coins1, k, 200, this);
	    }
		else if(timer%6==3){
			g.drawImage(coins2, k, 200, this);
		}
		else if(timer%6==0){
			g.drawImage(coins3, k, 200, this);
		}
		}
	    
	}
//set the action performed method
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
timer++;
		if(fly&&!crash&&fule0>0){
			//if the rocket is flying change the position
			x += (V*Math.sin(Math.toRadians(ag)));
			y =(int)(y-(V*Math.cos(Math.toRadians(ag)))+tm);
			fule0-=fule;
			repaint();
			tm=tm+0.1;
			
		}
		repaint();
// to judge whether the rocket is intersect with the borders, coins and boomer and also to decide whether loose life get score or die.
		if(round==1){	

			for(int i=0; i<=3;i++)
				if(new Rectangle(x,y,15,20).intersects(R[i])||new Rectangle(x+7,y-20 , 1, 20).intersects(R[i])||fule0<=0||new Rectangle(x,y,15,20).intersects(new Rectangle(200,200,50,50))){
					System.out.println(R[i]+" "+x+" "+y);
					crash=true;
					live--;
					fule0=200;
					ag=0;
					V=0;
					x=50;
					y=310;
					tm=1;
					miss=true;

					fly=false;


				}
				else if(new Rectangle(x,y,15,20).intersects(new Rectangle(getWidth()-150, 350, 150,170))){
					round=2;
					fule0=200;
					ag=0;
					V=0;
					x=50;
					y=310;
					fly=false;
					crash=false;
					score=score+5;
					miss=true;
				}
				else if(new Rectangle(x,y,15,20).intersects(new Rectangle(700,200,50,50))){
					
					miss=false;
					if(eat){
					score=score+1;
					System.out.println("Score"+score);
					eat=false;
					}
				}
		}else if(round==2){

			for(int i=0; i<=15;i++)
				if(new Rectangle(x,y,15,38).intersects(R[i])||new Rectangle(x+7,y-20 , 1, 20).intersects(R[i])||fule0<=0||new Rectangle(x,y,15,20).intersects(new Rectangle(220,190,50,50))){

					crash=true;
					live--;
					fule0=200;
					ag=0;
					V=0;
					x=50;
					y=310;
					fly=false;
					tm=1;
					System.out.println(R[i]);

				}
				else if(new Rectangle(x,y,15,20).intersects(new Rectangle(getWidth()-150, getHeight()-90, 150,170))){
					round=0;
					fule0=200;
					ag=0;
					V=0;
					x=50;
					y=310;
					fly=false;
					crash=false;
					success=true;
					score=score+5;
					System.out.println(score);
				}
				  else if(new Rectangle(x,y,15,20).intersects(new Rectangle(700,200,50,50))){
						
						miss=false;
						
						if(eat2){
						score=score+1;
						System.out.println("Score"+score);
						eat2=false;
						
						}

			}

		}

	}
}
