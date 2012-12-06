package org.chess.engine;

import javax.swing.ImageIcon;

public abstract class Piece {
	private Square location;
	private String name;
	private PieceColor color;
//seung	
	private ImageIcon image;

	public Piece(Square sq, PieceColor color) {
		this.color = color;
		setCurrentSquare(sq);
	}

	
	public final Square getCurrentSquare() {
		return location;
	}

	public final void setCurrentSquare(Square sq) {
		if (location != null)
			location.removePiece();

		
		location = sq;
		
		sq.setPiece(this);
		//sq.setPieceImage(this.image);
	}
	
	public final PieceColor getPieceColor() {
		return color;
	}

	public abstract boolean isValidMove(Square sq);

	public abstract boolean movePiece(Square sq);

	
	//setter for String name used in the constructor for subclasses of Piece.
	public void setName(String name) {
		this.name = name;
	}

	//getter for String name
	public String getPieceType() {
		return name;
	}
	
	public void setImage(String str){
		this.image = new ImageIcon(""+str+"");
	}
	public ImageIcon getImage(){
		return image;
	}

	
}
