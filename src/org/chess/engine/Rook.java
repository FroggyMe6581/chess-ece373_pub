package org.chess.engine;

public class Rook extends Piece {

	private String name = "Rook";

	public Rook(Square sq) {
		super(sq);
	}

	public String getPieceType() {
		return name;
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
	public void movePiece(Square sq) {
		if (isValidMove(sq)) {
			this.getCurrentSquare().removePiece();
			sq.setPiece(this);
			this.setCurrentSquare(sq);
		}
	}

}
