package model;

public class Knight extends Piece {

	
	public Knight(Player player, String name, String color, int X, int Y, boolean status) {
		super(player, name, color, X, Y, status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
