package puzzle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class MovePuzzle {

	private BufferedImage image;

	private int height;
	
	private int width;
	
	private int x;

	private int y;
	
	private int currentX;
	
	private int currentY;

	private int moveX;

	private int moveY;
	
	private int mouseX;

	private int mouseY;

	private int rotate;

	private boolean up;

	private boolean down;

	private boolean left;

	private boolean right;
	

	public MovePuzzle(BufferedImage image, int x, int y, int moveX, int moveY, int rotate) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.moveX = moveX;
		this.moveY = moveY;
		this.rotate = rotate;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	public MovePuzzle(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	

	public MovePuzzle() {
		
	}



	public void draw(Graphics2D g) {
		g.setColor(new Color(80,80,80));
		if(image!=null)
			g.fillRect(x*width, y*height, width, height);
		g.drawImage(image, moveX, moveY, null);
	
	}

	public void update() {
		move();
	}
	
	
	public void set(Puzzle puzzle){
		image = puzzle.getImage();
		width = image.getWidth();
		height = image.getHeight();
		x = puzzle.getX();
		y = puzzle.getY();
		moveX = x*width;
		moveY = y*height;
		rotate = puzzle.getRotate();
	}
	
	
	public void clear(){
		image = null;
	}
	

	public KeyListener getKeyListener() {
		return new GameKeyListener();
	}
	
	public MouseMotionListener getGameMouseMotionListener() {
		return new GameMouseMotionListener();
	}
	
	

	private void move() {
		int speed = 5;
		if (up) {
			if (moveY > 0)
				moveY-=speed;
			if(moveY < 0)
				moveY=0;
		}
		if (down) {
			if (moveY < GamePanel.HEIGHT-height)
				moveY+=speed;
			if (moveY > GamePanel.HEIGHT-height)
				moveY=GamePanel.HEIGHT-height;
		}
		if (left) {
			if (moveX > 0)
				moveX-=speed;
			if(moveX < 0)
				moveX=0;
		}
		if (right) {
			if (moveX < GamePanel.WIDTH-width)
				moveX+=speed;
			if (moveX > GamePanel.WIDTH-width)
				moveX=GamePanel.WIDTH-width;
		}
	}

	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX-mouseX;
	}

	public int getMoveY() {
		return moveY-mouseY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX/width;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY/height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRotate() {
		return rotate;
	}

	public void setRotate(int rotate) {
		this.rotate = rotate;
	}

	
	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX%width;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY%height;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}





	private class GameKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
				up = true;
			}
			if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
				down = true;
			}
			if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				left = true;
			}
			if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				right = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
				up=false;
			}
			if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
				down=false;
			}
			if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				left=false;
			}
			if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				right=false;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}
	
	private class GameMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			moveX=e.getX()-mouseX;
			if(moveX<0)
				moveX=0;
			if(moveX>=GamePanel.WIDTH-width)
				moveX=GamePanel.WIDTH-width-1;
			moveY=e.getY()-mouseY;
			if(moveY<0)
				moveY=0;
			if(moveY>=GamePanel.HEIGHT-height)
				moveY=GamePanel.HEIGHT-height-1;
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}

		

	}
}
