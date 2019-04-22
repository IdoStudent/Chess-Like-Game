package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class GameEngine {
	private Map<String, User> members = new HashMap<String, User>();
	private Player[] players = new Player[2];
	private Board board ;
	private int numOfPlayers=0;
	private int numOfMoves=0;
	int maxMove = 0 ;


	public GameEngine() {
		// TODO Auto-generated constructor stub
//		initBoard(6,6);
		this.board = new Board(6,6);
		
	}


	public boolean addUser(String id, String pwd) {
		if(getMember(id)==null) {
			User user = new User(id,pwd);
			this.members.put(id,user);
			return true;
		}
		return false;	
	}
	
	public boolean addPlayer(String id, String pwd) {
		if(isValidUser(id,pwd)) {
			Player player = new Player(this,id,pwd);
			players[numOfPlayers]=player;
			players[numOfPlayers].setPlayerIndex(numOfPlayers);
			players[numOfPlayers].initPieces();
			this.numOfPlayers++;
			return true;
		} 
		
		return false;
	}
	
	
	public void addPieceToBoard(Player player) {
				this.board.addPlayerPieces(player);
	}
	
	public boolean isValidUser(String id, String pwd) {
		// Return the player if id exists in a key list of the players hash map
		 for (User user : this.getAllUser())
	      {
			if (user.getUserId().equals(id)&&user.getUserPwd().equals(pwd))
				return true;
	      }
		 return false;
	}
	
	public User getMember(String id) {
		// Return the player if id exists in a key list of the players hash map
		
		 return members.get(id);
	}
	
	public Player getPlayer(String id) {
		for (int i=0;i<numOfPlayers;i++) {	
		if (this.players[i].getUserId().equals(id))
			
			 return this.players[i];
		 }
		return null;
	}
	


	public Collection<User> getAllUser() {
		Collection<User> userList = members.values();
		return userList;
	}
	
	public Player[] getAllPlayers() {
//		Collection<Player> playerList = new ArrayList<Player>(players);
		return players;
	}

	public int getMaxMove() {
		return maxMove;
	}

	public void assignNumofMove(String id, int numMove) {
		this.getPlayer(id).setNumOfMove(numMove);
		this.maxMove += numMove;

	}
	
	public Board getBoard() {
		return board;
	}


	public int getNumOfMoves() {
		return numOfMoves;
	}


	public void setNumOfMoves(int numOfMoves) {
		this.numOfMoves = numOfMoves;
	}
	
	public boolean movePiece(CombinablePiece piece, int toX, int toY) {
		if (piece.combinedValidMove(toX, toY)) {
//			if (!board.isMovingOverPiece(piece, toX, toY)) {
				if (this.selectMoveType(piece, toX, toY) == MoveType.NormalMove) {
					// Drop piece out of the current square
					board.dropPiece(piece.getPosX(), piece.getPosY());
					
					// Update current position of the combined piece to the new position
					piece.combinedMove(toX, toY);
					
					// Add the piece to the association square;
					board.addPiece(piece, toX, toY);
					
					// Update number of move
					this.numOfMoves++;
					
					return true;
				}

				if (this.selectMoveType(piece, toX, toY) == MoveType.RemoveOpponent) {
					// get opponent player ID
					Piece opponentPiece = board.getSquares(toX, toY).getPiece();
					// Drop piece out of the current square
					board.dropPiece(piece.getPosX(), piece.getPosY());
					// Update current position of the piece to the new position
					piece.combinedMove(toX, toY);
					// Add the piece to the association square;
					board.addPiece(piece, toX, toY);
					// Set the status of the opponent piece has been remove to inactive
					opponentPiece.setStatus(false);

					// Update score
					piece.getPlayer().setScore(piece.getPlayer().getScore()+5);

					// Update number of move
					this.numOfMoves++;

					return true;
				}
				
				if (this.selectMoveType(piece, toX, toY) == MoveType.MergePiece) {
					// Drop piece at the current square
					board.dropPiece(piece.getPosX(), piece.getPosY());
					
					// Update the current position of the piece to the new position
					piece.combinedMove(toX, toY);

					// Merge and add the piece to the association square;
					mergePiece(piece, toX, toY);
					// Update number of move
					this.numOfMoves++;

					return true;
				}
//			}
		}
		return false;
	}
	
	public MoveType selectMoveType(CombinablePiece piece, int x, int y) {
		CombinablePiece destinationPiece = board.getSquares(x, y).getPiece();
		
		if ((destinationPiece==null)) {
			return MoveType.NormalMove;
		}
		if(destinationPiece.getPlayer().equals(piece.getPlayer())&&piece.validCombineTo(destinationPiece)){
			return MoveType.MergePiece;
		} 
		
		if(!destinationPiece.getPlayer().equals(piece.getPlayer())){
			return MoveType.RemoveOpponent;
		} 
		
		return MoveType.InvalidMove;
		
	}
	
	public void mergePiece(CombinablePiece piece,int toX, int toY) {
		CombinablePiece secondPiece = board.getSquares(toX, toY).getPiece();
		CombinablePiece masterPiece = null;
		CombinablePiece slavePiece = null;
		if(piece.getPieces().size()>secondPiece.getPieces().size()) {
			masterPiece = piece;
			slavePiece = secondPiece;
		} else {
			masterPiece = secondPiece ;
			slavePiece = piece;
		}
		
		for (Piece p : slavePiece.getPieces()) {
			masterPiece.addPiece(p);
		}

		masterPiece.setCombinedName(masterPiece.getPieces());
		piece.getPlayer().getAllPieces().remove(slavePiece);
		
		//Add the merged piece to the association square;
		board.addPiece(masterPiece, toX, toY);

	}
	
	public void unmergePiece(CombinablePiece combinedPiece,String singlePieceName, int toX, int toY) {
	
		Piece singlePiece = combinedPiece.getPieceMember(singlePieceName);
		if (movePiece((CombinablePiece)singlePiece,toX, toY)) {
			combinedPiece.removePieceMember(singlePieceName);
			combinedPiece.getPlayer().getAllPieces().add((CombinablePiece) singlePiece);
			combinedPiece.setCombinedName(combinedPiece.getPieces());
			board.addPiece(combinedPiece, combinedPiece.getPosX(), combinedPiece.getPosY());
//
//			singlePiece.setPosX(toX);
//			singlePiece.setPosY(toY);
//			board.addPiece((CombinablePiece)singlePiece, toX, toY);
		}
		

	}
	
	
	@Override
	public String toString() {
		return String.format("numOfMoves:%s, Score-Player1:%s, Score-Player1:%s\n", this.numOfMoves, this.players[0].getScore(),this.players[1].getScore());
	}
	
	

}
