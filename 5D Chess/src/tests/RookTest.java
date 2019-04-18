package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Rook;
import model.GameEngine;
import model.Piece;

class RookTest {

	GameEngine gameEngine = new GameEngine();
	Piece rook; 
	
	@BeforeEach
	void setUp() throws Exception {
		rook = new Rook(0, 1, "blackRook");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testIsValid() {
		assertEquals(rook.isValid(0,1,2,1,gameEngine), true);
		assertEquals(rook.isValid(0,1,3,1,gameEngine), false);
	}
	
	@Test
	void testMove2() {
		if(rook.isValid(0, 1, 2, 1, gameEngine)) {
			rook.move(2,1);
		}
		assertEquals(rook.getX(), 1);
		assertEquals(rook.getY(), 2);
	}
	
	@Test
	void testMove() {
		if(rook.isValid(0, 1, 1, 1, gameEngine)) {
			rook.move(1,1);
		}
		assertEquals(rook.getX(), 1);
		assertEquals(rook.getY(), 1);
	}
	
	@Test
	void testMoveMoreThanTwo() {
		if(rook.isValid(0, 1, 3, 1, gameEngine)) {
			rook.move(3,1);
		}
		assertEquals(rook.getX(), 1);
		assertEquals(rook.getY(), 3);
	}
	
	@Test
	void testMoveNotPerpendicularlyOrHorizontally() {
		if(rook.isValid(0, 1, 2, 3, gameEngine)) {
			rook.move(2,3);
		}
		assertEquals(rook.getX(), 3);
		assertEquals(rook.getY(), 2);
	}
	
}
