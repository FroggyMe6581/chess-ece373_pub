package org.chess.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
    {
         
		if (e.getSource() == Chess.reset)
		{
			
		}
		else if (e.getSource() == Chess.exit)
		{
			
		}
		
		
         
         // Display a message dialog showing the miles.
         //JOptionPane.showMessageDialog(null, str + 
         //          " kilometers is " + miles + " miles.");
    }
}