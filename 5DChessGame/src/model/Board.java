package model;

public class Board {
	private int width;
	private int height;
	private Square[][] squares;

	public Board(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		this.squares = new Square[width][height] ;
		this.initSquares();
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
	
	public Square[][] getAllSquares() {
		return squares;
	}
	
	@Override
	public String toString() {
		String b="";
		for (int y=0;y<this.width;y++) {
			for (int x=0;x<this.height;x++) {
				b += squares[x][y].toString();
			}
			b +="\n";
		}
		return b;
	}
	
	public void initSquares() {
		for (int y=0;y<this.width;y++) {
			for (int x=0;x<this.height;x++) {
				squares[x][y]= new Square(x,y);
			}
		}
	}
	
	public void addPlayerPieces(Player player) {
		
		for (CombinablePiece piece : player.getAllPieces())
	      {
			addPiece(piece,piece.getPosX(),piece.getPosY());
	      }
	
	}

	
	public void dropPiece(int x, int y) {
			squares[x][y].setName("(  )");	
			squares[x][y].setPiece(null);

	}
	
	public void addPiece(CombinablePiece piece,int x, int y) {
		squares[x][y].setName("(" +piece.getCombinedName()+piece.getColor()+")");
		squares[x][y].setPiece(piece);
	}
	
	public void updatePiece(CombinablePiece piece) {
		squares[piece.getPosX()][piece.getPosX()].setName("(" +piece.getCombinedName()+piece.getColor()+")");
		squares[piece.getPosX()][piece.getPosX()].setPiece(piece);
	}
	
	
}
