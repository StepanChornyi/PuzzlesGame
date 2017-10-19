package puzzle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Puzzle {
	
	private BufferedImage image;
	
	private int standartX;
	
	private int standartY;
	
	private int x;
	
	private int y;
	
	private int rotate;

	public Puzzle(BufferedImage image, int standartX, int standartY) {
		super();
		this.image = image;
		this.standartX = standartX;
		this.standartY = standartY;
		x=standartX;
		y=standartY;
	}
	
	
	public void draw(Graphics2D g){
		g.drawImage(image, (GamePanel.WIDTH/Puzzles.WIDTH)*x, (GamePanel.HEIGHT/Puzzles.HEIGTH)*y, null);
		g.setColor(new Color(80,80,80));
		g.drawRect(x*image.getWidth(), y*image.getHeight(), image.getWidth(), image.getHeight());
	}


	public int getStandartX() {
		return standartX;
	}


	public void setStandartX(int standartX) {
		this.standartX = standartX;
	}


	public int getStandartY() {
		return standartY;
	}


	public void setStandartY(int standartY) {
		this.standartY = standartY;
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


	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
	

	
	
	
	
	
}
