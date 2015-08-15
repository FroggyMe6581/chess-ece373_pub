package org.chess.engine;

public class King extends Piece{

	public King(Square sq, PieceColor color) {
		super(sq, color);
		setName("King");
		if(color == PieceColor.WHITE)
			setImage("white_king.png");
		else
			setImage("black_king.png");
	}

	// Square sq is potential destination square for piece
	public boolean isValidMove(Square sq) {

		int col_diff = sq.getSquareLocation()[0] - this.getCurrentSquare().getSquareLocation()[0];
		int row_diff = sq.getSquareLocation()[1] - this.getCurrentSquare().getSquareLocation()[1];

		if(Math.abs(col_diff) < 2 && Math.abs(row_diff) < 2){
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
