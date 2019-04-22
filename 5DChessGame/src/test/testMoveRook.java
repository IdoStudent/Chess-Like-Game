package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Board;
import model.CombinablePiece;
import model.GameEngine;
import model.Piece;
import model.Player;
import model.Rook;
import model.Square;
import model.User;

class testMoveRook {
	User user1, user2;
	Player player1, player2;
	CombinablePiece rook1, rook2;
	GameEngine game;
	
	@BeforeEach
	void setUp() throws Exception {
		game = new GameEngine();
		user1 = new User("1","a"); 
		user2 = new User("2","b"); 
		player1 = new Player("1","a");
		player2 = new Player("2","a");
		player1.initPieces();
		player2.initPieces();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test // Check if all valid players have been added to the game	
	 public void testGetAllPlayer() { 
		 assertEquals(2,game.getAllPlayers().length); 
		 assertEquals(false,game.addUser(user2.getUserId(), user2.getUserPwd())); 
	 } 
	
	@Test // Attempt	to	register	two	members	with	the	same	login	ID	fails.	
	 public void testMoveHorizontally() { 
		
		 // Get the Rook at the position (0,0)
		 rook1 = player1.getPiece(0, 0);
		 assertEquals(true, rook1 instanceof Rook); 
		 Board board = game.getBoard();
		 // Make sure the square is empty
		 Square square = board.getSquares(2, 0);
		 square.setPiece(null);
		 assertEquals(null, square.getPiece()); 
		 // Move test
		 assertEquals(true, game.movePiece(rook1, 2, 0)); 
		 assertEquals(false, game.movePiece(rook1, 3, 0)); 
	 
	 } 
	@Test // Attempt	to	register	two	members	with	the	same	login	ID	fails.	
	 public void testMoveVertically() { 
		
		 // Get the Rook at the position (0,0)
		 rook2 = player1.getPiece(5, 0);
		 assertEquals(true, rook2 instanceof Rook); 
		 Board board = game.getBoard();
		 // Make sure the square is empty
		 Square square = board.getSquares(0, 2);
		 square.setPiece(null);
		 assertEquals(null, square.getPiece()); 
		 // Move test
		 assertEquals(true, game.movePiece(rook2, 0, 2)); 
		 assertEquals(false, game.movePiece(rook2, 0, 3)); 

	 
	 } 

}
