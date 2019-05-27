package model;

public class Board {
	private int width;
	private int height;
	private Square[][] squares;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		squares = new Square[width][height];
		initSquares();
	}

	public void initSquares() {
		for (int y = 0; y < width; y++) {
			for (int x = 0; x < height; x++) {
				squares[x][y] = new Square(x, y);
			}
		}
	}

	public void connectPlayerPieces(Player player) {
		for (Piece piece : player.getAllPieces()) {
			connectPiece(piece, piece.getPosX(), piece.getPosY());
		}
	}
	
	public void connectPiece(Piece piece, int x, int y) {
		squares[x][y].setName("(" + piece.getName() + piece.getColor() + ")");
		squares[x][y].setPiece(piece);
	}

	public void disconnectPiece(int x, int y) {
		squares[x][y].setName("(  )");
		squares[x][y].setPiece(null);
	}

	public boolean isValidDestination(Piece piece, int x, int y) {
		Piece destinationPiece = squares[x][y].getPiece();
		if (destinationPiece == null) { // Empty square
			return true;
		} else { // Square having piece
			if (destinationPiece.getPlayer() != piece.getPlayer()) { // pieces belong to different players
				return true;
			} else { // pieces belong to the same player
				String name = destinationPiece.getName();
				int posX = destinationPiece.getPosX();
				int posY = destinationPiece.getPosY();
				String color = destinationPiece.getColor();
				if (piece.isValidToCombine(name,posX,posY,color))
					return true;
			}
		}
		return false;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Square getSquares(int x, int y) {
		return squares[x][y];
	}

	public Square[][] getAllSquares() {
		return squares;
	}
}
