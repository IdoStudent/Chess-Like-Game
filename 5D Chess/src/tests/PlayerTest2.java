package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;

class PlayerTest2 {
	Player player;

	@BeforeEach
	void setUp() throws Exception {
		player = new Player("Anna","123"); 
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	 public void testSetscore() { 
		player.setScore(1000);
		assertEquals(1000,player.getScore()); 
	 } 
	
	@Test
	 public void testSetResult() { 
		player.setResult(true);
		assertEquals(true,player.getResult()); 
	 } 



}
