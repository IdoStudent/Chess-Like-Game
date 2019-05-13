package model;

public abstract class Piece {
	
	protected int posX; // X coordinate
	protected int posY; // Y coordinate
	private String color;
	private Player player;
	private boolean status; // Current status (die or alive)
	private String name;
	protected Board board;

	public Piece(Player player,Board board, String name,String color, int X, int Y) {
		this.player = player;
		this.board = board;
		this.name = name;
		this.color = color;
		status = true;
		posX = X;
		posY = Y;
	}
	
	public void move(int X, int Y) {
		if (validMove(X, Y)) {
			posX = X;
			posY = Y;
		}
	}
	
	public boolean equals(Piece piece) {		//??
		return (piece.name.equals(name) && piece.getPosX()==posX  && piece.getPosY()==posY && piece.getColor() == color);
	}
	
	public boolean isValidToCombine(Piece destinationPiece) {
		if (equals(destinationPiece)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean equals(Object piece) {
		if (!(piece instanceof Piece)) {
			return false;
		}
		return equals((Piece) piece);
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getColor() {
		return color;
	}

	public Player getPlayer() {
		return player;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode(); 			//?
	}

	@Override
	public String toString() {
		return String.format("SName:%s, Color:%s, X:%s, Y:%s\n", this.name, this.color, this.posX, this.posY);
	}
	
	public abstract boolean  validMove(int toX, int toY);
//	public abstract boolean isMovingOverPiece(int toX, int toY);
}

