package org.chess.testsuite;

import org.chess.engine.Piece;
import org.chess.engine.Square;

class TestPieceHelper extends Piece {
	public TestPieceHelper(Square sq) {
		super(sq);
	}

	public boolean isValidMove(Square sq) {
		return true;
	}

	public void movePiece(Square sq) {
		this.setCurrentSquare(sq);
	}
}
