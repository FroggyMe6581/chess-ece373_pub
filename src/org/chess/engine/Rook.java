package org.chess.engine;

public class Rook extends Piece {
/*
	public Rook(Square sq, PieceColor color) {
		super(sq, color);
		setName("Rook");
	}
*/
	public Rook(Square sq, PieceColor color) {
		super(sq, color);
		setName("Rook");
		if(color == PieceColor.WHITE)
			setImage("white_rook.png");
		else
			setImage("black_rook.png");
	}
	// Square sq is potential destination square for piece
	public boolean isValidMove(Square sq) {

		if (sq.sharesRowWith(this.getCurrentSquare())
				&& !sq.sharesColumnWith(this.getCurrentSquare())){
			if(sq.pieceIsBetweenCol(this.getCurrentSquare()))
				return false;
			else
				return true;
		}
		else if (!sq.sharesRowWith(this.getCurrentSquare())
				&& sq.sharesColumnWith(this.getCurrentSquare())){
			if(sq.pieceIsBetweenRow(this.getCurrentSquare()))
				return false;
			else
				return true;
		}
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
