package puzzle;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class Web {
	private Color color;

	public Web(Color color) {
		this.color = color;

	}

	public void update() {

	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		for(int x=0,y=0; x<=Puzzles.WIDTH && y<=Puzzles.HEIGTH; x++,y++){
			g.drawLine(x*(GamePanel.WIDTH/Puzzles.WIDTH), 0, x*(GamePanel.WIDTH/Puzzles.WIDTH), GamePanel.HEIGHT);
			g.drawLine(0, y*(GamePanel.HEIGHT/Puzzles.HEIGTH), GamePanel.WIDTH, y*(GamePanel.HEIGHT/Puzzles.HEIGTH));
		}
		g.drawLine(GamePanel.WIDTH-1, 0, GamePanel.WIDTH-1, GamePanel.HEIGHT-1);
		g.drawLine(0, GamePanel.HEIGHT-1, GamePanel.WIDTH, GamePanel.HEIGHT-1);
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
