import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Draw extends JComponent {
	
	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");

	public int x = 300;
	public int y = 300;
	public int height = 0;
	public int width = 0;

	public int state = 0;
	
	public Random randomizer;

	public int enemyCount;
	Enemy[] enemies = new Enemy[15];

	public Draw(){
		randomizer = new Random();
		spawnEnemy();
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("bg.jpg"));

		}
		catch(IOException e){
			e.printStackTrace();
		}
		height = image.getHeight();
		width = image.getWidth();

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < enemies.length; c++){
							if(enemies[c]!=null){
								enemies[c].moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}



	public void spawnEnemy(){
		if(enemyCount <15){
			enemies[enemyCount] = new Enemy(randomizer.nextInt(100),randomizer.nextInt(100), this);
			enemyCount++;
		}
	}



	public void reloadImage(){
		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run01.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run02.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run03.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run04.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run05.png");
			state = 0;
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("attack" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(120);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread1.start();

	}

	public void attackAnimation2(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 13; ctr++){
					try{
						if(ctr==12){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("punch" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(130);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread2.start();

	}

	public void attackAnimation3(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 7; ctr++){
					try{
						if(ctr==6){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("knock" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(130);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread3.start();

	}
	public void attackAnimation4(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("bow" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(130);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread4.start();

	}

	public void attackAnimation5(){
		Thread thread5 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 3; ctr++){
					try{
						if(ctr==2){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("jump" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(150);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread5.start();

	}

	public void attackAnimation6(){
		Thread thread6 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 2; ctr++){
					try{
						if(ctr==1){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("slide" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread6.start();

	}

	public void attackAnimation7(){
		Thread thread7 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 2; ctr++){
					try{
						if(ctr==1){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("wslide" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(200);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread7.start();

	}

	public void attackAnimation8(){
		Thread thread8 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try{
						if(ctr==5){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("airattack" + ctr + ".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(120);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<enemies.length; x++){
					if(enemies[x]!=null){
						if(enemies[x].contact){
							enemies[x].life = enemies[x].life - 15; 
						}
					}
				}
			}
		});
		thread8.start();

	}

	public void kick(){
		attackAnimation();
	}

	public void punch(){
		attackAnimation2();
	}

	public void knockdown(){
		attackAnimation3();
	}

	public void bow(){
		attackAnimation4();
	}

	public void jump(){
		attackAnimation5();
	}

	public void slide(){
		attackAnimation6();
	}

	public void wallslide(){
		attackAnimation7();
	}

	public void airattack(){
		attackAnimation8();
	}


	public void moveUp(){
		y = y - 5;
		reloadImage();
		repaint();
		checkCollision();
		

	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
		checkCollision();
		

	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
		checkCollision();
		

	}

	public void moveLeft(){
		x = x - 5;
		reloadImage();	
		repaint();
		checkCollision();

		
	}

	public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x=0; x<enemies.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(enemies[x]!=null){
				enemies[x].contact = false;

				if(yChecker > enemies[x].yPos){
					if(yChecker-enemies[x].yPos < enemies[x].height){
						collideY = true;
					}
				}
				else{
					if(enemies[x].yPos - yChecker < enemies[x].height){
						collideY = true;
					}
				}

				if(xChecker > enemies[x].xPos){
					if(xChecker-enemies[x].xPos < enemies[x].width){
						collideX = true;
					}
				}
				else{
					if(enemies[x].xPos - xChecker < 2){
						collideX = true;
					}
				}
			}

			if(collideX && collideY){
				System.out.println("collision!");
				enemies[x].contact = true;
			}
		}
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);

		//for loop for the enemy 
		for(int c = 0; c < enemies.length; c++){
			if(enemies[c]!=null){
				// character grid for enemies
				// g.setColor(Color.BLUE);
				// g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
				g.drawImage(enemies[c].image, enemies[c].xPos, enemies[c].yPos, this);
				g.setColor(Color.BLUE);
				g.fillRect(enemies[c].xPos+7, enemies[c].yPos, enemies[c].life, 2);
			}	
		}
	}
}