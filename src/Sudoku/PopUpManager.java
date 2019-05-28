package Sudoku;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.InputMismatchException;

import javax.swing.*;

// This class holds all the pop-ups for the game.
public class PopUpManager {
	GameBoard board = null;
	GameAccount account = new GameAccount();
	GameAccountManager accountManager = new GameAccountManager();
	
	// This is the constructor for the PopUpManager. It calls createPopUpOne().
	protected PopUpManager(SudokuJPanel panel)
	{
		createPopUpOne(panel);
	}
	
	/* This is the constructor for the PopUpManager that takes in a boolean input. It then
	 * calls either createPopUpTwo() or createPopUpThree() depending on the input status.
	 */
	protected PopUpManager(boolean status,GameAccount account, GameBoard board)
	{
		this.board = board;
		this.account = account;
		if(status == true) {
			createPopUpTwo();
		}
		else {
			createPopUpThree(account,board);
		}
	}
	
	protected PopUpManager(String message)
	{
		createPopUpFour(message);
	}
	/* This function handles pop-up one. It allows for the user to input a number into the
	 * Sudoku board.
	 */
	private void createPopUpOne(SudokuJPanel panel){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Input");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Cancel");
		JLabel label1 = new JLabel("Enter a number");
		JTextField textField = new JTextField(20);
				
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		
	    // Add JLabel, JTextField, and JButtons to JPanels.
	    panel2.add(label1);
	    panel3.add(textField);
	    panel4.add(button1);
	    panel4.add(button2);
	    
	    // Add an action listener to button1.
	    button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
	
				try {
					String num = textField.getText();
					if (Integer.parseInt(num) > 0 && Integer.parseInt(num) < 10) {
						frame.dispose();
						panel.updateData(num);
					}
					else {
						System.out.println("Invalid entry");
					}
				} catch(InputMismatchException e) {
					System.out.println("InputMismatchException Occurred");
				} catch(NumberFormatException e) {
					System.out.println("NumberFormatException Occurred");
				}
			}
		});
	    
	    // Add an action listener to button2.
	    button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		});
	    
	    // Add JPanels to JFrame using BorderLayout.
		frame.add(panel1, BorderLayout.EAST);
		frame.add(panel2, BorderLayout.NORTH);
		frame.add(panel3, BorderLayout.CENTER);
		frame.add(panel4, BorderLayout.SOUTH);
		
		// Provide final details regarding JFrame.
		frame.getRootPane().setDefaultButton(button1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 150);
	    frame.setResizable(false);
	    frame.setLocation(450,250);
	    frame.setVisible(true);
	}
	
	// This function handles pop-up two. It displays a message if the Sudoku solution is correct.
	private void createPopUpTwo(){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Message");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Play Again");
		JLabel label1 = new JLabel("You won the Sudoku!");
		JLabel label2 = new JLabel("Your Score: " + account.getTotalScore());
	
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		panel3.setLayout(new FlowLayout());
		
	    // Add JLabel, JTextFie2d, and JButtons to JPanels.
	    panel2.add(label1);
	    panel2.add(label2);
	    panel3.add(button1);
	    panel3.add(button2);
	    
	    // Add an action listener to button1.
	    button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				accountManager.writeDB(account);
				frame.dispose();
			}
		});
	    
	    // Add an action listener to button2.
	    button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				accountManager.writeDB(account);
				frame.dispose();
				board.resetGameBoard();
			}
		});
	    
	    // Add JPanels to JFrame using BorderLayout.
		frame.add(panel1, BorderLayout.EAST);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		
		// Provide final details regarding JFrame.
		frame.getRootPane().setDefaultButton(button1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 100);
	    frame.setResizable(false);
	    frame.setLocation(450,250);
	    frame.setVisible(true);
	}

	// This function handles pop-up three. It displays a message if the Sudoku solution is incorrect.
	private void createPopUpThree(GameAccount account, GameBoard board){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Message");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JButton button1 = new JButton("Go Back to Game Board");
		JButton button2 = new JButton("Start Over");
		JLabel label1 = new JLabel("Incorrect Solution");
		
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
	
	    // Add JLabel, JTextField, and JButtons to JPanels.
	    panel2.add(label1);
	    panel3.add(button1);
	    panel3.add(button2);
	    
	    // Add an action listener to button1.
	    button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();	
			}
		});
	    
	    // Add an action listener to button2.
	    button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				accountManager.writeDB(account);
				frame.dispose();
				board.resetGameBoard();
			}
		});
	    
	    // Add JPanels to JFrame using BorderLayout.
		frame.add(panel1, BorderLayout.EAST);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		
		// Provide final details regarding JFrame.
		frame.getRootPane().setDefaultButton(button1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 100);
	    frame.setResizable(false);
	    frame.setLocation(450,250);
	    frame.setVisible(true);
	}
	
private void createPopUpFour(String message){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Message");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JButton button1 = new JButton("OK");
		JLabel label1 = new JLabel(message);
	
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		
	    // Add JLabel, JTextField, and JButtons to JPanels.
	    panel2.add(label1);
	    panel3.add(button1);
	    
	    // Add an action listener to button1.
	    button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		});
	    
	    // Add JPanels to JFrame using BorderLayout.
		frame.add(panel1, BorderLayout.EAST);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		
		// Provide final details regarding JFrame.
		frame.getRootPane().setDefaultButton(button1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 100);
	    frame.setResizable(false);
	    frame.setLocation(450,250);
	    frame.setVisible(true);
	}
}
