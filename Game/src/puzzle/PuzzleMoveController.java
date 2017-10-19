package puzzle;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import main.GamePanel;

public class PuzzleMoveController {

	private Puzzles puzzles;
	private MovePuzzle movePuzzle;

	public PuzzleMoveController() {
		puzzles = new Puzzles("src/souce/lemon.jpg");
		movePuzzle = new MovePuzzle(puzzles.getOnePuzzle(0, 0).getImage().getWidth(),
				puzzles.getOnePuzzle(0, 0).getImage().getHeight());
	}

	public void update() {
		puzzles.update();
		movePuzzle.update();
	}

	public void draw(Graphics2D g) {
		puzzles.draw(g);
		movePuzzle.draw(g);
	}

	private void take(int mouseX, int mouseY) {
		movePuzzle.setMouseX(mouseX);
		movePuzzle.setMouseY(mouseY);
		movePuzzle.setX(mouseX / movePuzzle.getWidth());
		movePuzzle.setY(mouseY / movePuzzle.getHeight());
		if (movePuzzle.getImage() == null) {
			Puzzle puz = puzzles.getOnePuzzle(movePuzzle.getX(), movePuzzle.getY());
			movePuzzle.set(puz);
		}

	}

	private void replace(int mouseX, int mouseY) {
		
		movePuzzle.setCurrentX(mouseX);
		if (mouseX >= GamePanel.WIDTH)
			movePuzzle.setCurrentX(GamePanel.WIDTH - 5);
		if (mouseX < 0)
			movePuzzle.setCurrentX(5);
		movePuzzle.setCurrentY(mouseY);
		if (mouseY >= GamePanel.HEIGHT)
			movePuzzle.setCurrentY(GamePanel.HEIGHT - 5);
		if (mouseY < 0)
			movePuzzle.setCurrentY(5);
		
		if (movePuzzle.getImage() != null) {
			Puzzle puz1 = puzzles.getOnePuzzle(movePuzzle.getX(), movePuzzle.getY());
			Puzzle puz2 = puzzles.getOnePuzzle(movePuzzle.getCurrentX(), movePuzzle.getCurrentY());

			puz1.setX(movePuzzle.getCurrentX());
			puz1.setY(movePuzzle.getCurrentY());

			puz2.setX(movePuzzle.getX());
			puz2.setY(movePuzzle.getY());

			movePuzzle.clear();
		}
	}

	public List<KeyListener> getKeyListeners() {
		List<KeyListener> listeners = new ArrayList<>();
		listeners.add(movePuzzle.getKeyListener());
		listeners.add(new GameKeyListener());
		return listeners;
	}

	public List<MouseListener> getMouseListeners() {
		List<MouseListener> listeners = new ArrayList<>();
		listeners.add(new GameMouseListener());
		return listeners;
	}

	public List<MouseMotionListener> getMouseMotionListeners() {
		List<MouseMotionListener> listeners = new ArrayList<>();
		listeners.add(movePuzzle.getGameMouseMotionListener());
		return listeners;
	}

	private class GameKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}

	private class GameMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				take(e.getX(), e.getY());
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				replace(e.getX(), e.getY());
			}

		}

	}

}
