package model;

import java.util.Scanner;

public class Player {
	
	private String playerId;
	private String playerPwd;
	private int score;
	private int numOfMove;
	private boolean result;
	private Scanner scanner = new Scanner(System.in);
	
	public Player(String playerId, String playerPwd) {
		this.playerId = playerId;
		this.playerPwd = playerPwd;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerPwd() {
		return playerPwd;
	}

	public void setPlayerPwd(String playerPwd) {
		this.playerPwd = playerPwd;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNumOfMove() {
		return numOfMove;
	}

	public void setNumOfMove(int numOfMove) {
		this.numOfMove = numOfMove;
	}
	

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	public Piece setPiece() {
		return null;
	}
	
	public void movePiece(Piece p, int x, int y) {
	
	}
}
