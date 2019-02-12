import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.JComponent;


public class Enemy{

	public int xPos = 450;
	public int yPos = 300;
	public int width = 0;
	public int height = 0;
	public int life = 15;
	public boolean fly = true;
	public boolean alive = true;
	public boolean contact = false;

	public BufferedImage image;
	public URL resource = getClass().getResource("bat/fly0.png");

	public Enemy(Draw comp){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		animate(comp);
	}

	public Enemy(int xPass, int yPass, Draw comp){
		xPos = xPass;
		yPos = yPass;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth();

		animate(comp);
	}

	public void animate(Draw compPass){
		Thread enemyThread = new Thread(new Runnable(){
			public void run(){
				while(fly){
					for(int ctr = 0; ctr < 4; ctr++){
						try {
							if(ctr==2){
								resource = getClass().getResource("bat/fly0.png");
							}
							else{
								resource = getClass().getResource("bat/fly"+ctr+".png");
							}
							
							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}

					        compPass.repaint();
					        Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					if(life<=0){
						die(compPass);
					}
				}
			}
		});
		enemyThread.start();
	}

	public void moveTo(int toX, int toY){
		if(xPos<toX){
			xPos++;
		}
		else if(xPos>toX){
			xPos--;
		}

		if(yPos<toY){
			yPos++;
		}
		else if(yPos>toY){
			yPos--;
		}
	}

	public void die(Draw compPass){
		fly = false;
		if(alive){
		Thread enemyThread = new Thread(new Runnable(){
				public void run(){
					for(int ctr = 0; ctr < 3; ctr++){
						try {					
							resource = getClass().getResource("bat/hurt"+ctr+".png");
							
							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}
					        compPass.repaint();
					        Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			enemyThread.start();
		}
		alive = false;
	}
}

