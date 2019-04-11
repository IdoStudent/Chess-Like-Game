package model;

import java.awt.image.BufferedImage;

public abstract class Piece {
	
	BufferedImage image;
	int xPosition;
	int yPosition;
	String name;
	
	public Piece(BufferedImage image, int xPosition, int yPosition, String name)
	{
		this.image = image;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.name = name;
	}
	
	public abstract void move();
	
	public abstract boolean isValid();
	
	public String getName()
	{
		return name;
	}
	
}
