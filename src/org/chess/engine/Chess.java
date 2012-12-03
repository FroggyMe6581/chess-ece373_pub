package org.chess.engine;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Chess extends JFrame {

	public Chess(String app_name) {
		super(app_name);
	}

	private static final long serialVersionUID = 1L;
	static JButton reset;
	static JButton exit;
	static GameBoard board;
	static Chess frame;
	static JPanel buttons;
	static JMenuBar menubar;

	public static void main(String[] args) {
		frame = new Chess("Chess");
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

		setup_menu();

		frame.add(board, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	public static void setup_menu() {
		if (menubar == null && frame != null) {
			menubar = new JMenuBar();
			JMenu file_menu = new JMenu("File");
			JMenuItem new_game = new JMenuItem("New Game");
			JMenuItem quit_app = new JMenuItem("Quit");

			new_game.setMnemonic(KeyEvent.VK_Q);

			new_game.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.reset();
				}
			});

			quit_app.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.close();
				}
			});

			file_menu.add(new_game);
			file_menu.add(quit_app);

			menubar.add(file_menu);
			frame.setJMenuBar(menubar);
		}
	}

	public void reset() {
		board.reset();
	}

	public void close() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
}
