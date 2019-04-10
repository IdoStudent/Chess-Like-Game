package model;

import view.GameEngineGUI;

public class GameEngine {
	private GameEngineGUI gui = new GameEngineGUI();
	private Board board = new Board();
	private Piece[] pieces = new Piece[12];
	private Player[] players = new Player[2];
	
	private int maxMoves = 0;
	private boolean playerTurn = true;
	
	public GameEngine()
	{
		registerLogin();
		this.maxMoves = maxMoves();
	}
	
	private void registerLogin()
	{
		
	}
	
	public void addPlayer()
	{
		
	}
	
	public void getPlayers()
	{
		
	}
	
	public boolean validatePlayers()
	{
		return false;
	}
	
	private int maxMoves()
	{
		return 0;
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
