package org.chess.testsuite;

import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.chess.engine.Square;
import org.chess.engine.Piece;

public class PieceTest {
	int rank, file;
	Square sq1;

	@Before
	public void setUp() {
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());

		rank = rnd.nextInt(7) + 1;
		file = rnd.nextInt(7) + 1;

		sq1 = new Square(file, rank);
	}

	@After
	public void tearDown() {
		sq1 = null;
		rank = -1;
		file = -1;
	}

	@Test
	public void currentSquareTest() {
		Piece p = new TestPieceHelper(sq1);
		Square cur = p.getCurrentSquare();

		assertEquals(sq1, cur);
		assertEquals(cur.getSquareLocation()[0], file);
		assertEquals(cur.getSquareLocation()[1], rank);
	}
}
