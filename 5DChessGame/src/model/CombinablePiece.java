package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public abstract class CombinablePiece extends Piece {

//	private HashSet<Piece> pieces = new HashSet<Piece>();
	private HashMap<String,CombinablePiece> pieceMembers = new HashMap<String,CombinablePiece>();

	private String combinedName;

	public CombinablePiece(Player player, Board board, String name, String color, int X, int Y) {
		super(player, board, name, color, X, Y);
		// TODO Auto-generated constructor stub
		combinedName = this.getName();
	}

	@Override
	public abstract boolean validMove(int toX, int toY);

	public boolean combinedValidMove(int toX, int toY) {
		// TODO Auto-generated method stub
		for (CombinablePiece piece : this.getPieces()) {
			if (piece.validMove(toX, toY) && !piece.isMovingOverPiece(toX, toY))
				return true;
		}

		return false;
	}

	public boolean isValidToCombine(CombinablePiece destinationPiece) {
	
		for (CombinablePiece piece : this.getPieces()) {
			if (destinationPiece.getPieces().contains(piece))
				return false;
		}

		return true;
	}

	public void combinedMove(int toX, int toY) {
		// TODO Auto-generated method stub
		for (CombinablePiece piece : pieceMembers.values()) {
			piece.move(toX, toY);
		}
	}

	public Collection<CombinablePiece> getPieces() {
		 Collection<CombinablePiece> p = new ArrayList<CombinablePiece>();
		 TreeMap<String, CombinablePiece> sorted = new TreeMap<>(pieceMembers);
		 Set<Entry<String, CombinablePiece>> mappings = sorted.entrySet();
		 
		 for(Entry<String, CombinablePiece> mapping : mappings){
	           p.add(mapping.getValue());
	        }
		 
		 return p;
	}

	public void addPiece(CombinablePiece piece) {
		 if(!pieceMembers.containsKey(piece.getName())) {
		this.pieceMembers.put(piece.getName(), piece);
		 }
	}
	
	public void removePieceMember(CombinablePiece piece) {
		pieceMembers.remove(piece.getName());
	}
	
	public Piece getPieceMember(String name) {
		return pieceMembers.get(name);
	}

	public void setPieceMembers(HashMap<String,CombinablePiece> pieces) {
		this.pieceMembers = pieces;
	}

	public void setCombinedName(CombinablePiece piece) {
		
		String combinedName = "";
		for (CombinablePiece p : piece.getPieces()) {
			combinedName += p.getName();
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
