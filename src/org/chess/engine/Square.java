package org.chess.engine;

public class Square {
	private Piece piece;
	private int[] location;
	private int rank; // rows on the chess board, 1 to 8
	private char file; // columns on the chess board, a to h

	/*
	 * Note that 1a is a black square in lower left corner, with white player on
	 * bottom of board and 8h is a black square in upper right.
	 * 
	 * Let's use the convention that our integer index location is (1,1) to
	 * (8,8) with (1,1) in lower left corner, and (8,8) in upper right corner.
	 * That way we only need to map the file, as rank will already be the same
	 * number. The rank and file will be important if we want the game to output
	 * proper chess game play when the game is recorded.
	 */

	public Square(int x, int y) {
		location = new int[2];
		location[0] = x;
		location[1] = y;

		rank = y;
		switch (x) {
		case 1:
			file = 'a';
			break;
		case 2:
			file = 'b';
			break;
		case 3:
			file = 'c';
			break;
		case 4:
			file = 'd';
			break;
		case 5:
			file = 'e';
			break;
		case 6:
			file = 'f';
			break;
		case 7:
			file = 'g';
			break;
		case 8:
			file = 'h';
			break;
		default:
			file = 'x';
			break;
		}

		piece = null; // piece not instantiated here, added by
						// pointing to a Piece in a method below
	}

	public int[] getLocation() {
		return location;
	}

	public int getRank() {
		return rank;
	}

	public char getFile() {
		return file;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void removePiece() {
		piece = null;
	}

	public boolean equals(Object obj) {
		throw new UnsupportedOperationException();
	}
}
