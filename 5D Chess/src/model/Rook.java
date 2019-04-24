package model;

import java.awt.image.BufferedImage;

public class Rook extends Piece{
	
	public Rook(BufferedImage image, int yPosition, int xPosition, PieceType pieceType)
	{
		super(image, yPosition, xPosition, pieceType);
	}

	@Override
	public boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine) {
		boolean valid = false;
		
		if(newX == (x) && 
		   newY == (y + 1) ||
		   newX == (x) && 
		   newY == (y + 2))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false &&
			   gameEngine.movingOnOwnPiece(newX, newY) == false)
			valid = true;
		}
		else if(newX == (x) && 
		        newY == (y - 1) ||
		        newX == (x) && 
		        newY == (y - 2))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false &&
			   gameEngine.movingOnOwnPiece(newX, newY) == false)
			valid = true;
		}
		else if(newX == (x + 1) && 
			    newY == (y) ||
			    newX == (x + 2) && 
			    newY == (y))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false &&
			   gameEngine.movingOnOwnPiece(newX, newY) == false)
			valid = true;	
		}
		else if(newX == (x - 1) && 
			    newY == (y) ||
			    newX == (x - 2) && 
			    newY == (y))
		{
			if(isMovingOverPiece(y, x, newY, newX, gameEngine) == false &&
			   gameEngine.movingOnOwnPiece(newX, newY) == false)
			valid = true;
		}
		
		return valid;
	}
	
	private boolean isMovingOverPiece(int y, int x, int newY, int newX, GameEngine gameEngine)
	{
		boolean movingOverPiece = false;
		for(Piece piece : gameEngine.getPieces())
		{
			if(piece.getY() == (y + 1) &&
			   piece.getX() == (x) &&
			   newX == (x) && 
			   newY == (y + 2))
			{
				movingOverPiece = true;
			}
			else if(piece.getY() == (y - 1) &&
					piece.getX() == (x) &&
					newX == (x) && 
					newY == (y - 2))
			{
				movingOverPiece = true;
			}
			else if(piece.getX() == (x + 1) &&
					piece.getY() == (y) &&
					newX == (x + 2) && 
					newY == (y))
			{
				movingOverPiece = true;
			}
			else if(piece.getX() == (x - 1) &&
					piece.getY() == (y) &&
					newX == (x - 2) && 
					newY == (y))
			{
				movingOverPiece = true;
			}
		}
		return movingOverPiece;
	}
	
}
/*
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
}else if(newY == y && (newX == x + 1 || newX == x - 1)) {
	valid = true;
}else if(newX == x && (newY == y + 1 || newY == y - 1)) {
	valid = true;
}

return valid;
*/