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
	
	public void renderLoginRegister(String player)
	{
		loginRegisterGUI = new LoginRegisterGUI(player);
		loginRegisterGUI.renderGUI(gameEngine);
	}

	public void renderBoard()
	{
		boardGUI = new BoardGUI();
	}
}
