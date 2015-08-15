package org.chess.testsuite;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.chess.engine.GameBoard;
import org.chess.engine.PieceColor;
import org.chess.engine.Rook;
import org.chess.engine.Square;

public class RookTest {
	int file, rank, file2, rank2;
	Square sq1, sq2;
	Rook r;

	GameBoard genericGameBoard = new GameBoard();

	@Before
	public void setUp() {
		Random rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());

		rank = rnd.nextInt(7) + 1;
		file = rnd.nextInt(7) + 1;

		rank2 = rnd.nextInt(7) + 1;
		file2 = rnd.nextInt(7) + 1;

		sq1 = new Square(file, rank, genericGameBoard);
		sq2 = new Square(file2, rank2, genericGameBoard);
		r = new Rook(sq1, PieceColor.BLACK);
	}

	@After
	public void tearDown() {
		r = null;
		sq1 = null;
		sq2 = null;
		file = -1;
		rank = -1;
		file2 = -1;
		rank2 = -1;
	}

	@Test
	public void isValidMoveTest() {
		if (rank == rank2 && file != file2)
			assertTrue(r.isValidMove(sq2));
		else if (file == file2 && rank != rank2)
			assertTrue(r.isValidMove(sq2));
		else
			assertFalse(r.isValidMove(sq2));
	}

	@Test
	public void movePeiceTest() {
		r.movePiece(sq2);

		if (rank == rank2 && file != file2)
			assertEquals(r.getCurrentSquare(), sq2);
		else if (file == file2 && rank != rank2)
			assertEquals(r.getCurrentSquare(), sq2);
		else
			assertNotSame(r.getCurrentSquare(), sq2);
	}
}
