package puzzle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Cutter {
	public static List<Puzzle> cut(String src, int x, int y) {
		List<Puzzle> puzzles = new ArrayList<>();
			for (int yI = 0; yI < y; yI++) {
				for (int xI = 0; xI < x; xI++) {
					try {
						puzzles.add(cutOne(ImageIO.read(new File(src)),xI,yI,x,y));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		return puzzles;
	}
	
	private static Puzzle cutOne(BufferedImage image, int x, int y, int xSize, int ySize){
			BufferedImage crop = new BufferedImage(image.getWidth() / xSize, image.getHeight() / ySize, 
					image.getType());
			for (int yI = 0; yI < crop.getHeight(); yI++) {
				for (int xI = 0; xI < crop.getWidth(); xI++) {
					crop.setRGB(xI, yI, image.getRGB(xI + (image.getWidth() / xSize)*x, yI + (image.getHeight() / ySize)*y));
				}
			}
			return new Puzzle(crop, x, y);
	}
}
