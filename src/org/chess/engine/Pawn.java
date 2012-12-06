package org.chess.engine;

public class Pawn extends Piece{

	private int firstmove_white = 0;
	private int firstmove_black = 0;
	
	public Pawn(Square sq, PieceColor color) {
		super(sq, color);
		setName("Pawn");
	
		if(color == PieceColor.WHITE)
			setImage("white_pawn.png");
		else
			setImage("black_pawn.png");
	}

	// Square sq is potential destination square for piece
	public boolean isValidMove(Square sq) {
		
		
	int col_diff = sq.getSquareLocation()[0] - this.getCurrentSquare().getSquareLocation()[0];
	int row_diff = sq.getSquareLocation()[1] - this.getCurrentSquare().getSquareLocation()[1];
	
	
		if(this.getCurrentSquare().getPiece().getPieceColor() == PieceColor.WHITE){
			
			if(firstmove_white == 0 && sq.getPiece()==null){
				if(col_diff == 0 && row_diff > 0 && row_diff < 3 && sq.pieceIsBetweenRow(this.getCurrentSquare()) == false){
					firstmove_white = 1;
					return true;
				}
			}

			if(col_diff == 0 && row_diff == 1){
				if(sq.getPiece()!=null)
					return false;
				else
					return true;
			}
			else if(Math.abs(col_diff)==1 && row_diff == 1){
				if(this.getCurrentSquare().getPiece()!=null
						&&sq.getPiece()!=null){
					if(this.getCurrentSquare().getPiece().getPieceColor()==(sq.getPiece().getPieceColor())){
						return false;
					}
					else{
						return true;
					}	
				}
				else return false;
			}
			else return false;
		}
		
		else{
			if(firstmove_black == 0 && sq.getPiece()==null){
				if(col_diff == 0 && row_diff < 0 && row_diff > -3 && sq.pieceIsBetweenRow(this.getCurrentSquare()) == false){
					firstmove_black = 1;
					return true;
				}
			}
			if(col_diff == 0 && row_diff == -1){
				if(sq.getPiece()!=null)
					return false;
				else 
					return true;
			}
			else if(Math.abs(col_diff)==1 && row_diff == -1){
				if(this.getCurrentSquare().getPiece()!=null
						&&sq.getPiece()!=null){
					if(this.getCurrentSquare().getPiece().getPieceColor()==(sq.getPiece().getPieceColor())){
						return false;
					}
					else{
						return true;
					}
				}
				else return false;
			}
			else return false;
		}
	}

	// Square sq is destination square; move there if legal
	public boolean movePiece(Square sq) {
		if (isValidMove(sq)) {
			super.setCurrentSquare(sq);
			return true;
		}
		return false;
	}
	
}
