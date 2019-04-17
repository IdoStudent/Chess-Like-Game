package model;

public class Bishop extends Piece {
	
	public Bishop(int yPosition, int xPosition, String name)
	{
		super(xPosition, yPosition, name);
	}

	@Override
	public boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine) {
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
		}
		
		return valid;
	}
}


