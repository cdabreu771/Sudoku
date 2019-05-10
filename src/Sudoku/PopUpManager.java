package Sudoku;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PopUpManager {
	public PopUpManager()
	{
		
	}
	public PopUpManager(boolean status)
	{
		if(status == true) {
			createPopUpTwo();
		}
		else {
			createPopUpThree();
		}
	}

	public void createPopUpOne(){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Input");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Cancel");
		JLabel label1 = new JLabel("");
		JLabel label2 = new JLabel("Enter a number");
		JTextField textField = new JTextField(20);
		
		// URL of question mark image.
				
		
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		
		// Assign image to JLabel and add to JPanel.
	    //label1.setIcon(new ImageIcon(getClass().getResource(url)));
		//////// HELP WITH IMAGE//////////////////////////*************************
		//Picture pic = new Picture("question.png");
		//label1.
	    panel1.add(label1);
		
	    // Add JLabel, JTextField, and JButtons to JPanels.
	    panel2.add(label2);
	    panel3.add(textField);
	    panel4.add(button1);
	    panel4.add(button2);
	    
	    ////////////HELP WITH ACTION LISTENER BUTTON1////////////////***************
	    button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
	    
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
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 150);
	    frame.setVisible(true);
		
	}
	
	public void createPopUpTwo(){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Message");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JButton button1 = new JButton("OK");
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel("You won the Sudoku!");
	
		
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		
		// Assign image to JLabel and add to JPanel.
	    //label1.setIcon(new ImageIcon(getClass().getResource(url)));
		//////// HELP WITH IMAGE//////////////////**************************
		//Picture pic = new Picture("question.png");
		//label1.
	    panel1.add(label1);
		
	    // Add JLabel, JTextField, and JButtons to JPanels.
	    panel2.add(label2);
	    panel3.add(button1);
	    
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
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 100);
	    frame.setVisible(true);
		
	}

	public void createPopUpThree(){
		
		// Create JFrame, JPanels, JButtons, JLabels, and JTextField.
		JFrame frame = new JFrame("Message");
		JPanel panel1 = new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3 = new JPanel();
		JButton button1 = new JButton("Start Over");
		JButton button2 = new JButton("Exit");
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel("Incorrect Solution");
	
		
		// Set layout for the panels as FlowLayout.
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		
		// Assign image to JLabel and add to JPanel.
	    //label1.setIcon(new ImageIcon(getClass().getResource(url)));
		//////// HELP WITH IMAGE//////////////////////////////////*********************
		//Picture pic = new Picture("question.png");
		//label1.
	    panel1.add(label1);
		
	    // Add JLabel, JTextField, and JButtons to JPanels.
	    panel2.add(label2);
	    panel3.add(button1);
	    panel3.add(button2);
	    
	    //////// HELP WITH ACTION LISTENER FOR BUTTON1/////////////********************
	    button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
				GameBoard newGame = new GameBoard();
			}
		});
	    button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
			}
		});
	    
	    
	    // Add JPanels to JFrame using BorderLayout.
		frame.add(panel1, BorderLayout.EAST);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		
		// Provide final details regarding JFrame.
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 100);
	    frame.setVisible(true);
		
	}
}
