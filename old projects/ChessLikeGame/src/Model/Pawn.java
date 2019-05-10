package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pawn {
	
	Bishop bishop;
	Rook rook;
	Knight knight;
	
	public Pawn() {
		bishop = new Bishop();
		rook = new Rook();
		knight = new Knight();
	}
    
	public Bishop getBishhop() {
		return bishop;
	}
	
	public Rook getRook() {
		return rook;
	}
	
	public Knight getKnight() {
		return knight;
	}
    
    
}
