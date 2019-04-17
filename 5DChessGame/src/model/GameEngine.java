package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class GameEngine {
	private Map<String, User> users = new HashMap<String, User>();
	private Player[] players = new Player[2];
	private Board board ;
	private int numPlayer=0;

	int maxMove = 0 ;


	public GameEngine() {
		// TODO Auto-generated constructor stub
		this.board = new Board(6,6);
		
	}

	public boolean addUser(String id, String pwd) {
		if(getUser(id)==null) {
			User user = new User(id,pwd);
			this.users.put(id,user);
			return true;
		}
		return false;	
	}
	
	public boolean addPlayer(String id, String pwd) {
		if(isValidUser(id,pwd)) {
			Player player = new Player(id,pwd);
			players[numPlayer]=player;
			this.numPlayer++;
			return true;
		} 
		
		return false;
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
	
	public User getUser(String id) {
		// Return the player if id exists in a key list of the players hash map
		
		 return users.get(id);
	}
	
	public Player getPlayer(String id) {
		// Return the player if id exists in a key list of the players hash map
		for (int i=0;i<numPlayer;i++) {	
		if (this.players[i].getUserId().equals(id))
			
			 return this.players[i];
		 }
		return null;
	}


	public Collection<User> getAllUser() {
		Collection<User> userList = users.values();
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


}
