package model;

import view.GameEngineGUI;

public class GameEngine {
	
	private Player[] players = new Player[2];
	
	User user = new User(this);
	
	GameEngineGUI gameEngineGUI;
	
	public GameEngine()
	{
		gameEngineGUI = new GameEngineGUI(this);
	}
	
	public void startGame() 
	{
		gameEngineGUI.renderLoginRegister("Player 1");
		while(players[0] == null) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		gameEngineGUI.renderLoginRegister("Player 2");
		while(players[1] == null) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		gameEngineGUI.renderMaxMoves("Player 1");
		while(players[0].getMaxMoves() == 0) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		gameEngineGUI.renderMaxMoves("Player 2");
		while(players[1].getMaxMoves() == 0) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		gameEngineGUI.renderBoard();
	}
	
	public boolean loginPlayer(String username, String password)
	{
		return user.loginPlayer(username, password);
	}

	public boolean registerPlayer(String username, String password) {
		return user.registerPlayer(username, password);
	}
	
	public void addPlayer(Player player)
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

	public void writeDataToFile(String username, String password) 
	{
		new WriteDataToFile(username, password);
	}

	public Player[] getPlayers() {
		return players;
	}
}
