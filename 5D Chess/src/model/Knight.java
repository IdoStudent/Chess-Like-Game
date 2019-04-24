package model;

import java.awt.image.BufferedImage;

public class Knight extends Piece{
	
	public Knight(BufferedImage image, int yPosition, int xPosition, PieceType pieceType)
	{
		super(image, yPosition, xPosition, pieceType);
	}

	@Override
	public boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine) {
		
		if(newX == (x + 2) && 
		   newY == (y + 1) &&
		   gameEngine.movingOnOwnPiece(newX, newY) == false)
		{
			return true;
		}
		else if(newX == (x + 2) && 
			    newY == (y - 1) &&
			    gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else if(newX == (x - 2) && 
			    newY == (y + 1) &&
				gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else if(newX == (x - 2) && 
			    newY == (y - 1) &&
			    gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else if(newX == (x + 1) && 
			    newY == (y - 2) &&
			    gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else if(newX == (x - 1) && 
			    newY == (y - 2) &&
			    gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else if(newX == (x - 1) && 
			    newY == (y + 2) &&
				gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else if(newX == (x + 1) && 
			    newY == (y + 2) &&
				gameEngine.movingOnOwnPiece(newX, newY) == false)
			{
				return true;
			}
		else
		{
			return false;
		}
	}
}
