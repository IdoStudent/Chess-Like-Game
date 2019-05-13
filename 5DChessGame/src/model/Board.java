package model;

public class Board {
	private int width;
	private int height;
	private Square[][] squares;

	public Board(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		this.squares = new Square[width][height];
		this.initSquares();
	}

	public void initSquares() {
		for (int y = 0; y < this.width; y++) {
			for (int x = 0; x < this.height; x++) {
				squares[x][y] = new Square(x, y);
			}
		}
	}

	public void connectPlayerPieces(Player player) {

		for (Piece piece : player.getAllPieces()) {
			connectPiece(piece, piece.getPosX(), piece.getPosY());
		}
	}

	public void disconnectPiece(int x, int y) {
		squares[x][y].setName("(  )");
		squares[x][y].setPiece(null);
	}

	public void connectPiece(Piece piece, int x, int y) {
		squares[x][y].setName("(" + piece.getName() + piece.getColor() + ")");
		squares[x][y].setPiece(piece);
	}

	public boolean isValidDestination(Piece piece, int x, int y) {
		Piece destinationPiece = this.getAllSquares()[x][y].getPiece();

		if (destinationPiece == null) { // Empty square
			return true;
		} else { // Square having piece
			if (destinationPiece.getPlayer() != piece.getPlayer()) { // pieces belong to different players
				return true;
			} else { // pieces belong to a same player

				if ((piece instanceof MergedPiece) && !(destinationPiece instanceof MergedPiece)) {
					if (piece.isValidToCombine(destinationPiece.getName(),destinationPiece.getPosX(),destinationPiece.getPosY(),destinationPiece.getColor()))
						return true;
				}

				if ((destinationPiece instanceof MergedPiece) && !(piece instanceof MergedPiece)) {
					if (destinationPiece.isValidToCombine(piece.getName(),destinationPiece.getPosX(),destinationPiece.getPosY(),destinationPiece.getColor()))
						return true;
				}
				if (!(destinationPiece instanceof MergedPiece) && !(piece instanceof MergedPiece)) {
					if (destinationPiece.isValidToCombine(piece.getName(),destinationPiece.getPosX(),destinationPiece.getPosY(),destinationPiece.getColor()))
						return true;
				}

			}
		}
		return false;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Square getSquares(int x, int y) {
		return squares[x][y];
	}

	public Square[][] getAllSquares() {
		return squares;
	}

	@Override
	public String toString() {
		String b = "";
		for (int y = 0; y < this.width; y++) {
			for (int x = 0; x < this.height; x++) {
				b += squares[x][y].toString();
			}
			b += "\n";
		}
		return b;
	}
}
