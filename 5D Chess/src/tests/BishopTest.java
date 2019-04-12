package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import model.Bishop;
import model.GameEngine;
import model.Player;

class BishopTest {

	GameEngine gameEngine = new GameEngine();
	
	BufferedImage blackBishopImage;
	Bishop bishop = new Bishop(blackBishopImage, 0, 0, "black");
	
	@BeforeEach
	void setUp() throws Exception {
		try {
			blackBishopImage = ImageIO.read(new File("img/BlackBishop.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetImage() {
		assertEquals(bishop.getImage(), blackBishopImage);
	}
	
	@Test
	void testMove() {
		bishop.move(1,1);
		assertEquals(bishop.getX(), 1);
		assertEquals(bishop.getY(), 1);
	}
	
	@Test
	void testIsValid() {
		bishop.isValid(2,2);
		assertEquals(bishop.isValid(), true);
	}
}
