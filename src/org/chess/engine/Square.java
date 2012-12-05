package org.chess.engine;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Square extends JTextField {
	private static final long serialVersionUID = 1L;
	private Piece piece;
	private int[] location;
	private int rank; // rows on the chess board, 1 to 8
	private char file; // columns on the chess board, a to h
	private Color sqColor;
	
	private static GameBoard board;

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

	public Square(int x, int y, GameBoard gb) {
		if ((x > 8 || x < 1) || (y > 8 || y < 1))
			throw new IllegalArgumentException();

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
			throw new IllegalArgumentException();
		}
		
		// set color of square based on its location in the grid
		if( y % 2 == 0 ) //if even row
		{
			if ( x % 2 == 0 )
			{
				this.setBackground(Color.GRAY);
				sqColor = Color.GRAY;
			}
			else
			{
				this.setBackground(Color.LIGHT_GRAY);
				sqColor = Color.LIGHT_GRAY;
			}
		}
		else //if odd row
		{
			if ( x % 2 == 0 )
			{
				this.setBackground(Color.LIGHT_GRAY);
				sqColor = Color.LIGHT_GRAY;
			}
			else
			{
				this.setBackground(Color.GRAY);
				sqColor = Color.GRAY;
			}
		}

		this.setEditable(false);
		
		piece = null; 	// piece not instantiated here, added by
						// pointing to a Piece in a method below
		
		board = gb;
		
		addMouseListener(new MouseHandler());
		setBorder(BorderFactory.createEmptyBorder());
		setHorizontalAlignment(JTextField.CENTER);
	}

	public void resetBackground()
	{
		this.setBackground(sqColor);
	}
	
	public int[] getSquareLocation() {
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
		PieceColor color = piece.getPieceColor();
		switch (color) {
		case BLACK: this.setForeground(Color.BLACK);
					break;
					
		case WHITE: this.setForeground(Color.YELLOW);
					break;
		}
		this.piece = piece;
		this.setText(piece.getPieceType());
	}

	public void removePiece() {
		piece = null;
		this.setText("");
	}

	public boolean equals(Object obj) {
		if (obj == null)
			throw new IllegalArgumentException();

		if (obj.getClass() != this.getClass())
			return false;

		Square s = (Square) obj;
		return (s.getSquareLocation()[0] == this.getSquareLocation()[0])
				&& (s.getSquareLocation()[1] == this.getSquareLocation()[1]);
	}

	public boolean sharesRowWith(Square sq) {
		if (sq == null)
			throw new IllegalArgumentException();

		return sq.getSquareLocation()[1] == this.getSquareLocation()[1];
	}

	public boolean sharesColumnWith(Square sq) {
		if (sq == null)
			throw new IllegalArgumentException();

		return sq.getSquareLocation()[0] == this.getSquareLocation()[0];
	}
	
	//seung
	public boolean isOnDiagonal(Square sq){
		if(sq == null)
			throw new IllegalArgumentException();
		
		int col = this.getSquareLocation()[0] - sq.getSquareLocation()[0];
		int row = this.getSquareLocation()[1] - sq.getSquareLocation()[1];
		
		if(Math.abs(col)==Math.abs(row))
			return true;
		else
			return false;
	}
	
	//seung 
	public boolean pieceIsBetweenRow(Square sq){
		if(sq == null)
			throw new IllegalArgumentException();
		
		int col = this.getSquareLocation()[0]-1;
		
		for(int i = 0; i< 8; i++){
			if(board.isPieceOnSquare(col, i)){
				if(i<this.getSquareLocation()[1]-1 && i>sq.getSquareLocation()[1]-1)
						return true;
				
				else if(i>this.getSquareLocation()[1]-1 && i<sq.getSquareLocation()[1]-1)
						return true;
			}
		}
		return false;
	}
	
	//seung 
	public boolean pieceIsBetweenCol(Square sq){
		if(sq == null)
			throw new IllegalArgumentException();
		
		int row = this.getSquareLocation()[1]-1;
		
		for(int i = 0; i< 8; i++){
			if(board.isPieceOnSquare(i, row)){
				if(i<this.getSquareLocation()[0]-1 && i>sq.getSquareLocation()[0]-1)
						return true;
				
				else if(i>this.getSquareLocation()[0]-1 && i<sq.getSquareLocation()[0]-1)
						return true;
			}
		}
		return false;
		
	}
	//seung 
	public boolean pieceIsBetweenDiag(Square sq){
		if(sq == null)
			throw new IllegalArgumentException();
		
		int col[] = new int[2];
		int row[] = new int[2];
		
		col[0] = this.getSquareLocation()[0]-1;
		row[0] = this.getSquareLocation()[1]-1;
		col[1] = sq.getSquareLocation()[0]-1;
		row[1] = sq.getSquareLocation()[1]-1;
		
		if(col[1]>col[0]){
			if(row[1]>row[0]){
				for(int i = 1; i<col[1]-col[0]; i++){
					if(board.isPieceOnSquare(col[0]+i, row[0]+i))
						return true;
				}
			}
			else if(row[1]<row[0]){
				for(int i = 1; i<col[1]-col[0]; i++){
					if(board.isPieceOnSquare(col[0]+i, row[0]-i))
						return true;
				}
			}
			else return false;
		}
		else{
			if(row[1]>row[0]){
				for(int i = 1; i<col[0]-col[1]; i++){
					if(board.isPieceOnSquare(col[0]-i, row[0]+i))
						return true;
				}
			}
			else if(row[1]<row[0]){
				for(int i = 1; i<col[0]-col[1]; i++){
					if(board.isPieceOnSquare(col[0]-i, row[0]-i))
						return true;
				}
			}
			else return false;
		}
		return false;
	}
	
	
	/*
	public void functionForTestingJComponentMethods()
	{
		board.squareSelected(new Square(1,1,board));
	}
	*/
	
	private class MouseHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if (Square.this.contains(e.getPoint()))
			{
				Square.this.setBackground(Color.RED);
				Square.board.resetSquareColors(Square.this);
				Square.board.squareSelected(Square.this);
			}
		}
	}
}
