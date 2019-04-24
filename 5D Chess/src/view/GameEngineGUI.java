package view;

import model.GameEngine;

public class GameEngineGUI {
	BoardGUI boardGUI;
	LoginRegisterGUI loginRegisterGUI;
	MaxMovesGUI maxMovesGUI;
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
	
	public void renderMaxMoves(String player)
	{
		maxMovesGUI = new MaxMovesGUI(player);
		maxMovesGUI.renderGUI(gameEngine);
	}

	public void renderBoard()
	{
		boardGUI = new BoardGUI();
		boardGUI.renderGUI(gameEngine);
	}
	
	public void renderPieces()
	{
		boardGUI.renderPieces(gameEngine);
	}
	
	public void renderSelectedPiece(int x, int y)
	{
		boardGUI.renderSelectedPiece(x, y);
	}
	
	public void renderPossibleMoves(int newX, int newY)
	{
		boardGUI.renderPossibleMoves(newX, newY);
	}
}
