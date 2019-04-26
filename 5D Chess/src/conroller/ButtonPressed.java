package conroller;

import model.GameEngine;
import model.Piece;
import model.PieceType;
import view.GameEngineGUI;

public class ButtonPressed {
	
	GameEngine gameEngine;
	GameEngineGUI gameEngineGUI;
	
	private Piece pieceSelected;
	
	public ButtonPressed(GameEngine gameEngine, GameEngineGUI gameEngineGUI)
	{
		this.gameEngine = gameEngine;
		this.gameEngineGUI = gameEngineGUI;
	}
	
	public void buttonClicked(int x, int y)
	{
		if(pieceSelected != null)
		{
			checkIfOtherButtonClicked(x, y);
		}
		checkIfPieceClicked(x, y);
	}
	
	private void checkIfPieceClicked(int x, int y)
	{
		for(Piece p : gameEngine.getPieces())
		{
			if(p.getX() == x && 
			   p.getY() == y && 
			   gameEngine.getPlayerTurn() == true && 
			   p.getType() == PieceType.WHITE ||
			   p.getX() == x && 
			   p.getY() == y && 
			   gameEngine.getPlayerTurn() == false && 
			   p.getType() == PieceType.BLACK)
			{
				if(p.getEliminated() == false)
				{
					pieceSelected = p;
					gameEngineGUI.renderSelectedPiece(x, y);
					for(int newY = 0; newY < 6; newY++)
					{
						for(int newX = 0; newX < 6; newX++)
						{
							if(p.isValid(p.getY(), p.getX(), newY, newX, gameEngine) == true)
							{
								gameEngineGUI.renderPossibleMoves(newX, newY);
							}
						}
					}
				}
			}
		}
	}
	
	private void checkIfOtherButtonClicked(int x, int y)
	{
		if(pieceSelected.isValid(pieceSelected.getY(), pieceSelected.getX(), y, x, gameEngine) == true)
		{
			checkIfPieceEliminated(x,y);
			moveAndUpdatePieces(x, y);
			pieceSelected = null;
			gameEngine.setPlayerTurn(!gameEngine.getPlayerTurn());
			gameEngine.setMaxMoves(gameEngine.getMaxMoves() - 1);
			gameEngineGUI.renderBoard(gameEngine);
			gameEngineGUI.renderPieces();
			gameEngine.winChecker();
		}
		else
		{
			gameEngineGUI.unRenderBoardColor();
			pieceSelected = null;
		}
	}
	
	private void moveAndUpdatePieces(int x, int y)
	{
		gameEngineGUI.unRenderPosition(pieceSelected.getX(), pieceSelected.getY());
		pieceSelected.move(y, x);
		gameEngineGUI.unRenderBoardColor();
		if(gameEngine.getPlayerTurn() == true)
		{
			gameEngine.getPlayers()[0].setNumOfMove(gameEngine.getPlayers()[0].getNumOfMove() + 1);
			System.out.println(gameEngine.getPlayers()[0].getPlayerId() + " moved " + 
					   pieceSelected.getClass().getName().substring(pieceSelected.getClass().getName().indexOf(".") + 1) + 
					   " to " + x + "," + y);
			System.out.println(gameEngine.getPlayers()[1].getPlayerId() + "'s turn.");
		}
		else
		{
			gameEngine.getPlayers()[1].setNumOfMove(gameEngine.getPlayers()[1].getNumOfMove() + 1);
			System.out.println(gameEngine.getPlayers()[1].getPlayerId() + " moved " + 
					   pieceSelected.getClass().getName().substring(pieceSelected.getClass().getName().indexOf(".") + 1) + 
					   " to " + x + "," + y);
			System.out.println(gameEngine.getPlayers()[0].getPlayerId() + "'s turn.");
		}
	}
	
	private void checkIfPieceEliminated(int x, int y)
	{
		final int ELIMINATED_PIECE = -1;
		
		for(Piece p : gameEngine.getPieces())
		{
			if(p.getX() == x && 
			   p.getY() == y &&
			   p.getType() != pieceSelected.getType())
			{
				if(gameEngine.getPlayerTurn() == true)
				{
					gameEngine.getPlayers()[0].setScore(gameEngine.getPlayers()[0].getScore() + 5);
					System.out.println(gameEngine.getPlayers()[0].getPlayerId() +
							" eliminated " + p.getClass().getName().substring(pieceSelected.getClass().getName().indexOf(".") + 1));
				}
				else
				{
					gameEngine.getPlayers()[1].setScore(gameEngine.getPlayers()[1].getScore() + 5);
					System.out.println(gameEngine.getPlayers()[1].getPlayerId() +
							" eliminated " + p.getClass().getName().substring(pieceSelected.getClass().getName().indexOf(".") + 1));
				}
				gameEngineGUI.unRenderPosition(x, y);
				p.eliminated(true);
				p.move(ELIMINATED_PIECE, ELIMINATED_PIECE);
			}
		}
	}
	
	public boolean movingOnOwnPiece(int newX, int newY, PieceType pieceType)
	{
		for(Piece p : gameEngine.getPieces())
		{
			if(p.getX() == newX && p.getY() == newY && pieceType == p.getType())
			{
				return true;
			}
		}
		return false;
	}
}
