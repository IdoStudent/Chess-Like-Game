package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rook {
	
	File blackRookFile = new File("img/BlackRook.jpg");
	File whiteRookFile = new File("img/WhiteRook.jpg");
	BufferedImage blackRook,whiteRook;
	
	public Rook() {
		setImage();
	}
	
	public void setImage() {
		try {
			blackRook = ImageIO.read(blackRookFile);
			whiteRook = ImageIO.read(whiteRookFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String color) {
		if(color.matches("white")) {
			return whiteRook;
		}
		return blackRook;
	}
	
	public boolean validMove(int tempRow, int tempCol, int currentRow, int currentCol) {
		if (currentRow == tempRow && (currentCol == tempCol + 2 || currentCol == tempCol - 2)) {
			return true;
		}else if(currentCol == tempCol && (currentRow == tempRow + 2 || currentRow == tempRow -2) ) {
			return true;
		}
		return false;
	}
}
