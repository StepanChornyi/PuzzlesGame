package puzzle;
import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class Background {

	private Color color;

	public Background(Color color) {
		this.color = color;

	}

	public void update() {

	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
