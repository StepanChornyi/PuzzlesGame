package puzzle;

import java.util.List;

public class Mixer {
	
	public static void mix(List<Puzzle> puzzles){
		int x;
		int y;
		boolean [][] em = new boolean[Puzzles.WIDTH][Puzzles.HEIGTH];
		
		for(int i=0; i<puzzles.size(); i++){
			x = (int)Math.round(Math.random()*(Puzzles.WIDTH-1));
			y = (int)Math.round(Math.random()*(Puzzles.HEIGTH-1));
			if(!em[x][y]){
				puzzles.get(i).setX(x);
				puzzles.get(i).setY(y);
				em[x][y]=true;
			}else{
				while(em[x][y]){
					x++;
					if(x>=Puzzles.WIDTH){
						x=0;
						y++;
					}
					if(y>=Puzzles.HEIGTH){
						y=0;
					}
					if(!em[x][y]){
						puzzles.get(i).setX(x);
						puzzles.get(i).setY(y);
						
					}
				}
				em[x][y]=true;
			}

		}
	}
	

}
