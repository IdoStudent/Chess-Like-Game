package model;

public class Temp {
	
	public static void main(String[] args) {
		
		Piece bishop = new Bishop(0,0,"blackBishop");
		System.out.println(bishop.getX());
		System.out.println(bishop.getY());
		bishop.move(1, 1);
		System.out.println(bishop.getX());
		System.out.println(bishop.getY());

	}

}
