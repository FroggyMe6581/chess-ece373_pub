package org.chess.testsuite;

import org.chess.engine.Piece;
import org.chess.engine.PieceColor;
import org.chess.engine.Square;

class TestPieceHelper extends Piece {
	public TestPieceHelper(Square sq, PieceColor color) {
		super(sq, color);
	}

	public boolean isValidMove(Square sq) {
		return true;
	}

	public boolean movePiece(Square sq) {
		this.setCurrentSquare(sq);
		return true;
	}
}
