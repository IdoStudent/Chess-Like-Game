package view;

import model.GameEngine;
import model.Player;

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

	public void renderBoard(GameEngine gameEngine)
	{
		if(boardGUI == null)
		{
			boardGUI = new BoardGUI(gameEngine);
		}
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
	
	public void unRenderPosition(int x, int y)
	{
		boardGUI.unRenderPosition(x, y);
	}
	
	public void unRenderBoardColor()
	{
		boardGUI.unRenderBoardColor();
	}
	
	public void renderPossibleMoves(int newX, int newY)
	{
		boardGUI.renderPossibleMoves(newX, newY, gameEngine);
	}
	
	public void endGame(Player winner)
	{
		boardGUI.endGame(winner);
	}
}
