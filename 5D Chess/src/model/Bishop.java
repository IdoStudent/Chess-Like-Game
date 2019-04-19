package model;

public class Bishop extends Piece {
	
	public Bishop(int yPosition, int xPosition, String name)
	{
		super(yPosition, xPosition, name);
	}

	@Override
	public boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine) {
		boolean isValid = false;
		
		if(newX == (x + 1) && 
		   newY == (y + 1) ||
		   newX == (x + 2) && 
		   newY == (y + 2))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false)
			isValid = true;
		}
		else if(newX == (x - 1) && 
				newY == (y - 1) ||
				newX == (x - 2) && 
				newY == (y - 2))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false)
			isValid = true;
		}
		else if(newX == (x - 1) && 
				newY == (y + 1) ||
				newX == (x - 2) && 
				newY == (y + 2))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false)
			isValid = true;
		}
		else if(newX == (x + 1) && 
				newY == (y - 1) ||
				newX == (x + 2) && 
				newY == (y - 2))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false)
			isValid = true;
		}
		
		return isValid;
	}
	
	private boolean isMovingOverPiece(int y, int x, int newY, int newX, GameEngine gameEngine)
	{
		for(Piece piece : gameEngine.getPieces())
		{
			if(piece.getY() == (y + 1) &&
			   piece.getX() == (x + 1) &&
			   newX == (x + 2) && 
			   newY == (y + 2))
			{
				return true;
			}
			else if(piece.getY() == (y - 1) &&
					piece.getX() == (x - 1) &&
					newX == (x - 2) && 
					newY == (y - 2))
			{
				return true;
			}
			else if(piece.getY() == (y - 1) &&
					piece.getX() == (x + 1) &&
					newX == (x + 2) && 
					newY == (y - 2))
			{
				return true;
			}
			else if(piece.getY() == (y + 1) &&
					piece.getX() == (x - 1) &&
					newX == (x - 2) && 
					newY == (y + 2))
			{
				return true;
			}
		}
		return false;
	}
	
}


/*
boolean valid = false;

int skipRow,skipCol;
if (newY == y + 2 || newY == y - 2) { //if row is 2 more or 2 less
	if (newX == x + 2 || newX == x - 2) { //if column is 2 more or 2 less
		valid = true;
		
		//check if there's a piece blocking the move
		if (newY < y) {
			skipRow = y - 1;
		}else{
			skipRow = y + 1;
		}
		if (newX < x) {
			skipCol = x - 1;
		}else {
			skipCol = x + 1;
		}
		for(Piece piece : gameEngine.getPieces()) {
			if(piece.getX() == skipCol && piece.getY() == skipRow) {
				valid = false;
			}
		}
	}
}else if(newY == y + 1 || newY == y - 1) {
	if (newX == x + 1 || newX == x - 1) {
		valid = true;
	}
}

return valid;
*/


