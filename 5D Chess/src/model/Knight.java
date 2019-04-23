package model;

import java.awt.image.BufferedImage;

public class Knight extends Piece{
	
	public Knight(BufferedImage image, int yPosition, int xPosition, String name)
	{
		super(image, yPosition, xPosition, name);
	}

	@Override
	public boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine) {
		
		if(newX == (x + 2) && 
		   newY == (y + 1) &&
		   boundsChecking(newY, newX) == true)
		{
			return true;
		}
		else if(newX == (x + 2) && 
			    newY == (y - 1) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else if(newX == (x - 2) && 
			    newY == (y + 1) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else if(newX == (x - 2) && 
			    newY == (y - 1) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else if(newX == (x + 1) && 
			    newY == (y - 2) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else if(newX == (x - 1) && 
			    newY == (y - 2) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else if(newX == (x - 1) && 
			    newY == (y + 2) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else if(newX == (x + 1) && 
			    newY == (y + 2) &&
				boundsChecking(newY, newX) == true)
			{
				return true;
			}
		else
		{
			return false;
		}
	}
	
	private boolean boundsChecking(int newY, int newX)
	{
		if(newX >= 0 && newX < 6 && newY >= 0 && newY < 6)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
