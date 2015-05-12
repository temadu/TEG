package front;

import gameStates.GameStateManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {
	
	// Game Title
	public static final String TITLE = "TEG";
		
	// Window Dimensions
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;

	// Thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
		
	// Game Manager
	private GameStateManager gsm;
	
	// Graphics
	private Graphics2D g;
	private BufferedImage image;

	public Game() { 
		
		setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		setFocusable(true);
		requestFocus();
		
	}
	
	public void addNotify() {
		
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		
	}
	
	public void run() {
		
		long start, elapsed, wait;
		
		init();
		
		// Game loop
		while(running) {

			start = System.nanoTime();
			
			draw(g);
			drawToScreen();
			update();
			
			elapsed = start - System.nanoTime();
			
			wait = targetTime - elapsed / 1000000; // wait debe estar en milisegundos
			
			// Si targetTime es mayor a elapsed, seteamos wait en un valor pequeño 
			if(wait < 0) {
				wait = 5;
			}
			
			try {
				Thread.sleep(wait);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public void init() {
		
		image = new BufferedImage(WINDOW_WIDTH/2,WINDOW_HEIGHT/2,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		gsm = new GameStateManager();
		running = true;
		
	}

	public void update() {
		
		// gsm.update();
		
	}

	public void draw(Graphics2D g) {

		// gsm.draw(g);

	}
	
	public void drawToScreen() {
		
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
		g2.dispose();
		
	}
	

}
