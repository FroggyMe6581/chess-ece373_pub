package org.chess.engine;

public class Knight extends Piece{

	public Knight(Square sq, PieceColor color) {
		super(sq, color);
		setName("Knight");
	}

	// Square sq is potential destination square for piece
	public boolean isValidMove(Square sq) {
		if (sq.sharesRowWith(this.getCurrentSquare())
				&& !sq.sharesColumnWith(this.getCurrentSquare()))
			return true;
		else if (!sq.sharesRowWith(this.getCurrentSquare())
				&& sq.sharesColumnWith(this.getCurrentSquare()))
			return true;
		else
			return false;
	}

	// Square sq is destination square; move there if legal
	public boolean movePiece(Square sq) {
		if (isValidMove(sq)) {
			super.setCurrentSquare(sq);
			return true;
		}
		return false;
	}
	
}
