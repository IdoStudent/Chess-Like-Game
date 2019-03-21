package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bishop {
	
	File blackBishopFile = new File("img/BlackBishop.jpg");
	File whiteBishopFile = new File("img/WhiteBishop.jpg");
	
	BufferedImage blackBishop,whiteBishop;
	
	public Bishop() {
		setImage();
	}
	
	public void setImage() {
		try {
			blackBishop = ImageIO.read(blackBishopFile);
			whiteBishop = ImageIO.read(whiteBishopFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String color) {
		if(color.matches("white")) {
			return whiteBishop;
		}
		return blackBishop;
	}
	
	public boolean validMove(int tempRow, int tempCol, int currentRow, int currentCol) {
		if (currentRow == tempRow + 2 || currentRow == tempRow - 2) {
			if (currentCol == tempCol + 2 || currentCol == tempCol - 2) {
				return true;
			}
		}
		return false;
	}
}
