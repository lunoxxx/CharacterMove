import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

//resizable = false
public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}
	

	public void keyPressed(KeyEvent e){
		

		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveUp();
			System.out.println("pos:" + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight();
			System.out.println("pos:" + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.moveDown();
			System.out.println("pos:" + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveLeft();
			System.out.println("pos:" + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){
			drawing.kick();
			System.out.println("kick");
		}	
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.punch();
			System.out.println("punch");
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.knockdown();
			System.out.println("knock down");
		}
		else if(e.getKeyCode() == KeyEvent.VK_F){
			drawing.bow();
			System.out.println("shoot bow");
		}
		else if(e.getKeyCode() == KeyEvent.VK_E){
			drawing.jump();
			System.out.println("jump");
		}
		else if(e.getKeyCode() == KeyEvent.VK_V){
			drawing.slide();
			System.out.println("slide");
		}
		else if(e.getKeyCode() == KeyEvent.VK_R){
			drawing.wallslide();
			System.out.println("wall slide");
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			drawing.airattack();
			System.out.println("air attack");
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			drawing.spawnEnemy();
		}
	}


	public void keyReleased(KeyEvent e){
		
	}

	public void keyTyped(KeyEvent e){
		System.out.println("boom!");
	}

	public static final Color LIGHTGREEN = new Color(102,255,102);

	public static void main(String [] args){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(600, 600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.getContentPane().setBackground(LIGHTGREEN);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("LET'S GO! ");
	}
}
