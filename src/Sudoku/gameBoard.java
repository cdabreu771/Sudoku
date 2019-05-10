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
import java.util.Scanner;



public class GameBoard {
	private final String location = "//Users//Camille//Documents//COEN275//Assignment1//src/Sudoku//contents.txt";
	//private Scanner scanner = new Scanner(System.in);
	PopUpManager popUp = new PopUpManager();
	SolutionChecker solve = new SolutionChecker();
	private File file;
	private String[][]gameStringContents = new String[9][9];
	
	protected GameBoard() {
		file = new File(location);
		createGameBoard();
	}
	
	public void readContents() {
		//String[][]array = new String[9][9];
		final String DELIMITER = ",";
		String[]values=new String[81];
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); //Bufferedreader reads one line.
			String line = "";
			int i = 0;
			
			while((line = bufferedReader.readLine()) != null) {
				
				values = line.split(DELIMITER);
				
	            for (int j = 0; j < values.length; j++) {
	            	gameStringContents[i][j]= values[j];   
	            }
	            i++;
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException Occurred");
		} catch (IOException ex) {
			System.out.println ("IOException Occurred");
		}
	}
	
	public void createGameBoard() {
		
		//Create new JFrame and JPanels
		JFrame frame = new JFrame("Sudoku");
		JPanel panel = new JPanel();
		panel.setSize(940,940);
		//panel.setBounds(int x, int y, 100, 100);
		panel.setLayout(new GridLayout(9,9));
		JLabel[][] gameContents= new JLabel[9][9];
		//System.out.println("createGameBoard runs");
		readContents();
		//gameStringContents=readContents();
		System.out.println("Return from readContents()");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				///////// HELP WITH COVER////////////////////******************************************
				if (gameStringContents[i][j] == "0") {
					gameContents[i][j]=new JLabel(" ", SwingConstants.CENTER);
					gameContents[i][j].setVisible(false);
				}
				else {
					
					gameContents[i][j]=new JLabel(gameStringContents[i][j], SwingConstants.CENTER); 
					gameContents[i][j].setVisible(true);
				}
					gameContents[i][j].setSize(100,100);
					panel.add(gameContents[i][j]);
					
			}
		}
		////////HELP WITH PAINT///////////////////////////////////////*************************************
		//Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		//panel.setBorder(raisedbevel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(950,950);
	    frame.setVisible(true);
	}
}
		////////////////////HELP WITH ACTION LISTENER//////////////////////*********************************
		