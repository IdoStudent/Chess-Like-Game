package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Knight {
	
	BufferedImage blackKnight,whiteKnight;
	
	public Knight() {
		setImage();
	}
	
	public void setImage() {
		try {
			blackKnight = ImageIO.read(new File("img/BlackKnight.jpg"));
			whiteKnight = ImageIO.read(new File("img/WhiteKnight.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String color) {
		if(color.matches("white")) {
			return whiteKnight;
		}
		return blackKnight;
	}
	
	public boolean validMove(int tempRow, int tempCol, int currentRow, int currentCol) {
		
		if (currentRow == tempRow + 1 || currentRow == tempRow - 1) {
			if(currentCol == tempCol + 2 || currentCol == tempCol - 2) {
				return true;
			}
		}else if(currentRow == tempRow + 2 || currentRow == tempRow - 2) {
			if(currentCol == tempCol + 1 || currentCol == tempCol - 1) {
				return true;
			}
		}
		return false;
	}
}
