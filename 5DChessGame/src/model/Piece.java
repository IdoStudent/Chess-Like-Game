package model;

public abstract class Piece {
	private int posX; // X coordinate
	private int posY; // Y coordinate
	private String color;
	private Player player;
	private boolean status; // Current status (die or alive)
	private String name;

	
	public Piece(Player player,String name,String color, int X, int Y, boolean status) {
		this.player = player;
		this.name = name;
		this.color = color;
		this.status = status;
		this.posX = X;
		this.posY = Y;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void move(int X, int Y) {
		this.posX = X;
		this.posY = Y;
	}
	
	public abstract boolean  validMove(int toX, int toY);

}

