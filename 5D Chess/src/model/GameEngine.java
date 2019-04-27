package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
		renderBoardGUI();
		buttonPressed = new ButtonPressed(this, gameEngineGUI);
		System.out.println("Game started...");
		System.out.println("Credits to: Anna Tran, Walaa Aqeel, Brandon Sarkis, Ido Yaron & Yasir Fayrooz.");
		System.out.println("Max moves is calculated by the average of Player 1: " + players[0].getMaxMoves() + " and Player 2: " + players[1].getMaxMoves());
	}
	
	private void renderLoginRegisterGUI()
	{
		boolean player1LoggedIn = false;
		boolean player2LoggedIn = false;
		
		gameEngineGUI.renderLoginRegister("Player 1");
		while(player1LoggedIn == false)
		{
			try {Thread.sleep(500);} catch (InterruptedException e) {}
			if(getPlayers()[0] != null)
			{
				player1LoggedIn = true;
			}
		}
		
		gameEngineGUI.renderLoginRegister("Player 2");
		while(player2LoggedIn == false)
		{
			try {Thread.sleep(500);} catch (InterruptedException e) {}
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
		
		if(checkUsernamePasswordCorrect(username, password) == false)
		{
			return false;
		}
		else
		{
			Player player = new Player(username);
			addPlayer(player);
			return true;
		}
	}
	
	public boolean registerPlayer(String username, String password)
	{
		//validate username and password,
		//check if username is already registered,
		//create new player object,
		//run addPlayer method and pass in new player object
		
		if(checkIfUsernameExists(username) == true)
		{
			return false;
		}
		else
		{
			if(requirements(username, password) == false)
			{
				return false;
			}
			else
			{
				Player player = new Player(username);
				addPlayer(player);
				writeDataToFile(username, password);
				return true;
			}
		}
	}
	
	private boolean checkUsernamePasswordCorrect(String username, String password)
	{
		Scanner inputStream = null;	
		try
		{
			inputStream = new Scanner(new File("database.txt"));
			inputStream.useDelimiter(":");
			
			while(inputStream.hasNextLine())
			{
				String user = inputStream.next();
				String pass = inputStream.next();
				
				if(user.equals(username) && pass.equals(password))
				{
					inputStream.close();
					return true;
				}
				
				inputStream.nextLine();
			}
			
			inputStream.close();
		} catch(Exception e) {
			return false;
		}
		return false;
	}
	
	private boolean checkIfUsernameExists(String username)
	{
		Scanner inputStream = null;	
		try
		{
			inputStream = new Scanner(new File("database.txt"));
			inputStream.useDelimiter(":");
			
			while(inputStream.hasNextLine())
			{
				String user = inputStream.next();
				
				if(user.equals(username))
				{
					inputStream.close();
					return true;
				}
				inputStream.nextLine();
			}
			
			inputStream.close();
		} catch(Exception e) {
			return true;
		}
		return false;
	}
	
	private boolean requirements(String username, String password)
	{
		if(username.length() > 10)
		{
			return false;
		}
		else if(username.contains(":") || password.contains(":"))
		{
			return false;
		}
		else
		{
			return true;
		}
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
	
	public int getMaxMoves() {
		return maxMoves;
	}
	
	public void setMaxMoves(int maxMoves)
	{
		this.maxMoves = maxMoves;
	}
	
	private void renderMaxMovesGUI()
	{
		//Render a new MaxMovesGUI.java class.
		
		gameEngineGUI.renderMaxMoves("Player 1");
		
		while(players[0].getMaxMoves() == 0)
		{
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		}
		
		gameEngineGUI.renderMaxMoves("Player 2");
		while(players[1].getMaxMoves() == 0)
		{
			try {Thread.sleep(500);} catch (InterruptedException e) {}
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
	
	//If pieces all destroyed OR If max moves = 0
	public void winChecker()
	{
		int whiteEliminated = 0;
		int blackEliminated = 0;
		
		for(Piece p : pieces)
		{
			if(p.getEliminated() == true)
			{
				if(p.getType() == PieceType.BLACK)
					blackEliminated++;
				else if(p.getType() == PieceType.WHITE)
					whiteEliminated++;
			}
		}
		
		if(whiteEliminated == 6)
		{
			endGame(players[1]);
		}
		else if(blackEliminated == 6)
		{
			endGame(players[0]);
		}
		else if(maxMoves == 0)
		{
			if(players[0].getScore() > players[1].getScore())
			{
				endGame(players[0]);
			}
			else if(players[1].getScore() > players[0].getScore())
			{
				endGame(players[1]);
			}
			else
			{
				endGame(null);
			}
		}
	}
	
	private void endGame(Player winner)
	{
		gameEngineGUI.endGame(winner);
	}
	
	public void writeDataToFile(Player winner)
	{
		int winnerIndex = 1;
		int loserIndex = 0;
		if(players[0].equals(winner))
		{
			winnerIndex = 0;
			loserIndex = 1;
		}
		
		Scanner scanner;
		StringBuilder sb = new StringBuilder();
		try
		{
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while(scanner.hasNextLine())
			{
				if(sb.length() != 0)
				{
					sb.append("\n");
				}
				
				String username = scanner.next();
				String password = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());
				
				if(username.equals(players[winnerIndex].getPlayerId()))
				{
					if(winner != null)
					win++;
				}
				else if(username.equals(players[loserIndex].getPlayerId()))
				{
					if(winner != null)
					loss++;
				}
				
				sb.append(username + ":" + 
						  password + ":" + 
						  win + ":" + 
						  loss + ":");
				
				scanner.nextLine();
			}
			scanner.close();
		}
		catch(Exception e){}
		
		try 
		{
			PrintWriter out = new PrintWriter("database.txt");
			
			out.print(sb);
			out.close();
		}
		catch (FileNotFoundException e) {}
		
		System.exit(0);
	}
	
	public void writeDataToFile(String username, String password)
	{
		Scanner scanner;
		StringBuilder sb = new StringBuilder();
		try
		{
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while(scanner.hasNextLine())
			{
				if(sb.length() != 0)
				{
					sb.append("\n");
				}
				
				String user = scanner.next();
				String pass = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());
				
				sb.append(user + ":" + 
						  pass + ":" + 
						  win + ":" + 
						  loss + ":");
				
				scanner.nextLine();
			}
			scanner.close();
		}
		catch(Exception e){}
		
		try 
		{
			PrintWriter out = new PrintWriter("database.txt");
			
			out.println(sb);
			out.print(username + ":" + password + ":" + 0 + ":" + 0 + ":");
			out.close();
		}
		catch (FileNotFoundException e) {}
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
}