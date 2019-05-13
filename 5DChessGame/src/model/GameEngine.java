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

	public GameEngine() {
		board = new Board(6, 6);
		this.isGameOver = false;
		this.loadUserData();
	}

	public boolean addUser(String id, String pwd) {
		if (getMember(id) == null) {
			User user = new User(id, pwd);
			this.users.put(id, user);
			return true;
		}
		return false;
	}

	public boolean addPlayer(String id, String pwd) {
		if (isValidUser(id, pwd) && !isDuplicatedPlayer(id)) {
			Player player = new Player(this, id, pwd);
			players[numOfPlayers] = player;
			players[numOfPlayers].setPlayerIndex(numOfPlayers + 1);
			players[numOfPlayers].initPieces();
			this.numOfPlayers++;
			return true;
		}

		return false;
	}

	public boolean isValidUser(String id, String pwd) {
		// Return the player if id exists in a key list of the players hash map
		for (User user : this.getAllUser()) {
			if (user.getUserId().equals(id) && user.getUserPwd().equals(pwd))
				return true;
		}

		return false;
	}

	public boolean isDuplicatedPlayer(String id) {
		// Return true if the player id already exists
		if (this.getNumOfPlayers() == 1)
			if (players[0].getUserId().equals(id)) {
				return true;
			}

		return false;
	}

	public void StartGame() {
		// Set max moves
		this.setMaxMove();
		// Randomly select the first turn
		this.setCurrentTurn((int) (Math.random() * 2 + 1)); // will return either 1 or 2

		// Connect player's pieces to the board
		for (Player player : this.getAllPlayers()) {
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

	public void connectPiecesToBoard(Player player) {
		this.board.connectPlayerPieces(player);
	}

	public MoveType decideMoveType(Piece piece, int x, int y) {
		Piece destinationPiece = board.getSquares(x, y).getPiece();
		// Prerequisite condition to commence a game and move a piece
		if (this.numOfPlayers == 2 && !this.isGameOver) {

			// If valid player turn and valid move then start moving
			if (piece.validMove(x, y) && board.isValidDestination(piece, x, y) && piece.getPlayer().isPlayerTurn()) {

				// If destination square is empty
				if ((destinationPiece == null)) {
					return MoveType.NormalMove;
				}
				// If destination square having piece of the same player
				if (destinationPiece.getPlayer().equals(piece.getPlayer())) {
					return MoveType.MergePiece;
				}
				// If destination square having piece of the other player
				if (!destinationPiece.getPlayer().equals(piece.getPlayer())) {
					return MoveType.RemoveOpponent;
				}
			}
		}

		return MoveType.InvalidMove;

	}

	public boolean normalMove(Piece piece, int toX, int toY) {
		// Disconnect piece from the current square
		board.disconnectPiece(piece.getPosX(), piece.getPosY());

		// Move piece to the new position
		piece.move(toX, toY);

		// Connect piece to the corresponding square
		board.connectPiece(piece, toX, toY);

		// Update number of move
		this.numOfMoves++;

		// Update the game status and the result
		updateGameState();

		// Change player's turn
		if (!this.isGameOver)
			this.flipTurn();

		return true;
	}

	public boolean removeOpponent(Piece piece, int toX, int toY) {
		// get opponent piece at destination position
		Piece opponentPiece = board.getSquares(toX, toY).getPiece();

		// Disconnect piece from the current square
		board.disconnectPiece(piece.getPosX(), piece.getPosY());

		// Move piece to the new position
		piece.move(toX, toY);

		// Connect piece to the corresponding square;
		board.connectPiece(piece, toX, toY);

		// Set the status of the opponent piece has been removed to inactive state
		opponentPiece.setStatus(false);

		// Update score
		updateScoreWhenRemoveOppopent(piece,opponentPiece);

		// Update number of move
		this.numOfMoves++;

		// Update the game status and the result
		updateGameState();

		// Change player's turn
		if (!this.isGameOver)
			this.flipTurn();

		return true;
	}

	public boolean mergePiece(Piece piece, int toX, int toY) {
		// Disconnect piece from the current square
		board.disconnectPiece(piece.getPosX(), piece.getPosY());

		// Move piece to the new position
		piece.move(toX, toY);

		// Create a merge piece
		MergedPiece mPiece = createMergePiece(piece, toX, toY);

		// Connect the merged piece to the corresponding square;
		board.connectPiece(mPiece, toX, toY);

		// Update number of move
		this.numOfMoves++;

		// Update the game status and the result
		updateGameState();

		// Change player's turn
		if (!this.isGameOver)
			this.flipTurn();

		return true;
	}

	public boolean movePiece(Piece piece, int toX, int toY) {
		switch (this.decideMoveType(piece, toX, toY)) {
		case NormalMove:
			return normalMove(piece, toX, toY);
		case RemoveOpponent:
			return removeOpponent(piece, toX, toY);
		case MergePiece:
			return mergePiece(piece, toX, toY);
		default:
			break;
		}

		return false;

	}
	
	private void updateScoreWhenRemoveOppopent(Piece piece, Piece opponentPiece) {
		// Update score
				if (opponentPiece instanceof MergedPiece) {
					piece.getPlayer()
							.setScore(piece.getPlayer().getScore() + 5 * ((MergedPiece) opponentPiece).getPieces().size());
				} else {
					piece.getPlayer().setScore(piece.getPlayer().getScore() + 5);
				}
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
			if (players[0].getNumOfRemainingPiece() == 0) {
				winner = players[1];
				setGameStatus(true);
			}

			if (players[1].getNumOfRemainingPiece() == 0) {
				winner = players[0];
				setGameStatus(true);
			}
		}

	}

	public String getGameResult() {
		if (this.isGameOver) {
			if (this.winner != null) {
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

	public User getMember(String id) {
		// Return the player if id exists in a key list of the players hash map
		return users.get(id);
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

	@Override
	public String toString() {
		return String.format("numOfMoves:%s, Score-Player1:%s, Score-Player1:%s\n", this.numOfMoves,
				this.players[0].getScore(), this.players[1].getScore());
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
	// YASIR CODE BEGIN

	public void writeDataToFile(String username, String password) {
		Scanner scanner;
		StringBuilder sb = new StringBuilder();
		try {
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while (scanner.hasNextLine()) {
				if (sb.length() != 0) {
					sb.append("\n");
				}

				String user = scanner.next();
				String pass = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());

				sb.append(user + ":" + pass + ":" + win + ":" + loss + ":");

				scanner.nextLine();
			}
			scanner.close();
		} catch (Exception e) {
		}

		try {
			PrintWriter out = new PrintWriter("database.txt");

			out.println(sb);
			out.print(username + ":" + password + ":" + 0 + ":" + 0 + ":");
			out.close();
		} catch (FileNotFoundException e) {
		}
	}

	// YASIR CODE END

	public void loadUserData() {

		String filePath = "database.txt";
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(":", 4);
				if (parts.length >= 2) {
					String id = parts[0];
					String pwd = parts[1];
					User user = new User(id, pwd);
					this.users.put(id, user);
				}
			}
			reader.close();

		} catch (Exception e) {
			// Block of code to handle errors
		}

	}

}
