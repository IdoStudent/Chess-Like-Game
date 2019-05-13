package model;

public class Rook extends Piece{

	public Rook(Player player, Board board, String name, String color, int X, int Y) {
		super(player, board, name, color, X, Y);
	}

	@Override
	public boolean validMove(int toX, int toY) {
		if (((Math.abs(posX - toX)<=2 && Math.abs(posY - toY)==0) || (Math.abs(posY - toY)<=2 && Math.abs(posX - toX)==0)) && !isMovingOverPiece(toX,toY)){
			return true;
		}
		return false;
	}
	
	private boolean isMovingOverPiece(int toX, int toY) {
		if (posX == toX) {// Vertically move
			int x = toX;
			for (int y = Math.min(posY, toY) + 1; y < Math.max(posY, toY); y++) {
				if (board.getSquares(x, y).getPiece() != null)
					return true;
			}
		}
		if (posY == toY) {// Horizontal move
			int y = toY;
			for (int x = Math.min(posX, toX) + 1; x < Math.max(posX, toX); x++) {
				if (board.getSquares(x, y).getPiece() != null)
					return true;
			}
		}
		return false;
	}
}
