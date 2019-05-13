package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {
	
	private Map<String, User> users = new HashMap<String, User>();
	private Player[] players = new Player[2];
	private Board board;
	private int numOfPlayers = 0;
	private int numOfMoves = 0;
	private int currentTurn;
	private int maxMove = 0;
	private Player winner = null;
	private Piece selectedPiece;
	private boolean isGameOver;
	private IO io;

	public GameEngine() {
		board = new Board(6, 6);
		isGameOver = false;
		io = new IO(this);
	}

	public boolean addUser(String id, String pwd) {
		if (users.get(id) == null) {
			User user = new User(id, pwd);
			users.put(id, user);
			return true;
		}
		return false;
	}

	public boolean addPlayer(String id, String pwd) {
		if (isValidUser(id, pwd)) {
			Player player = new Player(this, id, numOfPlayers + 1);
			players[numOfPlayers] = player;
			numOfPlayers++;
			return true;
		}
		return false;
	}

	public boolean isValidUser(String id, String pwd) {
		for (User user : getAllUser()) { // Return the player if id exists in a key list of the players hash map
			if (user.getUserId().equals(id) && user.getUserPwd().equals(pwd)) {
				if (numOfPlayers == 1 && players[0].getUserId().equals(id)) {
					return false;
				}
				return true;
			}	
		}
		return false;
	}

	public void StartGame() {
		maxMove = (players[0].getNumOfMove() + players[1].getNumOfMove()) / 2; // Set max moves
		currentTurn = (int) (Math.random() * 2 + 1); // Randomly select the first turn // will return either 1 or 2
		for (Player player : getAllPlayers()) { // Connect player's pieces to the board
			board.connectPlayerPieces(player);
		}
	}

	public void flipTurn() {
		if (currentTurn == 1) {
			currentTurn = 2;
		} else {
			currentTurn = 1;
		}
	}
	
	public boolean movePiece(Piece piece, int x, int y) {	
		Piece destinationPiece = board.getSquares(x, y).getPiece();
		if (numOfPlayers == 2 && !isGameOver) { // Prerequisite condition to commence a game and move a piece
			if (piece.validMove(x, y) && board.isValidDestination(piece, x, y) && piece.getPlayer().isPlayerTurn()) { // If valid player turn and valid move then start moving
				if ((destinationPiece == null)) { // If destination square is empty
					return normalMove(piece, x, y, false);
				}
				if (destinationPiece.getPlayer().equals(piece.getPlayer())) {// If destination square having piece of the same player
					return normalMove(piece, x, y, true);
				}
				if (!destinationPiece.getPlayer().equals(piece.getPlayer())) {// If destination square having piece of the other player
					return removeOpponent(piece, x, y);
				}
			}
		}
		return false;
	}

	public boolean normalMove(Piece piece, int toX, int toY, boolean merge) {
		board.disconnectPiece(piece.getPosX(), piece.getPosY()); // Disconnect piece from the current square
		piece.move(toX, toY); // Move piece to the new position
		if (merge) {
			MergedPiece mPiece = createMergePiece(piece, toX, toY); // Create a merge piece
			board.connectPiece(mPiece, toX, toY); // Connect the merged piece to the corresponding square;
		}else {
			board.connectPiece(piece, toX, toY); // Connect piece to the corresponding square
		}
		numOfMoves++; // Update number of move
		updateGameState(); // Update the game status and the result
		if (!isGameOver) // Change player's turn
			flipTurn();
		return true;
	}

	public boolean removeOpponent(Piece piece, int toX, int toY) {
		Piece opponentPiece = board.getSquares(toX, toY).getPiece(); // get opponent piece at destination position
		board.disconnectPiece(piece.getPosX(), piece.getPosY()); // Disconnect piece from the current square
		piece.move(toX, toY); // Move piece to the new position
		board.connectPiece(piece, toX, toY); // Connect piece to the corresponding square;
		opponentPiece.setStatus(false); // Set the status of the opponent piece has been removed to inactive state
		if (opponentPiece instanceof MergedPiece) { //update score
			piece.getPlayer()
					.setScore(piece.getPlayer().getScore() + 5 * ((MergedPiece) opponentPiece).getPieces().size());
		} else {
			piece.getPlayer().setScore(piece.getPlayer().getScore() + 5);
		}
		numOfMoves++; // Update number of move
		updateGameState(); // Update the game status and the result
		if (!isGameOver) // Change player's turn
			flipTurn();
		return true;
	}

	public void updateGameState() {
		if (numOfMoves >= maxMove) { // Case 1: Number of moves exceed the maximum number of moves
			if (players[0].getScore() > players[1].getScore()) {
				winner = players[0];
			}
			if (players[0].getScore() < players[1].getScore()) {
				winner = players[1];
			}
			isGameOver = true;
		} else { // Case 2: one player takes out all the pieces of the opponent
			if (players[0].getNumOfRemainingPiece() == 0) {
				winner = players[1];
				isGameOver = true;
			}
			if (players[1].getNumOfRemainingPiece() == 0) {
				winner = players[0];
				isGameOver = true;
			}
		}
	}

	public String getGameResult() {
		if (isGameOver) {
			if (winner != null) {
				String color = winner.getPlayerIndex() == 1 ? "BLACK" : "WHITE";
				return "WINNER: " + winner.getUserId() + "(" + color + ")";
			} else {
				return "DRAW";
			}
		} else {
			return "";
		}
	}

	public MergedPiece createMergePiece(Piece piece, int toX, int toY) {
		Piece secondPiece = board.getSquares(toX, toY).getPiece();
		MergedPiece mergedPiece = null;
		if (!(piece instanceof MergedPiece) && !(secondPiece instanceof MergedPiece)) {
			mergedPiece = new MergedPiece(piece.getPlayer(), board, null, piece.getColor(), toX, toY);
			mergedPiece.addPiece(piece);
			mergedPiece.addPiece(secondPiece);
			piece.getPlayer().removePiece(piece);
			piece.getPlayer().removePiece(secondPiece);
			piece.getPlayer().addPiece(mergedPiece);
		}
		if (!(piece instanceof MergedPiece) && (secondPiece instanceof MergedPiece)) {
			mergedPiece = (MergedPiece) secondPiece;
			mergedPiece.addPiece(piece);
			piece.getPlayer().removePiece(piece);
		}
		if ((piece instanceof MergedPiece) && !(secondPiece instanceof MergedPiece)) {
			mergedPiece = (MergedPiece) piece;
			mergedPiece.addPiece(secondPiece);
			piece.getPlayer().removePiece(secondPiece);
		}
		mergedPiece.setName();
		return mergedPiece;
	}

	public void unmergePiece(MergedPiece combinedPiece, MergedPiece singlePiece, int toX, int toY) {
		if (movePiece((MergedPiece) singlePiece, toX, toY)) {
			combinedPiece.removePieceMember(singlePiece);
			combinedPiece.getPlayer().getAllPieces().add(singlePiece);
			combinedPiece.setName();
			board.connectPiece(combinedPiece, combinedPiece.getPosX(), combinedPiece.getPosY());
		}
	}

	public Player getPlayer(String id) {
		for (int i = 0; i < numOfPlayers; i++) {
			if (this.players[i].getUserId().equals(id))
				return this.players[i];
		}
		return null;
	}

	public Collection<User> getAllUser() {
		Collection<User> userList = users.values();
		return userList;
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	public Player getWinner() {
		return winner;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public int getCurrentTurn() {
		return currentTurn;
	}

	public Player[] getAllPlayers() {
		// Collection<Player> playerList = new ArrayList<Player>(players);
		return players;
	}

	public int getMaxMove() {
		return maxMove;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
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
}
