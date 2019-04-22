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


	
//	public void removeSinglePiece(int x,int y) {
//		CombinablePiece singlePiece=null;
//		for (CombinablePiece piece : this.pieces)
//	      {
//			if (piece.getPosX()== x && piece.getPosY()==y&& piece.getPieces().size()<=1) {
//				singlePiece=piece;
//			}		
//	      }
//		this.pieces.remove(singlePiece);
//	}

	
//	public boolean movePiece(GameEngine game, CombinablePiece piece, int toX, int toY) {
//		Board board = this.game.getBoard();
//		if (piece.combinedValidMove(toX, toY)) {
////			if (!board.isMovingOverPiece(piece, toX, toY)) {
//				if (this.selectMoveType(board, piece, toX, toY) == MoveType.NormalMove) {
//					// Drop piece out of the current square
//					board.dropPiece(piece.getPosX(), piece.getPosY());
//					
//					// Update current position of the combined piece to the new position
//					piece.combinedMove(toX, toY);
//					
//					// Add the piece to the association square;
//					board.addPiece(piece, toX, toY);
//					
//					// Update number of move
//					this.game.setNumOfMoves(this.game.getNumOfMoves() + 1);
//					return true;
//				}
//
//				if (this.selectMoveType(board, piece, toX, toY) == MoveType.RemoveOpponent) {
//					// get opponent player ID
//					Piece opponentPiece = board.getSquares(toX, toY).getPiece();
//					// Drop piece out of the current square
//					board.dropPiece(piece.getPosX(), piece.getPosY());
//					// Update current position of the piece to the new position
//					piece.combinedMove(toX, toY);
//					// Add the piece to the association square;
//					board.addPiece(piece, toX, toY);
//					// Set the status of the opponent piece has been remove to inactive
//					opponentPiece.setStatus(false);
//
//					// Update score
//					this.score += 5;
//
//					// Update number of move
//					this.game.setNumOfMoves(this.game.getNumOfMoves() + 1);
//
//					return true;
//				}
//				
//				if (this.selectMoveType(board, piece, toX, toY) == MoveType.MergePiece) {
//					// Drop piece at the current square
//					board.dropPiece(piece.getPosX(), piece.getPosY());
//					
//					// Update the current position of the piece to the new position
//					piece.combinedMove(toX, toY);
//					
////					// Add the piece to the association square;
////					board.mergePiece(piece, toX, toY);
////					
////					// Remove the single piece have been merged to combined piece
////					this.removeSinglePiece(toX,toY);
//					mergePiece(board, piece, toX, toY);
//					// Update number of move
//					this.game.setNumOfMoves(this.game.getNumOfMoves() + 1);
//
//					return true;
//				}
////			}
//		}
//		return false;
//	}
//	
//	public void mergePiece(Board board, CombinablePiece piece,int toX, int toY) {
//		CombinablePiece secondPiece = board.getSquares(toX, toY).getPiece();
//		CombinablePiece masterPiece = null;
//		CombinablePiece slavePiece = null;
//		if(piece.getPieces().size()>secondPiece.getPieces().size()) {
//			masterPiece = piece;
//			slavePiece = secondPiece;
//		} else {
//			masterPiece = secondPiece ;
//			slavePiece = piece;
//		}
//		
//		for (Piece p : slavePiece.getPieces()) {
//			masterPiece.addPiece(p);
//		}
//
//		masterPiece.setCombinedName(masterPiece.getPieces());
//		this.getAllPieces().remove(slavePiece);
//		board.addPiece(masterPiece, toX, toY);
//
//	}
//	
//	
//	public MoveType selectMoveType(Board board, CombinablePiece piece, int x, int y) {
//		if ((board.getSquares(x, y).getPiece()==null)) {
//			return MoveType.NormalMove;
//		}
//		if(board.getSquares(x, y).getPiece().getPlayer().equals(piece.getPlayer())&&!haveDuplicatedPiece(board,piece,x,y)){
//			return MoveType.MergePiece;
//		} 
//		
//		if(!board.getSquares(x, y).getPiece().getPlayer().equals(piece.getPlayer())){
//			return MoveType.RemoveOpponent;
//		} 
//		
//		return MoveType.InvalidMove;
//		
//	}
//	
//	public boolean haveDuplicatedPiece(Board board, CombinablePiece piece, int toX, int toY) {
//		CombinablePiece piece1= piece;
//		CombinablePiece piece2= board.getSquares(toX, toY).getPiece();
//		if(piece1.getPieces().size()>2||piece2.getPieces().size()>2) {return true;}
//		if(piece1.getPieces().size()==2&&piece2.getPieces().size()==2) {return true;}
//		
//		for (Piece p : piece1.getPieces()) {
//		    if(piece2.getPieces().contains(p)) return true;
//		}
//		for (Piece p : piece2.getPieces()) {
//		    if(piece1.getPieces().contains(p)) return true;
//		}
//		
//		return false;
//	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
