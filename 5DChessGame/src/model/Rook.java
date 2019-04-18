package model;

public class Rook extends Piece{

	
	public Rook(Player player, String name, String color, int X, int Y, boolean status) {
		super(player, name, color, X, Y, status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(int toX, int toY) {
		
		int fromX = this.getPosX();
		int fromY= this.getPosX(); 
		int spaceX = Math.abs(fromX - toX);
		int spaceY = Math.abs(fromY - toY);
		if (spaceX<=2 &&spaceY==0 || spaceY<=2 &&spaceX==0 )
		{
			return true;
		}
		
		return false;
		
	}

}
