package model;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends User{
	private int numOfMove = 0;
	private Collection<Piece> pieces = new ArrayList<Piece>();
	private GameEngine gameEngine;
	private int playerIndex;
	private int win;
	private int loss;
	private int score;
	
	public Player(GameEngine gameEngine, String userId, String userPwd,int playerIndex) {
		super(userId);
		this.gameEngine = gameEngine;
		this.playerIndex = playerIndex;
		initPieces();
	}
	
	
	public int getNumOfMove() {
		return numOfMove;
	}
	public void setNumOfMove(int numOfMove) {
		this.numOfMove = numOfMove;
	}
	
	public boolean isPlayerTurn() {
		return playerIndex == gameEngine.getCurrentTurn();
	}
	
	public void initPieces() {
		int w = gameEngine.getBoard().getWidth();
		Board board = gameEngine.getBoard();

		// Select color based on player index
		String color = this.getPlayerIndex() == 1 ? "b" : "w";
		
		// Select initial y position
		int y = this.getPlayerIndex() == 1 ? 0 : 5;
		
		// Assign 06 pieces to a player
		pieces.add(new Rook(this, board, "R", color, 0, y));
		pieces.add(new Bishop(this, board, "B", color, 1, y));
		pieces.add(new Knight(this, board, "K", color, 2, y));
		pieces.add(new Knight(this, board, "K", color, 3, y));
		pieces.add(new Bishop(this, board, "B", color, 4, y));
		pieces.add(new Rook(this, board, "R", color, 5, y));		
	}
	

	public Collection<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(Collection<Piece> pieces) {
		this.pieces = pieces;
	}

	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		this.pieces.remove(piece);
	}
	
	public int getPlayerIndex() {
		return playerIndex;
	}


	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}


	public Collection<Piece> getAllPieces() {
		return pieces;
	}
	
	public Piece getPiece(int x, int y) {
		for (Piece piece : pieces)
	      {
			if (piece.getPosX()==x && piece.getPosY()==y) {
				return piece;
			}		
	      }
		return null;
	}


	public int getNumOfRemainingPiece() {
		int num =0;
		for (Piece piece : pieces)
	      {
			if (piece instanceof MergedPiece) {
				if (piece.getStatus()) {
					num +=((MergedPiece) piece).getPieces().size();
				}	
			} else {
				if (piece.getStatus()) {
					num++;
				}	
			}
				
	      }
		return num;
	}

	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getWins()
	{
		return win;
	}
	
	public int getLosses()
	{
		return loss;
	}

}
