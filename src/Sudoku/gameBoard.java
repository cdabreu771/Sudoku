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


// This class creates the UI for the GameBoard
public class GameBoard {

	// This is the constructor for the GameBoard. It calls createGameBoard().
	protected GameBoard() {
		
		createGameBoard();
	}
	
	// This function creates the game board.
	private void createGameBoard() {
		
		GameAccountManager account = new GameAccountManager();
		
		// Create new JFrame and JPanels.
		JFrame startFrame = new JFrame();
		JPanel startPanel = new JPanel();
		JFrame frame = new JFrame("Sudoku");
		JPanel startPanel1 = new JPanel();
		JPanel startPanel2 = new JPanel();
		JPanel startPanel3 = new JPanel();
		JPanel startPanel4 =new JPanel();
		
		SudokuJPanel panel = new SudokuJPanel();
		
		Font font = new Font("Arial", Font.BOLD,26);
		JLabel label1 = new JLabel("Sign In");
		label1.setFont(font);
	
		Font font1 = new Font("Arial",Font.PLAIN,14);
		JLabel label2 = new JLabel("Username:");
		label2.setFont(font1);
		JLabel label3 = new JLabel("Password:");
		label3.setFont(font1);
		
		final int FINAL_WIDTH = 10;
		JTextField text1 = new JTextField(FINAL_WIDTH);
		text1.setText("");
		JTextField text2 = new JTextField(FINAL_WIDTH);
		text2.setText("");
		
		JButton button1 = new JButton("Login");
		
		
		
		// Set size and layout for SudokuPanel.
		startPanel1.setSize(190, 100);
		startPanel2.setSize(190, 100);
		startPanel3.setSize(190, 100);
		startPanel4.setSize(190, 100);
		
		startPanel1.setLayout(new FlowLayout());
		startPanel2.setLayout(new FlowLayout());
		startPanel3.setLayout(new FlowLayout());
		startPanel4.setLayout(new FlowLayout());
		
		startPanel1.add(label1);
		startPanel2.add(label2);
		startPanel2.add(text1);
		startPanel3.add(label3);
		startPanel3.add(text2);
		startPanel4.add(button1);
		
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
		startPanel1.setLayout(new FlowLayout());
		startPanel2.setLayout(new FlowLayout());
		startPanel3.setLayout(new FlowLayout());
		startPanel4.setLayout(new FlowLayout());
		
		
		startPanel.add(startPanel1);
		startPanel.add(startPanel2);
		startPanel.add(startPanel3);
		startPanel.add(startPanel4);
		
		startFrame.add(startPanel);
		
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    startFrame.setSize(635,660);
	    startFrame.setLocation(325,600);
	    startFrame.setResizable(false);
	    startFrame.setVisible(true);
		
	    final boolean flag = false;
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String userName = text1.getText();
				String password = text2.getText();
				
				boolean flag = account.logIn(userName,password);
				
				if(flag) {
					startFrame.dispose();
					panel.setSize(680,680);
					panel.setLayout(new GridLayout(9,9));
					
					// Add SudokuPanel to Jframe.
					frame.add(panel,BorderLayout.CENTER);
					
					// Provide final details regarding JFrame.
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    frame.setSize(635,660);
				    frame.setLocation(325,600);
				    frame.setResizable(false);
				    frame.setVisible(true);
				}
			}
		});
	}
}

		