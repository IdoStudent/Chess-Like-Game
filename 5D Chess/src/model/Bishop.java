package model;

import java.awt.image.BufferedImage;

public class Bishop extends Piece {
	
	public Bishop(BufferedImage image, int xPosition, int yPosition, String name)
	{
		super(image, xPosition, yPosition, name);
	}
	
	@Override
	public void move(int y, int x) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(int y, int x) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	
	@Override
	public boolean getX() {
		// TODO Auto-generated method stub
		return xPosition;
	}
	
	@Override
	public boolean getY() {
		// TODO Auto-generated method stub
		return yPosition;
	}
}


