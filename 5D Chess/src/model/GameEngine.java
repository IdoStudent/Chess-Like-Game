package model;

import view.GameEngineGUI;

public class GameEngine {
	private GameEngineGUI gui = new GameEngineGUI();
	private Board board;
	private Piece[] pieces;
	private Player[] players = new Player[2];
	
	private int maxMoves = 0;
	private boolean playerTurn = true;
	
	public GameEngine()
	{
		this.maxMoves = maxMoves();
	}
	
	public void addPlayer(Player Player)
	{
		
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public boolean validatePlayers()
	{
		return false;
	}
	
	private int maxMoves()
	{
		return 0;
	}
	
	public void renderBoard()
	{
		board = new Board();
		pieces = new Piece[12];
	}
	
	public void startGame()
	{
		System.out.println("Game started");
	}
	
	private boolean getPlayerTurn()
	{
		return playerTurn;
	}
	
	public void move()
	{
		
	}
	
	private void isValid()
	{
		
	}
	
	public void endGame()
	{
		
	}
	
	private void writeDataToFile()
	{
		
	}
	
	
}
