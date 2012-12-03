package org.chess.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener
{
			
	public void actionPerformed(ActionEvent e)
    {
         
		if (e.getSource() == Chess.reset)
		{
			Chess.reset();
		}
		else if (e.getSource() == Chess.exit)
		{
			System.exit(0);
		}
		
	}
}

// Just a comment to remember, for when King is captured we can display.
// Definitely not done here, just saving the code for a dialog box.
//Display a message dialog showing the miles.
//JOptionPane.showMessageDialog(null, str + 
//          " kilometers is " + miles + " miles.");
