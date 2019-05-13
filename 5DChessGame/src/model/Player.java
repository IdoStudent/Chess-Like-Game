package model;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends User{
	
	private int numOfMove = 0;
	private Collection<Piece> pieces = new ArrayList<Piece>();
	private GameEngine gameEngine;
	private int playerIndex;
	private int score;
	
	public Player(GameEngine gameEngine, String userId,int playerIndex) {
		super(userId);
		this.gameEngine = gameEngine;
		this.playerIndex = playerIndex;
		initPieces();
	}
	
	public void initPieces() {
		Board board = gameEngine.getBoard();
		String color = playerIndex == 1 ? "b" : "w"; // Select color based on player index
		int y = playerIndex == 1 ? 0 : 5; // Select initial y position
		
		// Assign 06 pieces to a player
		pieces.add(new Rook(this, board, "R", color, 0, y));
		pieces.add(new Bishop(this, board, "B", color, 1, y));
		pieces.add(new Knight(this, board, "K", color, 2, y));
		pieces.add(new Knight(this, board, "K", color, 3, y));
		pieces.add(new Bishop(this, board, "B", color, 4, y));
		pieces.add(new Rook(this, board, "R", color, 5, y));		
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

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		this.pieces.remove(piece);
	}
	
	public int getPlayerIndex() {
		return playerIndex;
	}

	public Collection<Piece> getAllPieces() {
		return pieces;
	}
	
	public Piece getPiece(int x, int y) {
		for (Piece piece : pieces){
			if (piece.getPosX()==x && piece.getPosY()==y) {
				return piece;
			}		
	      }
		return null;
	}

	public int getNumOfRemainingPiece() {
		int num = 0;
		for (Piece piece : pieces){
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
}
