package org.chess.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.chess.engine.Piece;
import org.chess.engine.Square;

public class PieceTest {

	public class TestPiece extends Piece {
		public TestPiece(Square sq) {
			super(sq);
		}

		public boolean isValidMove(Square sq) {
			return true;
		}

		public void movePiece(Square sq) {
			this.setCurrentSquare(sq);
		}
	}

	@Test
	public void currentSquareTest() {
		fail("Not yet implemented");
	}
}
