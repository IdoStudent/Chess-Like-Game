package model;

import java.io.File;
import java.util.Scanner;

public class Player {
	
	private String playerId;
	private int maxMoves;
	private int score;
	private int numOfMove;
	private int wins;
	private int losses;
	
	public Player(String playerId) {
		this.playerId = playerId;
		this.wins = getWinLossFromFile("win");
		this.losses = getWinLossFromFile("loss");
		maxMoves = 0;
	}

	public String getPlayerId() {
		return playerId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNumOfMove() {
		return numOfMove;
	}

	public void setNumOfMove(int numOfMove) {
		this.numOfMove = numOfMove;
	}
	
	public int getMaxMoves()
	{
		return maxMoves;
	}
	public void setMaxMoves(int maxMoves)
	{
		this.maxMoves = maxMoves;
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public int getLosses()
	{
		return losses;
	}
	
	private int getWinLossFromFile(String winLoss)
	{
		Scanner scanner;
		int result = 0;
		
		try
		{
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while(scanner.hasNextLine())
			{
				String user = scanner.next();
				String pass = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());
				
				if(playerId.equals(user))
				{
					if(winLoss.equals("win"))
					{
						result = win;
						scanner.close();
						return result;
					}
					else if(winLoss.equals("loss"))
					{
						result = loss;
						scanner.close();
						return result;
					}
				}
				
				scanner.nextLine();
			}
			scanner.close();
		}
		catch(Exception e){}
		return result;
	}
	
}
