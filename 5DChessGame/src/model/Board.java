package model;

public class Board {
	private int width;
	private int height;
	private Square[][] squares;
//	private GameEngine game = new GameEngine();

	public Board(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
//		this.game = game;
		this.squares = new Square[width][height] ;
		this.addSquares();
//		this.addPieces();
	}
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Square getSquares(int x, int y) {
		return squares[x][y];
	}
	
	public void addSquares() {
		for (int y=0;y<this.width;y++) {
			for (int x=0;x<this.height;x++) {
				squares[x][y]= new Square(x,y);
			}
		}
	}
	
	public void addAllPlayerPieces(Player player) {
		
		for (Piece piece : player.getAllPieces())
	      {
			addPiece(piece,piece.getPosX(),piece.getPosY());
	      }
	
	}
	public boolean movePiece(Piece piece, int toX, int toY ) {
		if (piece.validMove(toX, toY) && this.squares[toX][toY].getPiece()==null) {
			dropPiece(piece.getPosX(),piece.getPosY());
			piece.move(toX, toY);
			addPiece(piece,toX,toY);
			return true;
		}
		return false;
	}
	
	public void dropPiece(int x, int y) {
			squares[x][y].setName("(  )");
	}
	
	public void addPiece(Piece piece,int x, int y) {
		squares[x][y].setName('(' +piece.getName()+piece.getColor()+')');
}

}
