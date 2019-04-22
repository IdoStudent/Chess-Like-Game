package model;

import view.GameEngineGUI;

public class GameEngine {
	
	GameEngineGUI gameEngineGUI = new GameEngineGUI(this);
	
	private Piece[] pieces;
	private Player[] players = new Player[2];
	
	private int player1MaxMoves = 0;
	private int player2MaxMoves = 0;
	private int maxMoves;
	
	private boolean playerTurn = true;
	
	public GameEngine()
	{
		renderLoginRegisterGUI();
		renderMaxMovesGUI();
		//this.maxMoves = maxMoves();
		setPieces();
	}
	
	private void renderLoginRegisterGUI()
	{
		boolean player1LoggedIn = false;
		boolean player2LoggedIn = false;
		
		gameEngineGUI.renderLoginRegister("Player 1");
		while(player1LoggedIn == false)
		{
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			if(getPlayers()[0] != null)
			{
				player1LoggedIn = true;
			}
		}
		
		gameEngineGUI.renderLoginRegister("Player 2");
		while(player2LoggedIn == false)
		{
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			if(getPlayers()[1] != null)
			{
				player2LoggedIn = true;
			}
		}
		//Render the GUI,
		//run loginPlayer or registerPlayer method depending on what player1 clicks
		//ONCE LOGGED IN SUCCESSFUL, run this method again for player2!!!!
		//run loginPlayer or registerPlayer method depending on what player2 clicks
	}
	
	public boolean loginPlayer(String username, String password)
	{
		//validate username and password,
		//check if username is already logged in,
		//create new player object,
		//run addPlayer method and pass in new player object
		Player player = new Player(username, password);
		addPlayer(player);
		System.out.println("LOGGED IN");
		return true;
	}
	
	public boolean registerPlayer(String username, String password)
	{
		//validate username and password,
		//check if username is already registered,
		//create new player object,
		//run addPlayer method and pass in new player object
		return false;
	}
	
	private boolean validatePlayers(String username, String password)
	{
		//check and see if the username and password requirements are correct and not blank
		//exclude using the char ":" from usernames and passwords as this will cause conflicts
		//with the writing to file.
		return false;
	}
	
	private void addPlayer(Player player)
	{
		//Run a loop through players array and if its empty, add the player to the array
		if(players[0] == null)
		{
			players[0] = player;
		}
		else if(players[1] == null)
		{
			players[1] = player;
		}
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public void setMaxMoves(int maxMoves)
	{
		//sets the player1MaxMoves or player2MaxMoves depending on which one
		if(player1MaxMoves == 0)
		{
			player1MaxMoves = maxMoves;
		}
		else if(player2MaxMoves == 0)
		{
			player2MaxMoves = maxMoves;
		}
	}
	
	private void renderMaxMovesGUI()
	{
		//Render a new MaxMovesGUI.java class.
		
		gameEngineGUI.renderMaxMoves("Player 1");
		
		while(this.player1MaxMoves == 0)
		{
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
		
		gameEngineGUI.renderMaxMoves("Player 2");
		while(this.player2MaxMoves == 0)
		{
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
		
		//sets the max moves once both players inputs have been entered.
		this.maxMoves = player1MaxMoves / player2MaxMoves;
	}
	
	public void renderBoardGUI()
	{
		setPieces();
		gameEngineGUI.renderBoard();
	}
	
	public void startGame()
	{
		//IN A LOOP,
		//Render board GUI and check player turns,
		//Once player moves, run the move/isValid commands
		//once game is over,
		//run writeDataToFile()
		renderBoardGUI();
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

	public int getMaxMoves() {
		return maxMoves;
	}
}