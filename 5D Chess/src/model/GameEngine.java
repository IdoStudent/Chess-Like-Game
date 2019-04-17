package model;

import view.GameEngineGUI;

public class GameEngine {
	
	//private GameEngineGUI gui = new GameEngineGUI();
	private Board board;
	private Piece[] pieces;
	private Player[] players = new Player[2];
	
	private int maxMoves = 0;
	private boolean playerTurn = true;
	
	public GameEngine()
	{
		this.maxMoves = maxMoves();
		renderBoard();
	}
	
	public void addPlayer(Player player)
	{
		for(int i = 0; i < players.length; i++)
		{
			if(players[i] == null)
			{
				players[i] = player;
			}
		}
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
		setPieces(new Piece[12]);
	}
	
	public void startGame()
	{
		System.out.println("Player 1 turn!");
	}
	
	private boolean getPlayerTurn()
	{
		return playerTurn;
	}
	
	public void move(String pieceName)
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

	public Piece[] getPieces() {
		return pieces;
	}

	public void setPieces(Piece[] pieces) {
		//set pieces
	}
	
	
}
