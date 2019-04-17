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
		this.addSquares();
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
		for (int i=0;i<this.width;i++) {
			for (int j=0;j<this.height;j++) {
				squares[i][j]= new Square(i,j);
			}
		}
	}

}
