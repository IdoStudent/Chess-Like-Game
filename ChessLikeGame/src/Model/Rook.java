package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rook {
	
	BufferedImage blackRook,whiteRook;
	
	public Rook() {
		setImage();
	}
	
	public void setImage() {
		try {
			blackRook = ImageIO.read(new File("img/BlackRook.jpg"));
			whiteRook = ImageIO.read(new File("img/WhiteRook.jpg"));
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
	
	public boolean validMove(Button[][] buttonArray, int tempRow, int tempCol, int currentRow, int currentCol) {
		int skipRow, skipCol;
		if (currentRow == tempRow && (currentCol == tempCol + 2 || currentCol == tempCol - 2)) {
			if (currentRow < tempRow) {
				skipRow = tempRow - 1;
			}else if (currentRow > tempRow){
				skipRow = tempRow + 1;
			}else {
				skipRow = tempRow;
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
		}else if(currentCol == tempCol && (currentRow == tempRow + 2 || currentRow == tempRow -2) ) {
			if (currentRow < tempRow) {
				skipRow = tempRow - 1;
			}else if (currentRow > tempRow){
				skipRow = tempRow + 1;
			}else {
				skipRow = tempRow;
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
		return false;
	}
}
