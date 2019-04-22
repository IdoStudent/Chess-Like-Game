package model;

public class Bishop extends CombinablePiece{

	public Bishop(Player player,Board board, String name, String color, int X, int Y, boolean status) {
		super(player, board, name, color, X, Y, status);
		// TODO Auto-generated constructor stub
		this.getPieces().add(this);
	}
	
	@Override
	public boolean validMove(int toX, int toY) {
		
		int fromX = this.getPosX();
		int fromY= this.getPosY(); 
		int spaceX = Math.abs(fromX - toX);
		int spaceY = Math.abs(fromY - toY);
		if (spaceX == spaceY && spaceX<=2 )
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isMovingOverPiece(int toX, int toY) { 
		int fromX = this.getPosX();
		int fromY = this.getPosY();
		
		int minX = Math.min(fromX, toX);
		int minY = Math.min(fromY, toY);
		int maxY = Math.max(fromY, toY);
		int x = minX+1;
		for (int y=minY+1;y< maxY;y++) { //Diagonally move
				if (this.getBoard().getSquares(x, y).getPiece()!=null)
					return true;
				x++;
			}
		
		return false;
	}
	


}
