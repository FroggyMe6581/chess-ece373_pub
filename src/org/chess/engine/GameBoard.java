package org.chess.engine;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	private static final long serialVersionUID = 1L;
	private Square[][] squares;

	public GameBoard() {
		squares = new Square[8][8];
		
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setLayout(new GridLayout(8,8));
		
		// filling up grid from right to left, top to bottom, so must index in reverse
		// per the way the chessboard is marked
		Square currentSquare;
		for(int i = 8; i > 0; i--)			//i is y value
			for(int j = 8; j > 0; j--)		//j is x value
			{
				currentSquare = new Square(j,i);
				add(currentSquare);
				squares[j-1][i-1] = currentSquare;
			}
		
		squares[8-1][8-1].setPiece(new Rook(squares[8-1][8-1]));
		squares[1-1][8-1].setPiece(new Rook(squares[1-1][8-1]));
	}
}
