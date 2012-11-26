package org.chess.engine;

public abstract class Piece {
	private Square location;
	private String name;
	private PieceColor color;

	public Piece(Square sq, PieceColor color) {
		this.color = color;
		setCurrentSquare(sq);
	}

	public final Square getCurrentSquare() {
		return location;
	}

	public final void setCurrentSquare(Square sq) {
		if (location != null)
			location.removePiece();

		location = sq;
		sq.setPiece(this);
	}
	
	public final PieceColor getPieceColor() {
		return color;
	}

	public abstract boolean isValidMove(Square sq);

	public abstract void movePiece(Square sq);

	
	//setter for String name used in the constructor for subclasses of Piece.
	public void setName(String name) {
		this.name = name;
	}

	//getter for String name
	public String getPieceType() {
		return name;
	}
}
