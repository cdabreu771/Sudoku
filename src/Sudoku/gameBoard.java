package Sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;


// This class creates the UI for the GameBoard
public class GameBoard {

	
	
	/* This is the constructor for the GameBoard. It initializes the input file, and calls
	 * createGameBoard().
	 */
	protected GameBoard() {
		
		createGameBoard();
	}
	
	
	// This function creates the game board.
	public void createGameBoard() {
		
		// Create new JFrame and JPanels.
		JFrame frame = new JFrame("Sudoku");
		SudokuJPanel panel = new SudokuJPanel();
		
		// Set size and layout for SudokuPanel.
		panel.setSize(680,680);
		panel.setLayout(new GridLayout(9,9));
		
		// Add SudokuPanel to Jframe.
		frame.add(panel, BorderLayout.CENTER);
		
		// Provide final details regarding JFrame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(680,680);
	    frame.setVisible(true);
	}
	
	
	}

		