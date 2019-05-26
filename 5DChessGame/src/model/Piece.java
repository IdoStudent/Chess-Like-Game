package model;

public abstract class Piece {
	
	protected int x; // X coordinate
	protected int y; // Y coordinate
	private String color;
	private Player player;
	private boolean status; // Current status (dead or alive)
	protected String name;
	protected Board board;

	public Piece(Player player,Board board, String name,String color, int x, int y) {
		this.player = player;
		this.board = board;
		this.name = name;
		this.color = color;
		status = true;
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y) {
		if (validMove(x, y)) {
			this.x = x;
			this.y = y;
		}
	}
	
	public abstract boolean validMove(int toX, int toY);
	
	public boolean isValidToCombine(String name,int x,int y, String color) {
		return name.equals(this.name) && x == this.x && y == this.y && color == this.color;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
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
	
	public String getName() {
		return name;
	}
}

