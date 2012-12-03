package org.chess.engine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chess {

	private static final long serialVersionUID = 1L;
	static JButton reset;
	static JButton exit;
	static GameBoard board;
	static JFrame frame;
	static JPanel buttons;

	public static void main(String[] args) {
		frame = new JFrame("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		ButtonListener bl = new ButtonListener();
		reset.addActionListener(bl);
		exit.addActionListener(bl);
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(reset);
		buttons.add(exit);
		
		board = new GameBoard();
		
		frame.add(board, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	public static void reset()
	{
		board.reset();
	}
	
	

}
