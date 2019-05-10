package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;

class PlayerTest {
	Player player;

	@BeforeEach
	void setUp() throws Exception {
		player = new Player("Anna","123"); 
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	 public void testGetPlayerId() { 
		 assertEquals("Anna",player.getPlayerId()); 
	 } 
	
	@Test
	 public void testSetPlayerId() { 
		player.setPlayerId("Anna Tran");
		assertEquals("Anna Tran",player.getPlayerId()); 
	 } 
	
	@Test
	 public void testGetPlayerPwd() { 
		assertEquals("123",player.getPlayerPwd()); 
	 } 

	@Test
	 public void testSetPlayerPwd() { 
		player.setPlayerPwd("12345");
		assertEquals("12345",player.getPlayerPwd()); 
	 } 
	
	@Test
	 public void testSetNumOfMove() { 
		player.setNumOfMove(10);
		assertEquals(10,player.getNumOfMove()); 
	 } 

}
