package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GameEngine;
import model.Player;

class GameEngineTest {

	GameEngine gameEngine = new GameEngine();
	Player player = new Player("username", "password");
	Player player2 = new Player("username2", "password2");
	
	@BeforeEach
	void setUp() throws Exception {
		//gameEngine.addPlayer(player);
		//gameEngine.addPlayer(player2);
		gameEngine.startGame();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPlayer() {
		assertEquals(gameEngine.getPlayers()[0], player);
		assertEquals(gameEngine.getPlayers()[1], player2);
	}
	
	@Test //(expected=IndexOutOfBoundsException.class)
	void add3Players() throws IndexOutOfBoundsException{
		Player player3 = new Player("username3", "password3");
		//gameEngine.addPlayer(player3);
		
	}

}
