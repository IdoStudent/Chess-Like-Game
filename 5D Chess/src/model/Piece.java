package model;

import java.awt.image.BufferedImage;

public abstract class Piece {

	String name;
	int xPosition;
	int yPosition;
	
	
	public Piece(int yPosition, int xPosition, String name)
	{
		this.name = name;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		
	}
	
	public void move(int x, int y) {
		xPosition = x;
		yPosition = y;
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
