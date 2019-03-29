package Model;

import java.util.Scanner;

public class Player {
	
	private int playerID;
	private String playerName;
	private Scanner scanner = new Scanner(System.in);
	
	public Player(int playerID, String playerName) {
		this.playerID = playerID;
		this.playerName = playerName;
		System.out.println(playerID + " " + playerName);
	}
}
