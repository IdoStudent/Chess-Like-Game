package model;

public class Bishop extends Piece{

	public Bishop(Player player,Board board, String name, String color, int x, int y) {
		super(player, board, name, color, x, y);
	}
	
	@Override
	public boolean validMove(int toX, int toY) {
		if (Math.abs(posX-toX) == Math.abs(posY-toY) && Math.abs(posX-toX) <= 2 && !isMovingOverPiece(toX,toY)){
			return true;
		}
		return false;
	}
	
	private boolean isMovingOverPiece(int toX, int toY) { 
		int x = Math.min(posX, toX)+1;
		for (int y=Math.min(posY, toY)+1;y<Math.max(posY, toY);y++) { //Diagonally move
			if (board.getSquares(x, y).getPiece()!=null)
				return true;
			x++;
		}
		return false;
	}
}
