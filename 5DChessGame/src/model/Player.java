package model;

public class Player extends User{
	private int numOfMove;
	public Player(String userId, String userPwd) {
		super(userId, userPwd);
		// TODO Auto-generated constructor stub
	}
	public int getNumOfMove() {
		return numOfMove;
	}
	public void setNumOfMove(int numOfMove) {
		this.numOfMove = numOfMove;
	}


}
