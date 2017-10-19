package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import puzzle.PuzzleMoveController;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	
	public static int WIDTH = 400;
	public static int HEIGHT = 400;

	private Thread thread;
	private int FPS;
	
	private BufferedImage image;
	private Graphics2D g;
	
	
	private PuzzleMoveController controller;
	
	
	
	GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		controller = new PuzzleMoveController();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for (KeyListener keyListener : controller.getKeyListeners()) {
			addKeyListener(keyListener);
		}
		for (MouseListener mouseListener : controller.getMouseListeners()) {
			addMouseListener(mouseListener);
		}
		for (MouseMotionListener mouseMotionListener : controller.getMouseMotionListeners()) {
			addMouseMotionListener(mouseMotionListener);
		}
		FPS=30;
		
		long sleepTime;
		long timer;
		
		while (true) {
			
			timer = System.nanoTime();
			gameUpdate();
			gameRender();
			gameDraw();
			timer =  System.nanoTime()-timer;
			
			sleepTime = (1000/FPS)-timer/1000000;
			if(sleepTime<0){
				sleepTime = 0;
			}
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sleep(long time){
		
	}

	public void gameUpdate() {
		
		controller.update();
	}

	public void gameRender() {
		
		controller.draw(g);
	}

	private void gameDraw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

	
	

}
