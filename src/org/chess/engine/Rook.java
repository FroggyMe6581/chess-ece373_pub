package org.chess.engine;

public class Rook extends Piece {

	private String name = "Rook";

	public Rook(Square sq) {
		super(sq);
	}

	public String getPieceType() {
		return name;
	}

	public boolean isValidMove(Square sq)
	// Square sq is potential destination square for piece
	{
		if ((sq.getLocation()[0] == this.getCurrentSquare().getLocation()[0] && sq
				.getLocation()[1] != this.getCurrentSquare().getLocation()[1])
				|| (sq.getLocation()[1] == this.getCurrentSquare().getLocation()[1] && sq
						.getLocation()[0] != this.getCurrentSquare().getLocation()[0])) {
			return true;
		} else
			return false;
	}

	public void movePiece(Square sq)
	// Square sq is destination square; move there if legal
	{
		if (isValidMove(sq)) {
			this.getCurrentSquare().removePiece();
			sq.setPiece(this);
			this.setCurrentSquare(sq);
		}
	}

}
