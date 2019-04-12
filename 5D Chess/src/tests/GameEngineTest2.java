package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Board;
import model.Piece;
import model.Player;
import view.GameEngineGUI;

class GameEngine {
	public int maxMoves = 0;
	private Player[] players = new Player[2];
	
	public GameEngine()
	{
		this.setMaxMoves(maxMoves());
	}
		
	public int maxMoves()
	{
		return 0;
	}
			
	public int getMaxMoves()
	{
		return maxMoves;
	}
	

	public void setMaxMoves(int maxMoves)
	{
		this.maxMoves = maxMoves;
	}
	
	public void addPlayer(Player player)
	{
		for(int i = 0; i < players.length; i++)
		{
			if(players[i] == null)
			{
				players[i] = player;
			}
		}
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	

}
public class GameEngineTest2 {
	
	GameEngine gameEngine = new GameEngine();
	Player player = new Player("username", "password");
	Player player2 = new Player("username2", "password2");

	@Before
	public void setUp() throws Exception {
			gameEngine.addPlayer(player);
			gameEngine.addPlayer(player2);
			player.setNumOfMove(50);
			player2.setNumOfMove(30);
			player.getNumOfMove();
			player2.getNumOfMove();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test //The	maximum	number	of	moves	must	be	determined	averaging	the	desired	number specified	by	both	players	before	the	game	commences.	
	public void checkMaxMoves() {
		assertEquals(gameEngine.getMaxMoves(), (player.getNumOfMove() + player2.getNumOfMove()) / 2);
		
		fail("maxMoves =/= average of desired max moves");
	}	

}
