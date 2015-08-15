package org.chess.engine;

public class Bishop extends Piece{

	public Bishop(Square sq, PieceColor color) {
		super(sq, color);
		setName("Bishop");
		if(color == PieceColor.WHITE)
			setImage("white_bishop.png");
		else
			setImage("black_bishop.png");
	}

	// Square sq is potential destination square for piece
	public boolean isValidMove(Square sq) {
		if(sq.isOnDiagonal(this.getCurrentSquare())){
			if(!sq.pieceIsBetweenDiag(this.getCurrentSquare()))
				return true;
			else
				return false;
		}
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
