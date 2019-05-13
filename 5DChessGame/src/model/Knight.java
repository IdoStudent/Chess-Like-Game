package model;

public class Knight extends Piece {

	public Knight(Player player, Board board, String name, String color, int X, int Y) {
		super(player, board, name, color, X, Y);
	}

	@Override
	public boolean validMove(int toX, int toY) {
		int spaceX = Math.abs(posX - toX);
		int spaceY = Math.abs(posY - toY);
		if (((spaceX==2 && spaceY==1) || (spaceX==1 && spaceY==2)))
		{
			return true;
		}
		return false;
	}
}
