package model;

public class Knight extends CombinablePiece {

	
	public Knight(Player player, Board board, String name, String color, int X, int Y) {
		super(player, board, name, color, X, Y);
		// TODO Auto-generated constructor stub
		this.addPiece(this);

	}

	@Override
	public boolean validMove(int toX, int toY) {
		
		int fromX = this.getPosX();
		int fromY= this.getPosY(); 
		int spaceX = Math.abs(fromX - toX);
		int spaceY = Math.abs(fromY - toY);
		if ((spaceX==2 &&spaceY==1) || (spaceX==1 &&spaceY==2) )
		{
			return true;
		}
		
		return false;
		
	}

	@Override
	public boolean isMovingOverPiece(int toX, int toY) {
		// TODO Auto-generated method stub
		return false;
	}

}
