package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Rook;
import model.GameEngine;
import model.Knight;
import model.Piece;

class KnightTest {

	GameEngine gameEngine = new GameEngine();
	Piece knight;
	Piece rook;
	
	@BeforeEach
	void setUp() throws Exception {
		knight = new Knight(0, 2, "blackKnight");
		rook = new Rook(1, 2, "blackRook");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testMove() {
		assertEquals(knight.isValid(0,2,1,4,gameEngine), true);
		assertEquals(knight.isValid(0,2,3,2,gameEngine), false);
	}
	
	@Test
	void testMoveMoreOverPiece() {
		assertEquals(knight.isValid(0,2,2,3,gameEngine), true);
	}
	
}
