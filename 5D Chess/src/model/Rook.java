package model;

public class Rook extends Piece{
	
	public Rook(int yPosition, int xPosition, String name)
	{
		super(xPosition, yPosition, name);
	}

	@Override
	public boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine) {
		
		boolean valid = false;
		int skipRow, skipCol;
		//check if rook moved horizontally
		if (newY == y && (newX == x + 2 || newX == x - 2)) {
			valid = true;
			if (newY < y) {
				skipRow = y - 1;
			}else if (newY > y){
				skipRow = y + 1;
			}else {
				skipRow = y;
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
		//check if rook moved perpendicularly
		}else if(newX == x && (newY == y + 2 || newY == y -2) ) {
			valid = true;
			if (newY < y) {
				skipRow = y - 1;
			}else if (newY > y){
				skipRow = y + 1;
			}else {
				skipRow = y;
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
		
		return valid;
	}
}
