package main;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameStart {

	public static void main(String[] args) {
		GamePanel gamePanel =new GamePanel();
		JFrame startFrame = new JFrame("GG");
		startFrame.setUndecorated(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setContentPane(gamePanel);
		startFrame.setLocation(450,150);
		startFrame.pack();
		try {
			startFrame.setIconImage(ImageIO.read(new File("src/souce/healthcare.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		startFrame.setVisible(true);
		gamePanel.start(); 
	}
}
