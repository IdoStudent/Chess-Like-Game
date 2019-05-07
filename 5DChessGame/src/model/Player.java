package model;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends User{
	private int numOfMove;
//	private Rook[] rooks = new Rook[2];
//	private Knight[] knights = new Knight[2];
//	private Bishop[] bishops = new Bishop[2];
	private Collection<CombinablePiece> pieces = new ArrayList<CombinablePiece>();
	private GameEngine game = new GameEngine();
//	private Board board;
	private int playerIndex;
	private int numOfRemainingPiece;


	private int score;


	public Player(String userId, String userPwd) {
		super(userId, userPwd);
		// TODO Auto-generated constructor stub
	}
	
	
	public Player(GameEngine game, String userId, String userPwd) {
		super(userId, userPwd);
		this.game=game;
		// TODO Auto-generated constructor stub
	}
	
	
	public int getNumOfMove() {
		return numOfMove;
	}
	public void setNumOfMove(int numOfMove) {
		this.numOfMove = numOfMove;
	}
	
	public boolean isPlayerTurn() {
		return this.playerIndex == game.getCurrentTurn();
	}
	
	public void initPieces() {
		int w = game.getBoard().getWidth();
		Board board = this.game.getBoard();

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
		
		numOfRemainingPiece += 6;
	}
	

	public int getPlayerIndex() {
		return playerIndex;
	}


	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}


	public Collection<CombinablePiece> getAllPieces() {
		return pieces;
	}
	
	public CombinablePiece getPiece(int x, int y) {
		for (CombinablePiece piece : pieces)
	      {
			if (piece.getPosX()==x && piece.getPosY()==y) {
				return piece;
			}		
	      }
		return null;
	}

	public int getNumOfRemainingPiece() {
		return numOfRemainingPiece;
	}


	public void updateRemainingPiece(int num) {
		this.numOfRemainingPiece += num;
	}

	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
