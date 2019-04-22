package model;

public class Knight extends CombinablePiece {

	
	public Knight(Player player, Board board, String name, String color, int X, int Y, boolean status) {
		super(player, board, name, color, X, Y, status);
		// TODO Auto-generated constructor stub
		this.getPieces().add(this);

	}

	@Override
	public boolean validMove(int toX, int toY) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isMovingOverPiece(int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
