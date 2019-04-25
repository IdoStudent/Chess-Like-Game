package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import conroller.ButtonPressed;
import view.GameEngineGUI;

public class GameEngine {
	
	GameEngineGUI gameEngineGUI = new GameEngineGUI(this);
	
	private Piece[] pieces;
	private Player[] players = new Player[2];
	
	private int maxMoves;
	
	private boolean playerTurn = true;
	
	private ButtonPressed buttonPressed;
	
	
	public GameEngine()
	{
		renderLoginRegisterGUI();
		renderMaxMovesGUI();
		buttonPressed = new ButtonPressed(this, gameEngineGUI);
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
		if(players[0].getMaxMoves() == 0)
		{
			players[0].setMaxMoves(maxMoves);
		}
		else if(players[1].getMaxMoves() == 0)
		{
			players[1].setMaxMoves(maxMoves);
		}
	}
	
	private void renderMaxMovesGUI()
	{
		//Render a new MaxMovesGUI.java class.
		
		gameEngineGUI.renderMaxMoves("Player 1");
		
		while(players[0].getMaxMoves() == 0)
		{
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
		
		gameEngineGUI.renderMaxMoves("Player 2");
		while(players[1].getMaxMoves() == 0)
		{
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
		
		//sets the max moves once both players inputs have been entered.
		this.maxMoves = (players[0].getMaxMoves() + players[1].getMaxMoves()) / 2;
	}
	
	public void renderBoardGUI()
	{
		gameEngineGUI.renderBoard(this);
		
		try {
			setPieces();
			gameEngineGUI.renderPieces();
		} catch (IOException e) {
			System.out.println("Could not render all pieces! File read error!");
		}
	}
	
	public void buttonPressed(int x, int y)
	{
		buttonPressed.buttonClicked(x, y);
	}
	
	public boolean movingOnOwnPiece(int newX, int newY, PieceType pieceType)
	{
		return buttonPressed.movingOnOwnPiece(newX, newY, pieceType);
	}
	
	public boolean getPlayerTurn()
	{
		return playerTurn;
	}
	
	public void setPlayerTurn(boolean turn)
	{
		playerTurn = turn;
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

	public void setPieces() throws IOException {
		pieces = new Piece[12];
		pieces[0] = new Rook(ImageIO.read(new File("img/WhiteRook.png")), 0, 0, PieceType.WHITE);
		pieces[1] = new Bishop(ImageIO.read(new File("img/WhiteBishop.png")), 0, 1, PieceType.WHITE);
		pieces[2] = new Knight(ImageIO.read(new File("img/WhiteKnight.png")), 0,2, PieceType.WHITE);
		pieces[3] = new Knight(ImageIO.read(new File("img/WhiteKnight.png")), 0,3, PieceType.WHITE);
		pieces[4] = new Bishop(ImageIO.read(new File("img/WhiteBishop.png")), 0,4, PieceType.WHITE);
		pieces[5] = new Rook(ImageIO.read(new File("img/WhiteRook.png")), 0,5, PieceType.WHITE);
		pieces[6] = new Rook(ImageIO.read(new File("img/BlackRook.png")), 5,0, PieceType.BLACK);
		pieces[7] = new Bishop(ImageIO.read(new File("img/BlackBishop.png")), 5,1, PieceType.BLACK);
		pieces[8] = new Knight(ImageIO.read(new File("img/BlackKnight.png")), 5,2, PieceType.BLACK);
		pieces[9] = new Knight(ImageIO.read(new File("img/BlackKnight.png")), 5,3, PieceType.BLACK);
		pieces[10] = new Bishop(ImageIO.read(new File("img/BlackBishop.png")), 5,4, PieceType.BLACK);
		pieces[11] = new Rook(ImageIO.read(new File("img/BlackRook.png")), 5,5, PieceType.BLACK);
	}

	public int getMaxMoves() {
		return maxMoves;
	}
}