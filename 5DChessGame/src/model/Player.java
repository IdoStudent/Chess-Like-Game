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
	private int numOfPiece;
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
	
	public void initPieces() {
		int w = game.getBoard().getWidth();
		Board board = this.game.getBoard();

		for (int i = 0; i <  w/ 2; i++) {
			String color = this.getPlayerIndex() == 0?"b":"w";
			int y = this.getPlayerIndex() ==0?0:5;
			if (i==0) { // Add 02 Rook
				pieces.add(new Rook(this,board,"R",color,i,y,false));
				pieces.add(new Rook(this,board,"R",color,w-1-i,y,false));
				numOfPiece+=2;
			}
			if (i==1) { // Add 02 Bishop
				pieces.add(new Bishop(this,board,"B",color,i,y,false));
				pieces.add(new Bishop(this,board,"B",color,w-1-i,y,false));
				numOfPiece+=2;

			}
			if (i==2) { // Add 02 Knight
				pieces.add(new Knight(this,board,"K",color,i,y,false));
				pieces.add(new Knight(this,board,"K",color,w-1-i,y,false));
				numOfPiece+=2;

			}
		}
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

	public int getNumOfPiece() {
		return numOfPiece;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
