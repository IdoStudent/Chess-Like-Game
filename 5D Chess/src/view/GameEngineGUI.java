package view;

import model.GameEngine;

public class GameEngineGUI {
	BoardGUI boardGUI;
	LoginRegisterGUI loginRegisterGUI;
	GameEngine gameEngine;
	
	public GameEngineGUI(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
	}
	
	public void renderLoginRegister()
	{
		boolean playerLoggedIn = false;
		loginRegisterGUI = new LoginRegisterGUI("Player 1");
		loginRegisterGUI.renderGUI(gameEngine);
		while(playerLoggedIn == false)
		{
			if(gameEngine.getPlayers()[0] != null)
			{
				playerLoggedIn = true;
				System.out.println("LOGGED");
			}
		}
		loginRegisterGUI = new LoginRegisterGUI("Player 2");
		loginRegisterGUI.renderGUI(gameEngine);
		while(gameEngine.getPlayers()[1] == null)
		{
			
		}
	}

	public void renderBoard()
	{
		boardGUI = new BoardGUI();
	}
}
