package org.chess.engine;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
	private static final long serialVersionUID = 1L;
	private Square[][] squares;
	private Piece currentPiece;
	private boolean firstClick;
	private boolean whiteTurn;

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
				currentSquare = new Square(j, i, this);
				add(currentSquare);
				squares[j-1][i-1] = currentSquare;
			}
		
		squares[8-1][8-1].setPiece(new Rook(squares[8-1][8-1], PieceColor.BLACK));
		squares[1-1][8-1].setPiece(new Rook(squares[1-1][8-1], PieceColor.BLACK));
		squares[8-1][1-1].setPiece(new Rook(squares[8-1][1-1], PieceColor.WHITE));
		squares[1-1][1-1].setPiece(new Rook(squares[1-1][1-1], PieceColor.WHITE));
		
		squares[1-1][7-1].setPiece(new Pawn(squares[1-1][7-1], PieceColor.BLACK));
		squares[2-1][7-1].setPiece(new Pawn(squares[2-1][7-1], PieceColor.BLACK));
		squares[3-1][7-1].setPiece(new Pawn(squares[3-1][7-1], PieceColor.BLACK));
		squares[4-1][7-1].setPiece(new Pawn(squares[4-1][7-1], PieceColor.BLACK));
		squares[5-1][7-1].setPiece(new Pawn(squares[5-1][7-1], PieceColor.BLACK));
		squares[6-1][7-1].setPiece(new Pawn(squares[6-1][7-1], PieceColor.BLACK));
		squares[7-1][7-1].setPiece(new Pawn(squares[7-1][7-1], PieceColor.BLACK));
		squares[8-1][7-1].setPiece(new Pawn(squares[8-1][7-1], PieceColor.BLACK));
		
		squares[1-1][2-1].setPiece(new Pawn(squares[1-1][2-1], PieceColor.WHITE));
		squares[2-1][2-1].setPiece(new Pawn(squares[2-1][2-1], PieceColor.WHITE));
		squares[3-1][2-1].setPiece(new Pawn(squares[3-1][2-1], PieceColor.WHITE));
		squares[4-1][2-1].setPiece(new Pawn(squares[4-1][2-1], PieceColor.WHITE));
		squares[5-1][2-1].setPiece(new Pawn(squares[5-1][2-1], PieceColor.WHITE));
		squares[6-1][2-1].setPiece(new Pawn(squares[6-1][2-1], PieceColor.WHITE));
		squares[7-1][2-1].setPiece(new Pawn(squares[7-1][2-1], PieceColor.WHITE));
		squares[8-1][2-1].setPiece(new Pawn(squares[8-1][2-1], PieceColor.WHITE));
		
		squares[5-1][8-1].setPiece(new King(squares[5-1][8-1], PieceColor.BLACK));
		squares[5-1][1-1].setPiece(new King(squares[5-1][1-1], PieceColor.WHITE));
		
		squares[4-1][8-1].setPiece(new Queen(squares[4-1][8-1], PieceColor.BLACK));
		squares[4-1][1-1].setPiece(new Queen(squares[4-1][1-1], PieceColor.WHITE));
		
		squares[2-1][8-1].setPiece(new Knight(squares[2-1][8-1], PieceColor.BLACK));
		squares[7-1][8-1].setPiece(new Knight(squares[7-1][8-1], PieceColor.BLACK));
		squares[2-1][1-1].setPiece(new Knight(squares[2-1][1-1], PieceColor.WHITE));
		squares[7-1][1-1].setPiece(new Knight(squares[7-1][1-1], PieceColor.WHITE));
		
		squares[3-1][8-1].setPiece(new Bishop(squares[3-1][8-1], PieceColor.BLACK));
		squares[6-1][8-1].setPiece(new Bishop(squares[6-1][8-1], PieceColor.BLACK));
		squares[3-1][1-1].setPiece(new Bishop(squares[3-1][1-1], PieceColor.WHITE));
		squares[6-1][1-1].setPiece(new Bishop(squares[6-1][1-1], PieceColor.WHITE));
		
		
		currentPiece = null;
		
		whiteTurn = true;
		firstClick = true;
	}
	
	public void reset()
	{
		// clear all pieces
		for(int i = 8; i > 0; i--)			//i is y value
			for(int j = 8; j > 0; j--)		//j is x value
				squares[j-1][i-1].removePiece();
		
		System.gc();
		
		squares[8-1][8-1].setPiece(new Rook(squares[8-1][8-1], PieceColor.BLACK));
		squares[1-1][8-1].setPiece(new Rook(squares[1-1][8-1], PieceColor.BLACK));
		squares[8-1][1-1].setPiece(new Rook(squares[8-1][1-1], PieceColor.WHITE));
		squares[1-1][1-1].setPiece(new Rook(squares[1-1][1-1], PieceColor.WHITE));
		
		squares[1-1][7-1].setPiece(new Pawn(squares[1-1][7-1], PieceColor.BLACK));
		squares[2-1][7-1].setPiece(new Pawn(squares[2-1][7-1], PieceColor.BLACK));
		squares[3-1][7-1].setPiece(new Pawn(squares[3-1][7-1], PieceColor.BLACK));
		squares[4-1][7-1].setPiece(new Pawn(squares[4-1][7-1], PieceColor.BLACK));
		squares[5-1][7-1].setPiece(new Pawn(squares[5-1][7-1], PieceColor.BLACK));
		squares[6-1][7-1].setPiece(new Pawn(squares[6-1][7-1], PieceColor.BLACK));
		squares[7-1][7-1].setPiece(new Pawn(squares[7-1][7-1], PieceColor.BLACK));
		squares[8-1][7-1].setPiece(new Pawn(squares[8-1][7-1], PieceColor.BLACK));
		
		squares[1-1][2-1].setPiece(new Pawn(squares[1-1][2-1], PieceColor.WHITE));
		squares[2-1][2-1].setPiece(new Pawn(squares[2-1][2-1], PieceColor.WHITE));
		squares[3-1][2-1].setPiece(new Pawn(squares[3-1][2-1], PieceColor.WHITE));
		squares[4-1][2-1].setPiece(new Pawn(squares[4-1][2-1], PieceColor.WHITE));
		squares[5-1][2-1].setPiece(new Pawn(squares[5-1][2-1], PieceColor.WHITE));
		squares[6-1][2-1].setPiece(new Pawn(squares[6-1][2-1], PieceColor.WHITE));
		squares[7-1][2-1].setPiece(new Pawn(squares[7-1][2-1], PieceColor.WHITE));
		squares[8-1][2-1].setPiece(new Pawn(squares[8-1][2-1], PieceColor.WHITE));
		
		squares[5-1][8-1].setPiece(new King(squares[5-1][8-1], PieceColor.BLACK));
		squares[5-1][1-1].setPiece(new King(squares[5-1][1-1], PieceColor.WHITE));
		
		squares[4-1][8-1].setPiece(new Queen(squares[4-1][8-1], PieceColor.BLACK));
		squares[4-1][1-1].setPiece(new Queen(squares[4-1][1-1], PieceColor.WHITE));
		
		squares[2-1][8-1].setPiece(new Knight(squares[2-1][8-1], PieceColor.BLACK));
		squares[7-1][8-1].setPiece(new Knight(squares[7-1][8-1], PieceColor.BLACK));
		squares[2-1][1-1].setPiece(new Knight(squares[2-1][1-1], PieceColor.WHITE));
		squares[7-1][1-1].setPiece(new Knight(squares[7-1][1-1], PieceColor.WHITE));
		
		squares[3-1][8-1].setPiece(new Bishop(squares[3-1][8-1], PieceColor.BLACK));
		squares[6-1][8-1].setPiece(new Bishop(squares[6-1][8-1], PieceColor.BLACK));
		squares[3-1][1-1].setPiece(new Bishop(squares[3-1][1-1], PieceColor.WHITE));
		squares[6-1][1-1].setPiece(new Bishop(squares[6-1][1-1], PieceColor.WHITE));
		
		
		currentPiece = null;
		
		whiteTurn = true;
		firstClick = true;
	}
	
	//seung
	//to check whether piece is on square or not
	public boolean isPieceOnSquare(int x, int y){
		if(squares[x][y].getPiece()!=null){
			return true;
		}
		else
			return false;
	}
	
	public void squareSelected(Square sq)
	{
		Piece piece;
		PieceColor color;
		if (firstClick)
		{
			piece = sq.getPiece();
			if (piece != null)
			{
				color = piece.getPieceColor();
				if ( (whiteTurn && color.equals(PieceColor.WHITE)) ||
					 (!whiteTurn && color.equals(PieceColor.BLACK)) )
				{
					currentPiece = piece;
					firstClick = false;		//got a piece (not null) and it's the player's color
				}
				
			}
		}
		else	//second click with valid currentPiece, sq is destination
		{
			if(sq.getPiece() == null)		//no piece in destination square
			{
				if( currentPiece.movePiece(sq) )	//true if piece moved
				{
					whiteTurn = !whiteTurn;
					firstClick = true;
					currentPiece = null;
				}
				else
				{
					firstClick = true;				//reset turn but keep current player for turn
					currentPiece = null;
				}
			}
			else	//piece in destination square, see if opponent
			{
				Piece destPiece = sq.getPiece();
				PieceColor destPieceColor = destPiece.getPieceColor();
				if ( (whiteTurn && destPieceColor.equals(PieceColor.BLACK)) ||
					 (!whiteTurn && destPieceColor.equals(PieceColor.WHITE)) )
				{
					if( currentPiece.movePiece(sq) )
					{
						if(destPiece.getPieceType().equals("King")){
							JOptionPane.showMessageDialog(null, ""+currentPiece.getPieceColor()+" Wins!!!!");	
							this.reset();
						}
						whiteTurn = !whiteTurn;
						firstClick = true;
						currentPiece = null;
						
					}
					else //tried to attack, but couldn't validly move there
					{
						firstClick = true;
						currentPiece = null;
					}
				}
				else // is same color, oops, that's our piece, not the opponents
				{
					firstClick = true;
					currentPiece = null;
				}
			}
		}
	}
	
	public void resetSquareColors(Square sq)
	{
		for (Square[] sa : squares)
			for (Square s : sa)
				if (s != sq)
					s.resetBackground();
	}
}
