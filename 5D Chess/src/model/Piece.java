package model;

public abstract class Piece {

	private String name;
	private int yPosition;
	private int xPosition;
	
	public Piece(int yPosition, int xPosition, String name)
	{
		this.name = name;
		this.yPosition = yPosition;
		this.xPosition = xPosition;
	}
	
	public void move(int y, int x) {
		yPosition = y;
		xPosition = x;
	}
	
	public abstract boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine);
	
	public String getName()
	{
		return name;
	}
	
	public int getY() {
		return yPosition;
	}
	
	public int getX() {
		return xPosition;
	}
	
}
