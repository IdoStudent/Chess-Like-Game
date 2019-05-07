package model;

public class Player {
	
	String username;
	int maxMoves = 0;
	
	private Piece[] pieces = new Piece[6];
	
	public Player(String username) 
	{
		this.username = username;
	}

	public String getPlayerId() 
	{
		return username;
	}

	public int getMaxMoves() 
	{
		return maxMoves;
	}

	public void setMaxMoves(int max) 
	{
		this.maxMoves = max;
	}

}
