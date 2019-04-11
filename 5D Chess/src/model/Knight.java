package model;

import java.awt.image.BufferedImage;

public class Knight extends Piece{
	
	public Knight(BufferedImage image, int xPosition, int yPosition, String name)
	{
		super(image, xPosition, yPosition, name);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
