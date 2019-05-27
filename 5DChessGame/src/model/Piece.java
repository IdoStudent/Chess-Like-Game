package model;

public abstract class Piece {
	
	protected int posX; // X coordinate
	protected int posY; // Y coordinate
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
		posX = x;
		posY = y;
	}
	
	public void move(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public abstract boolean validMove(int toX, int toY);
	
	public boolean isValidToCombine(String name,int x,int y, String color) {
		return name.equals(this.name) && x == posX && y == posY && color == this.color;
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
	
	public String getName() {
		return name;
	}
}

