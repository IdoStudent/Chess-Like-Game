package model;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends User{
	private int numOfMove;
//	private Rook[] rooks = new Rook[2];
//	private Knight[] knights = new Knight[2];
//	private Bishop[] bishops = new Bishop[2];
	private Collection<Piece> pieces = new ArrayList<Piece>();
	private GameEngine game = new GameEngine();
	private int playerIndex;
	private int numOfPiece;




	public Player(String userId, String userPwd) {
		super(userId, userPwd);
		// TODO Auto-generated constructor stub
	}
	
	public Player(GameEngine game, String userId, String userPwd) {
		super(userId, userPwd);
		this.game = game;
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

		for (int i = 0; i <  w/ 2; i++) {
			String color = this.getPlayerIndex() == 0?"b":"w";
			int y = this.getPlayerIndex() ==0?0:5;
			if (i==0) { // Add 02 Rook
				pieces.add(new Rook(this,"R",color,i,y,false));
				pieces.add(new Rook(this,"R",color,w-1-i,y,false));
				numOfPiece+=2;
			}
			if (i==1) { // Add 02 Bishop
				pieces.add(new Bishop(this,"B",color,i,y,false));
				pieces.add(new Bishop(this,"B",color,w-1-i,y,false));
				numOfPiece+=2;

			}
			if (i==2) { // Add 02 Knight
				pieces.add(new Knight(this,"K",color,i,y,false));
				pieces.add(new Knight(this,"K",color,w-1-i,y,false));
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

	public int getNumOfPiece() {
		return numOfPiece;
	}

	public void setNumOfPiece(int numOfPiece) {
		this.numOfPiece = this.getAllPieces().size();
	}

}
