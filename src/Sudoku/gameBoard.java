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
	private File file;
	private String[][]gameStringContents = new String[9][9];
	
	protected GameBoard() {
		file = new File(location);
		//System.out.println("Constructor runs");
		createGameBoard();
	}
	
	public String[][] readContents() {
		String[][]array = new String[9][9];
		//String[][] inArray = new String[9][9];
		final String DELIMITER = ",";
		String[]values=new String[81];
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); //Bufferedreader reads one line.
			String line = "";
			//System.out.println("file read in");
			//while ((line = bufferedReader.readLine()) != null) {
				
				
				

			int i = 0;
			while((line = bufferedReader.readLine()) != null) {
				values = line.split(DELIMITER);
				
	            for (int j = 0; j < values.length; j++) {
	            	array[i][j]= values[j];   
	            }
	            
	            i++;
	            
			}
			System.out.println("while loop exited");
	               

				
				/*
				
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j<9;j++) {
						array[i][j] = Double.parseDouble(sudokuContents[j]);
					}
				}*/
			bufferedReader.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException Occurred");
		} catch (IOException ex) {
			System.out.println ("IOException Occurred");
		}
		return array;
	}
	
	public void createGameBoard() {
		
		//Create new JFrame and JPanels
		JFrame frame = new JFrame("Sudoku");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,9));
		JLabel[][] gameContents= new JLabel[9][9];
		//System.out.println("createGameBoard runs");
		gameStringContents=readContents();
		System.out.println("Return from readContents()");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
					gameContents[i][j]=new JLabel(gameStringContents[i][j]); 
					panel.add(gameContents[i][j]);
			}
		}
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(900,900);
	    frame.setVisible(true);
	}
}
		
		/*
		int[][] contents = 
		JPanel upperLeft = new JPanel();
		JPanel upperCenter = new JPanel();
		JPanel upperRight = new JPanel();
		JPanel middleLeft = new JPanel();
		JPanel middleCenter = new JPanel();
		JPanel middleRight = new JPanel();
		JPanel lowerLeft = new JPanel();
		JPanel lowerCenter = new JPanel();
		JPanel lowerRight = new JPanel();
		
		JPanel upperUpperLeft = new JPanel();
		JPanel upperUpperCenter = new JPanel();
		JPanel upperUpperRight = new JPanel();
		JPanel middleMiddleLeft = new JPanel();
		JPanel middleMiddleCenter = new JPanel();
		JPanel middleMiddleRight = new JPanel();
		JPanel lowerLowerLeft = new JPanel();
		JPanel lowerLowerCenter = new JPanel();
		JPanel lowerLowerRight = new JPanel();
	
		
		//Assign layout to JPanels
		upperLeft.setLayout(new GridLayout(3,3));
		upperCenter.setLayout(new GridLayout(3,3));
		upperRight.setLayout(new GridLayout(3,3));
		middleLeft.setLayout(new GridLayout(3,3));
		middleCenter.setLayout(new GridLayout(3,3));
		middleRight.setLayout(new GridLayout(3,3));
		lowerLeft.setLayout(new GridLayout(3,3));
		lowerCenter.setLayout(new GridLayout(3,3));
		lowerRight.setLayout(new GridLayout(3,3));
		
		upperLeft.add(upperUpperLeft);
		upperLeft.add(upperUpperCenter);
		upperLeft.add(upperUpperRight);
		upperLeft.add(middleMiddleLeft);
		upperLeft.add(middleMiddleCenter);
		upperLeft.add(middleMiddleRight);
		upperLeft.add(lowerLowerLeft);
		upperLeft.add(lowerLowerCenter);
		upperLeft.add(lowerLowerRight);
		
		upperCenter.add(upperUpperLeft);
		upperCenter.add(upperUpperCenter);
		upperCenter.add(upperUpperRight);
		upperCenter.add(middleMiddleLeft);
		upperCenter.add(middleMiddleCenter);
		upperCenter.add(middleMiddleRight);
		upperCenter.add(lowerLowerLeft);
		upperCenter.add(lowerLowerCenter);
		upperCenter.add(lowerLowerRight);
		
		upperRight.add(upperUpperLeft);
		upperRight.add(upperUpperCenter);
		upperRight.add(upperUpperRight);
		upperRight.add(middleMiddleLeft);
		upperRight.add(middleMiddleCenter);
		upperRight.add(middleMiddleRight);
		upperRight.add(lowerLowerLeft);
		upperRight.add(lowerLowerCenter);
		upperRight.add(lowerLowerRight);
		
		middleLeft.add(upperUpperLeft);
		middleLeft.add(upperUpperCenter);
		middleLeft.add(upperUpperRight);
		middleLeft.add(middleMiddleLeft);
		middleLeft.add(middleMiddleCenter);
		middleLeft.add(middleMiddleRight);
		middleLeft.add(lowerLowerLeft);
		middleLeft.add(lowerLowerCenter);
		middleLeft.add(lowerLowerRight);
		
		middleCenter.add(upperUpperLeft);
		middleCenter.add(upperUpperCenter);
		middleCenter.add(upperUpperRight);
		middleCenter.add(middleMiddleLeft);
		middleCenter.add(middleMiddleCenter);
		middleCenter.add(middleMiddleRight);
		middleCenter.add(lowerLowerLeft);
		middleCenter.add(lowerLowerCenter);
		middleCenter.add(lowerLowerRight);
		
		middleRight.add(upperUpperLeft);
		middleRight.add(upperUpperCenter);
		middleRight.add(upperUpperRight);
		middleRight.add(middleMiddleLeft);
		middleRight.add(middleMiddleCenter);
		middleRight.add(middleMiddleRight);
		middleRight.add(lowerLowerLeft);
		middleRight.add(lowerLowerCenter);
		middleRight.add(lowerLowerRight);
		
		lowerLeft.add(upperUpperLeft);
		lowerLeft.add(upperUpperCenter);
		lowerLeft.add(upperUpperRight);
		lowerLeft.add(middleMiddleLeft);
		lowerLeft.add(middleMiddleCenter);
		lowerLeft.add(middleMiddleRight);
		lowerLeft.add(lowerLowerLeft);
		lowerLeft.add(lowerLowerCenter);
		lowerLeft.add(lowerLowerRight);
		
		lowerCenter.add(upperUpperLeft);
		lowerCenter.add(upperUpperCenter);
		lowerCenter.add(upperUpperRight);
		lowerCenter.add(middleMiddleLeft);
		lowerCenter.add(middleMiddleCenter);
		lowerCenter.add(middleMiddleRight);
		lowerCenter.add(lowerLowerLeft);
		lowerCenter.add(lowerLowerCenter);
		lowerCenter.add(lowerLowerRight);
		
		lowerRight.add(upperUpperLeft);
		lowerRight.add(upperUpperCenter);
		lowerRight.add(upperUpperRight);
		lowerRight.add(middleMiddleLeft);
		lowerRight.add(middleMiddleCenter);
		lowerRight.add(middleMiddleRight);
		lowerRight.add(lowerLowerLeft);
		lowerRight.add(lowerLowerCenter);
		lowerRight.add(lowerLowerRight);
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		upperUpperLeft.setBorder(raisedbevel);
		upperUpperCenter.setBorder(raisedbevel);
		upperUpperRight.setBorder(raisedbevel);
		middleMiddleLeft.setBorder(raisedbevel);
		middleMiddleCenter.setBorder(raisedbevel);
		middleMiddleRight.setBorder(raisedbevel);
		lowerLowerLeft.setBorder(raisedbevel);
		lowerLowerCenter.setBorder(raisedbevel);
		lowerLowerRight.setBorder(raisedbevel);
		
		
		
		
		//Assign layout to JFrame
		frame.setLayout(new GridLayout(3,3));
		
		//Add all JPanels to JFrame
		frame.add(upperLeft);
		frame.add(upperCenter);
		frame.add(upperRight);
		frame.add(middleLeft);
		frame.add(middleCenter);
		frame.add(middleRight);
		frame.add(lowerLeft);
		frame.add(lowerCenter);
		frame.add(lowerRight);
		
		
		
		//Provide final details regarding JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600, 600);
	    frame.setVisible(true);
	
	}
}
*/