package org.chess.testsuite;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.chess.engine.GameBoard;
import org.chess.engine.PieceColor;
import org.chess.engine.Square;

public class SquareTest {

	GameBoard genericGameBoard = new GameBoard();

	Square sq1 = new Square(5, 5, genericGameBoard);
	Square sq2 = new Square(5, 1, genericGameBoard);
	Square sq3 = new Square(1, 5, genericGameBoard);
	Square sq4 = new Square(3, 3, genericGameBoard);
	Square sq5 = new Square(5, 5, genericGameBoard);
	Square rndsq;
	int rank, file;

	@Before
	public void setUp() {
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());

		rank = rnd.nextInt(7) + 1;
		file = rnd.nextInt(7) + 1;
		sq1 = new Square(5, 5, genericGameBoard);
		sq2 = new Square(5, 1, genericGameBoard);
		sq3 = new Square(1, 5, genericGameBoard);
		sq4 = new Square(3, 3, genericGameBoard);
		sq5 = new Square(5, 5, genericGameBoard);
		rndsq = new Square(file, rank, genericGameBoard);
	}

	@After
	public void tearDown() {
		sq1 = null;
		sq2 = null;
		sq3 = null;
		sq4 = null;
		sq5 = null;
		rndsq = null;
		file = -1;
		rank = -1;
	}

	@Test
	public void getSquareLocationTest() {
		assertEquals(sq1.getSquareLocation()[0], 5);
		assertEquals(sq1.getSquareLocation()[1], 5);

		assertEquals(sq2.getSquareLocation()[0], 5);
		assertEquals(sq2.getSquareLocation()[1], 1);

		assertEquals(sq3.getSquareLocation()[0], 1);
		assertEquals(sq3.getSquareLocation()[1], 5);

		assertEquals(rndsq.getSquareLocation()[0], file);
		assertEquals(rndsq.getSquareLocation()[1], rank);
	}

	@Test
	public void equalsTest() {
		assertTrue(sq1.equals(sq1));
		assertFalse(sq1.equals(sq2));
		assertFalse(sq1.equals(sq3));
		assertFalse(sq1.equals(sq4));
		assertTrue(sq1.equals(sq5));

		if (file == 5 && rank == 5)
			assertTrue(sq1.equals(rndsq));
		else
			assertFalse(sq1.equals(rndsq));
	}

	@Test
	public void getRankTest() {
		assertEquals(sq1.getRank(), 5);
		assertEquals(sq2.getRank(), 1);
		assertEquals(sq3.getRank(), 5);
		assertEquals(sq4.getRank(), 3);
		assertEquals(rndsq.getRank(), rank);
	}

	@Test
	public void getFileTest() {
		assertEquals(new Square(1, 1, genericGameBoard).getFile(), 'a');
		assertEquals(new Square(2, 1, genericGameBoard).getFile(), 'b');
		assertEquals(new Square(3, 1, genericGameBoard).getFile(), 'c');
		assertEquals(new Square(4, 1, genericGameBoard).getFile(), 'd');
		assertEquals(new Square(5, 1, genericGameBoard).getFile(), 'e');
		assertEquals(new Square(6, 1, genericGameBoard).getFile(), 'f');
		assertEquals(new Square(7, 1, genericGameBoard).getFile(), 'g');
		assertEquals(new Square(8, 1, genericGameBoard).getFile(), 'h');
		assertEquals(new Square(8, 1, genericGameBoard).getFile(), 'h');
		assertEquals(rndsq.getFile(), (char) (96 + file));
	}

	@Test(expected = IllegalArgumentException.class)
	public void fileOutOfBounds() {
		new Square(0, 1, genericGameBoard);
		new Square(9, 1, genericGameBoard);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rankOutOfBounds() {
		new Square(8, 9, genericGameBoard);
		new Square(8, 1, genericGameBoard);
	}

	// Tests getPeice, setPeice and removePeice
	@Test
	public void squarePeiceTest() {
		assertNull(sq1.getPiece());

		TestPieceHelper p = new TestPieceHelper(sq1, PieceColor.BLACK);
		assertEquals(p, sq1.getPiece());

		sq1.removePiece();
		assertNull(sq1.getPiece());
	}

	@Test
	public void sharesColumnWithTest() {
		assertTrue(sq1.sharesColumnWith(sq1));
		assertTrue(sq1.sharesColumnWith(sq2));
		assertFalse(sq1.sharesColumnWith(sq3));
		assertFalse(sq1.sharesColumnWith(sq4));
		assertTrue(sq1.sharesColumnWith(sq5));

		if (file == 5)
			assertTrue(sq1.sharesColumnWith(rndsq));
		else
			assertFalse(sq1.sharesColumnWith(rndsq));
	}

	@Test
	public void sharesRowWithTest() {
		assertTrue(sq1.sharesRowWith(sq1));
		assertFalse(sq1.sharesRowWith(sq2));
		assertTrue(sq1.sharesRowWith(sq3));
		assertFalse(sq1.sharesRowWith(sq4));
		assertTrue(sq1.sharesRowWith(sq5));

		if (rank == 5)
			assertTrue(sq1.sharesRowWith(rndsq));
		else
			assertFalse(sq1.sharesRowWith(rndsq));
	}
}
