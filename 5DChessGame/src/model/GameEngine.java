package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameEngine {
	private Map<String, User> members = new HashMap<String, User>();
	private Player[] players = new Player[2];
	private Board board;
	private int numOfPlayers = 0;
	private int numOfMoves = 0;
	private int currentTurn;
	

	private int maxMove = 0;
	private Player winner = null;
	

	private CombinablePiece selectedPiece;
	private boolean isGameOver;

	public GameEngine() {
		this.board = new Board(6, 6);
		this.isGameOver = false;
	}

	public boolean addUser(String id, String pwd) {
		if (getMember(id) == null) {
			User user = new User(id, pwd);
			this.members.put(id, user);
			return true;
		}
		return false;
	}

	public void StartGame() {
		// Set max moves
		this.setMaxMove()
		;
		// Randomly select the first turn
		this.setCurrentTurn((int) (Math.random() * 2 + 1)); // will return either 1 or 2
		
		// Connect player's pieces to the board
		for(Player player: this.getAllPlayers()){
			this.board.connectPlayerPieces(player);
		}
	}

	public void flipTurn() {
		if (this.currentTurn == 1) {
			currentTurn = 2;
		} else {
			currentTurn = 1;
		}
	}

	public boolean addPlayer(String id, String pwd) {
		if (isValidUser(id, pwd)) {
			Player player = new Player(this, id, pwd);
			players[numOfPlayers] = player;
			players[numOfPlayers].setPlayerIndex(numOfPlayers + 1);
			players[numOfPlayers].initPieces();
			this.numOfPlayers++;
			return true;
		}

		return false;
	}

	public void addPieceToBoard(Player player) {
		this.board.connectPlayerPieces(player);
	}

	public boolean isValidUser(String id, String pwd) {
		// Return the player if id exists in a key list of the players hash map
		for (User user : this.getAllUser()) {
			if (user.getUserId().equals(id) && user.getUserPwd().equals(pwd))
				return true;
		}

		return false;
	}

	public User getMember(String id) {
		// Return the player if id exists in a key list of the players hash map
		return members.get(id);
	}

	public Player getPlayer(String id) {
		for (int i = 0; i < numOfPlayers; i++) {
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
		// Collection<Player> playerList = new ArrayList<Player>(players);
		return players;
	}

	public int getMaxMove() {
		return maxMove;
	}

	public void setMaxMove() {
		this.maxMove = (players[0].getNumOfMove() + players[1].getNumOfMove()) / 2;
		// this.maxMove = 5;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public void assignNumofMove(String id, int numMove) {
		this.getPlayer(id).setNumOfMove(numMove);
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
		// Prerequisite condition to commence a game and move a piece
		if (this.numOfPlayers == 2 && !this.isGameOver) {
			
			// If valid player turn and valid move then start moving
			if (piece.combinedValidMove(toX, toY) && piece.getPlayer().isPlayerTurn()) { 

				if (this.decideMoveType(piece, toX, toY) == MoveType.NormalMove) {
					// Disconnect piece from the current square
					board.disconnectPiece(piece.getPosX(), piece.getPosY());

					// Move piece to the new position
					piece.combinedMove(toX, toY);

					// Connect piece to the corresponding square
					board.connectPiece(piece, toX, toY);

					// Update number of move
					this.numOfMoves++;

					// Update the game status and the result
					updateGameState();
					
					// Change player's turn
					this.flipTurn();

					return true;
				}

				if (this.decideMoveType(piece, toX, toY) == MoveType.RemoveOpponent) {

					// get opponent piece at destination position
					CombinablePiece opponentPiece = board.getSquares(toX, toY).getPiece();

					// Disconnect piece from the current square
					board.disconnectPiece(piece.getPosX(), piece.getPosY());

					// Move piece to the new position
					piece.combinedMove(toX, toY);

					// Connect piece to the corresponding square;
					board.connectPiece(piece, toX, toY);

					// Set the status of the opponent piece has been removed to inactive state
					opponentPiece.setStatus(false);

					// Update score
					piece.getPlayer().setScore(piece.getPlayer().getScore() + 5);

					// Update opponent's remaining number of pieces
					opponentPiece.getPlayer().updateRemainingPiece(-opponentPiece.getPieces().size());

					// Update number of move
					this.numOfMoves++;

					// Update the game status and the result
					updateGameState();
					
					// Change player's turn
					this.flipTurn();

					return true;
				}

				if (this.decideMoveType(piece, toX, toY) == MoveType.MergePiece) {
					// Disconnect piece from the current square
					board.disconnectPiece(piece.getPosX(), piece.getPosY());

					// Move piece to the new position
					piece.combinedMove(toX, toY);

					// Merge piece and connect the merged piece to the corresponding square;
					mergePiece(piece, toX, toY);

					// Update number of move
					this.numOfMoves++;

					// Update the game status and the result
					updateGameState();
					
					// Change player's turn
					this.flipTurn();

					return true;
				}

			}
		}
		return false;
	}

	public void updateGameState() {

		// Case 1: Number of moves exceed the maximum number of moves
		if (this.numOfMoves >= this.maxMove) {
			if (players[0].getScore() > players[1].getScore()) {
				winner = players[0];
			}

			if (players[0].getScore() < players[1].getScore()) {
				winner = players[1];
			}

			setGameStatus(true);

		} else {
			// Case 2: one player takes out all the pieces of the opponent
			for (int i = 0; i < players.length; i++) {
				if (players[i].getNumOfRemainingPiece() == 0) {
					winner = players[i];
					setGameStatus(true);
				}
			}
		}

	}

	public String getGameResult() {
		if (this.isGameOver) {	
			if (this.winner != null) {
			String color = winner.getPlayerIndex()==1?"BLACK":"WHITE";
			return "WINNER: " + winner.getUserId() + "(" + color + ")" ;
			} else {
				return "DRAW";
			}
		} else {
			return "";
		}	
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public Player getWinner() {
		return winner;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameStatus(boolean gameStatus) {
		this.isGameOver = gameStatus;
	}
	
	public int getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}

	public MoveType decideMoveType(CombinablePiece piece, int x, int y) {
		CombinablePiece destinationPiece = board.getSquares(x, y).getPiece();

		if ((destinationPiece == null)) {
			return MoveType.NormalMove;
		}
		if (destinationPiece.getPlayer().equals(piece.getPlayer()) && piece.validCombineTo(destinationPiece)) {
			return MoveType.MergePiece;
		}

		if (!destinationPiece.getPlayer().equals(piece.getPlayer())) {
			return MoveType.RemoveOpponent;
		}

		return MoveType.InvalidMove;

	}

	public void mergePiece(CombinablePiece piece, int toX, int toY) {
		CombinablePiece secondPiece = board.getSquares(toX, toY).getPiece();
		CombinablePiece masterPiece = null;
		CombinablePiece slavePiece = null;
		if (piece.getPieces().size() > secondPiece.getPieces().size()) {
			masterPiece = piece;
			slavePiece = secondPiece;
		} else {
			masterPiece = secondPiece;
			slavePiece = piece;
		}

		for (CombinablePiece p : slavePiece.getPieces()) {
			masterPiece.addPiece(p);
		}

		masterPiece.setCombinedName(masterPiece);

		piece.getPlayer().getAllPieces().remove(slavePiece);

		// Add the merged piece to the corresponding square;
		board.connectPiece(masterPiece, toX, toY);

	}

	public void unmergePiece(CombinablePiece combinedPiece, CombinablePiece singlePiece, int toX, int toY) {

		if (movePiece((CombinablePiece) singlePiece, toX, toY)) {
			combinedPiece.removePieceMember(singlePiece);
			combinedPiece.getPlayer().getAllPieces().add(singlePiece);
			combinedPiece.setCombinedName(combinedPiece);
			board.connectPiece(combinedPiece, combinedPiece.getPosX(), combinedPiece.getPosY());
		}
	}


	public CombinablePiece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(CombinablePiece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	@Override
	public String toString() {
		return String.format("numOfMoves:%s, Score-Player1:%s, Score-Player1:%s\n", this.numOfMoves,
				this.players[0].getScore(), this.players[1].getScore());
	}
	
	

}
