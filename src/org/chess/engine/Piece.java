package org.chess.engine;

public abstract class Piece {
	private Square location;

	public Piece(Square sq) {
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

	public abstract boolean isValidMove(Square sq);

	public abstract void movePiece(Square sq);
}
