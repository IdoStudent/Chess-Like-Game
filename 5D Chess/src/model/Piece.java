package model;

import java.awt.image.BufferedImage;

public abstract class Piece {

	private String name;
	BufferedImage image;
	private int yPosition;
	private int xPosition;
	
	public Piece(BufferedImage image, int yPosition, int xPosition, String name)
	{
		this.name = name;
		this.yPosition = yPosition;
		this.xPosition = xPosition;
		//this.image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		this.image = image;
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
	
	public BufferedImage getImage()
	{
		return image;
	}
	
}
