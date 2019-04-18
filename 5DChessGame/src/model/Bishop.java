package model;

public class Bishop extends Piece{

	public Bishop(Player player, String name, String color, int X, int Y, boolean status) {
		super(player, name, color, X, Y, status);
		// TODO Auto-generated constructor stub
	}

	public boolean validMove(int toX, int toY) {
		int fromX = this.getPosX();
		int fromY= this.getPosX(); 
		if (toX == fromX + 2 || toX == fromX - 2) {
			if (toY == fromY + 2 || toY == fromY - 2) {
				return true;
			}
		}
		return false;
	}

	


}
