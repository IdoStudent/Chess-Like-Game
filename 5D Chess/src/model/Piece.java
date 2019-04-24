package model;

import java.awt.image.BufferedImage;

public abstract class Piece {

	BufferedImage image;
	private int yPosition;
	private int xPosition;
	PieceType pieceType;
	
	public Piece(BufferedImage image, int yPosition, int xPosition, PieceType pieceType)
	{
		this.yPosition = yPosition;
		this.xPosition = xPosition;
		//this.image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		this.image = image;
		this.pieceType = pieceType;
	}
	
	public void move(int y, int x) {
		yPosition = y;
		xPosition = x;
	}
	
	public abstract boolean isValid(int y, int x, int newY, int newX, GameEngine gameEngine);
	
	public PieceType getType()
	{
		return pieceType;
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
