package view;

import model.GameEngine;

public class GameEngineGUI {
	
	GameEngine gameEngine;
	
	BoardGUI boardGUI;
	LoginRegisterGUI loginRegisterGUI;
	MaxMovesGUI maxMovesGUI;

	public GameEngineGUI(GameEngine gameEngine) 
	{
		this.gameEngine = gameEngine;
	}

	public void renderLoginRegister(String player) 
	{
		loginRegisterGUI = new LoginRegisterGUI(player);
		loginRegisterGUI.renderGUI(gameEngine);
	}
	
	public void renderMaxMoves(String player) 
	{
		maxMovesGUI = new MaxMovesGUI(player);
		maxMovesGUI.renderGUI(gameEngine);
	}
	
	public void renderBoard() 
	{
		if(boardGUI == null)
		{
			boardGUI = new BoardGUI();
		}
		boardGUI.renderGUI(gameEngine);
	}


}
