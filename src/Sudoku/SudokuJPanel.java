package Sudoku;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/////////////////HELP WITH MOUSE LISTENER//////////////*********************
public class SudokuJPanel extends JPanel implements MouseListener{
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			int slotWidth = 100;
			int slotHeight = 100;
			
			int currentlySelectedRow = e.getY() / slotHeight;
			int currentlySelectedCol = e.getX() / slotWidth;
			e.getComponent().repaint();
			}
		}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
