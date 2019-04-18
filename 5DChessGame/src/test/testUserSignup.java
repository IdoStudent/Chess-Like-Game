package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GameEngine;
import model.Player;
import model.User;

class testUserSignup {
	User user1, user2;
	GameEngine game;
	@BeforeEach
	void setUp() throws Exception {
		user1 = new User("Anna","123"); 
		user2 = new User("Anna","234"); 
		game = new GameEngine();
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test // Attempt	to	register	two	members	with	the	same	login	ID	fails.	
	 public void testAddUser() { 
		 assertEquals(true,game.addUser(user1.getUserId(), user1.getUserPwd())); 
		 assertEquals(false,game.addUser(user2.getUserId(), user2.getUserPwd())); 
	 } 

	@Test // Check member list after a user has been signed up
	 public void getRegisteredUser() { 
		 assertEquals("Anna",game.getMember(user1.getUserId())); 
		 assertEquals(1,game.getAllUser().size()); 
	 } 
}
