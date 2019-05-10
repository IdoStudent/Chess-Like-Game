package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bishop {
	
	BufferedImage blackBishop,whiteBishop;
	
	public Bishop() {
		setImage();
	}
	
	public void setImage() {
		try {
			blackBishop = ImageIO.read(new File("img/BlackBishop.jpg"));
			whiteBishop = ImageIO.read(new File("img/WhiteBishop.jpg"));
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
	
	public boolean validMove(Button[][] buttonArray, int tempRow, int tempCol, int currentRow, int currentCol) {
		int skipRow,skipCol;
		if (currentRow == tempRow + 2 || currentRow == tempRow - 2) {
			if (currentCol == tempCol + 2 || currentCol == tempCol - 2) {
				if (currentRow < tempRow) {
					skipRow = tempRow - 1;
				}else{
					skipRow = tempRow + 1;
				}
				if (currentCol < tempCol) {
					skipCol = tempCol - 1;
				}else {
					skipCol = tempCol + 1;
				}
				if(buttonArray[skipRow][skipCol].getPawnName().equals("")) {
					System.out.println("Valid");
					return true;
				}
			}
		}
		return false;
	}
}
