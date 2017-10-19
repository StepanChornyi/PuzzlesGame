package puzzle;

import java.awt.Graphics2D;
import java.util.List;

public class Puzzles {

	private List<Puzzle> puzzles;
	
	public static final int WIDTH = 8;
	
	public static final int HEIGTH = 8;
	
	

	public Puzzles(String img) {
		puzzles = Cutter.cut(img, WIDTH, HEIGTH);
		Mixer.mix(puzzles);
	}
	
	public void draw(Graphics2D g){
		//Mixer.mix(puzzles);
		for (Puzzle puzzle : puzzles) {
			puzzle.draw(g);
		}
	}
	
	public void update(){
		
	}
	
	public Puzzle getOnePuzzle(int x, int y){
		for (Puzzle puzzle : puzzles) {
			if(puzzle.getX()==x&&puzzle.getY()==y)
			return puzzle;
		}
		return null;
	}
	
	
	
	
	
	
}
