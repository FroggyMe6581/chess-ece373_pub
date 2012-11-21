package org.chess.engine;

public abstract class Piece
{
	private Square location;
	
	public Piece(Square sq)
	{
		location = sq;
	}
	
	public Square getLocation()
	{
		return location;
	}
	
	public void setLocation(Square sq)
	{
		location = sq;
	}
	
	public abstract boolean isValidMove(Square sq);
	
	public abstract void movePiece(Square sq);
}
