package org.chess.engine;

import javax.swing.JFrame;

public class Chess {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard board = new GameBoard();
		
		frame.add(board);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}

}
