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
		setPieces();
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

	public void setPieces() {
		pieces = new Piece[12];
		pieces[0] = new Bishop(0,0,"blackBishop");
		pieces[1] = new Bishop(0,1,"blackRook");
		pieces[2] = new Bishop(0,2,"blackKnight");
		pieces[3] = new Bishop(0,3,"blackKnight");
		pieces[4] = new Bishop(0,4,"blackRook");
		pieces[5] = new Bishop(0,5,"blackBishop");
		pieces[6] = new Bishop(5,0,"whiteBishop");
		pieces[7] = new Bishop(5,1,"whiteRook");
		pieces[8] = new Bishop(5,2,"whiteKnight");
		pieces[9] = new Bishop(5,3,"whiteKnight");
		pieces[10] = new Bishop(5,4,"whiteRook");
		pieces[11] = new Bishop(5,5,"whiteBishop");
	}
	
	
}
