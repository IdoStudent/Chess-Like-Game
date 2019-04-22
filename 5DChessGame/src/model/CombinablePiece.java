package model;

import java.util.HashSet;

public abstract class CombinablePiece extends Piece {

	private HashSet<Piece> pieces = new HashSet<Piece>();
	private String combinedName;

	public CombinablePiece(Player player, Board board, String name, String color, int X, int Y, boolean status) {
		super(player, board, name, color, X, Y, status);
		// TODO Auto-generated constructor stub
		combinedName = this.getName();
	}

	@Override
	public abstract boolean validMove(int toX, int toY);

	public boolean combinedValidMove(int toX, int toY) {
		// TODO Auto-generated method stub
		for (Piece piece : pieces) {
			if (piece.validMove(toX, toY) && !piece.isMovingOverPiece(toX, toY))
				return true;
		}

		return false;
	}

	public boolean validCombineTo(CombinablePiece destinationPiece) {
	
		for (Piece piece : this.getPieces()) {
			if (destinationPiece.getPieces().contains(piece))
				return false;
		}

		return true;
	}

	public void combinedMove(int toX, int toY) {
		// TODO Auto-generated method stub
		for (Piece piece : pieces) {
			piece.move(toX, toY);
		}
	}

	public HashSet<Piece> getPieces() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		// if(!pieces.contains(piece)) {
		this.pieces.add(piece);
		// }
	}
	
	public void removePieceMember(String name) {
		Piece p=null;
		for (Piece piece : pieces) {
			if (piece.getName().equals(name)) {
				p=piece;
				break;
			}
		}
		pieces.remove(p);
	}
	
	public Piece getPieceMember(String name) {
		Piece p=null;
		for (Piece piece : pieces) {
			if (piece.getName().equals(name)) {
				p=piece;
				break;
			}
		}
		return p;
	}

	public void setPieces(HashSet<Piece> pieces) {
		this.pieces = pieces;
	}

	public void setCombinedName(HashSet<Piece> pieces) {
		String combinedName = "";
		for (Piece piece : pieces) {
			combinedName += piece.getName();
		}
		this.combinedName = combinedName;
	}

	public String getCombinedName() {
		return combinedName;
	}

	@Override
	public String toString() {
		return String.format("CombinedName:%s,Name:%s, Color:%s, X:%s, Y:%s\n", this.combinedName, this.getName(),
				this.getColor(), this.getPosX(), this.getPosY());
	}
}
