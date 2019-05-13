package model;

public class Bishop extends Piece{

	public Bishop(Player player,Board board, String name, String color, int X, int Y) {
		super(player, board, name, color, X, Y);
		// TODO Auto-generated constructor stub
//		this.addPiece(this);
	}
	
	@Override
	public boolean validMove(int toX, int toY) {
		
		int fromX = this.getPosX();
		int fromY= this.getPosY(); 
		int spaceX = Math.abs(fromX - toX);
		int spaceY = Math.abs(fromY - toY);
		if (spaceX == spaceY && spaceX<=2  && !isMovingOverPiece(toX,toY))
		{
			return true;
		}
		
		return false;
	}
	
	private boolean isMovingOverPiece(int toX, int toY) { 
		int fromX = this.getPosX();
		int fromY = this.getPosY();
		
		int minX = Math.min(fromX, toX);
		int minY = Math.min(fromY, toY);
		int maxY = Math.max(fromY, toY);
		int x = minX+1;
		for (int y=minY+1;y< maxY;y++) { //Diagonally move
				if (board.getSquares(x, y).getPiece()!=null)
					return true;
				x++;
			}
		
		return false;
	}
	


}
