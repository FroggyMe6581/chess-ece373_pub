package org.chess.engine;

public class Queen extends Piece{

	public Queen(Square sq, PieceColor color) {
		super(sq, color);
		setName("Queen");
	}

	// Square sq is potential destination square for piece
	public boolean isValidMove(Square sq) {
		if (sq.sharesRowWith(this.getCurrentSquare())
				&& !sq.sharesColumnWith(this.getCurrentSquare())){
			if(!sq.pieceIsBetweenCol(this.getCurrentSquare()))
				return true;
			else
				return false;
		}
		else if (!sq.sharesRowWith(this.getCurrentSquare())
				&& sq.sharesColumnWith(this.getCurrentSquare())){
			if(!sq.pieceIsBetweenRow(this.getCurrentSquare()))
				return true;
			else
				return false;
		}
		else if(sq.isOnDiagonal(this.getCurrentSquare())){
			if(sq.pieceIsBetweenDiag(this.getCurrentSquare()))
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
