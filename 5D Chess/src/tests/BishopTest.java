package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bishop;
import model.GameEngine;
import model.Piece;

class BishopTest {

	GameEngine gameEngine = new GameEngine();
	Piece bishop; 
	
	@BeforeEach
	void setUp() throws Exception {
		bishop = new Bishop(0, 0, "blackBishop");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testIsValid() {
		assertEquals(bishop.isValid(0,0,2,2,gameEngine), true);
		assertEquals(bishop.isValid(1,1,2,2,gameEngine), false);
	}
	
	@Test
	void testMove() {
		if(bishop.isValid(0, 0, 2, 2, gameEngine)) {
			bishop.move(2,2);
		}
		assertEquals(bishop.getX(), 2);
		assertEquals(bishop.getY(), 2);
	}
	
	@Test
	void testMoveMoreThanTwo() {
		if(bishop.isValid(0, 0, 3, 3, gameEngine)) {
			bishop.move(3,3);
		}
		assertEquals(bishop.getX(), 3);
		assertEquals(bishop.getY(), 3);
	}
	
	@Test
	void testMoveNotDiagonally() {
		if(bishop.isValid(0, 0, 0, 2, gameEngine)) {
			bishop.move(0,2);
		}
		assertEquals(bishop.getX(), 2);
		assertEquals(bishop.getY(), 0);
	}
	
}
