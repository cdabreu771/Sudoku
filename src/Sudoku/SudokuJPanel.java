package Sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// This class extends the JPanel. It facilitates in all actions that occur within the SudokuJPanels.
public class SudokuJPanel extends JPanel {
	private String[][]originalStringContents = new String[9][9];
	private String[][]gameStringContents = new String[9][9];
	private final String location = "//Users//Camille//Documents//COEN275//Assignment1//src/Sudoku//contents.txt";
	private File file;
	private int currentlySelectedRow;
	private int currentlySelectedCol;
	private SudokuJPanel object = this;
	
	/* This is the constructor for the SudokuJPanel class. It initializes the input file, and initiates ReadContents.
	 * It also holds the mouse listener.
	 */
	protected SudokuJPanel(){
		file = new File(location);
		readContents();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int slotWidth = 70;
				int slotHeight = 70;
			
				currentlySelectedRow = e.getX() / slotHeight;
				currentlySelectedCol = e.getY() / slotWidth;
			
				if(originalStringContents[currentlySelectedRow][currentlySelectedCol].equals("0")) {
					PopUpManager popUp = new PopUpManager(object);
				}
			}
		});
	}
	
	/* This function reads the input in from the file and separates each value into the 
	 * gameStringContents array.
	 */
	private void readContents() {
		final String DELIMITER = ",";
		String[]values=new String[81];
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); //Bufferedreader reads one line.
			String line = "";
			int j = 0;
			
			while((line = bufferedReader.readLine()) != null) {
				
				values = line.split(DELIMITER);
				
	            for (int i = 0; i < values.length; i++) {
	            	gameStringContents[i][j]= values[i];
	            	originalStringContents[i][j]=values[i];
	            }  
	            j++;
			}
			bufferedReader.close();	
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException Occurred");
		} catch (IOException ex) {
			System.out.println ("IOException Occurred");
		}
	}
	
	// This function updates the data within the SudokoPanel and the gameStringContents array.
	protected void updateData(String num) {
		boolean boardStatus = false;
		
		gameStringContents[currentlySelectedRow][currentlySelectedCol] = num;
		
		this.revalidate();
		this.repaint();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++){
				if(Integer.parseInt(gameStringContents[i][j]) > 0 && Integer.parseInt(gameStringContents[i][j]) < 10) {
					continue; 
				}
				else {
					boardStatus = false;
					return;
				}
			}
		}
		boardStatus = true;
		
		if (boardStatus) {
			SolutionChecker solution = new SolutionChecker(gameStringContents);
		}
	}
	
	// This function handles the graphics within the SudokuJPanels, including the borders and painting of values.
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Set the color of the SudokoJPanel and grid.
		g2d.setColor(new Color(224,224,224));
		g2d.setColor(new Color(255,255,255));
		
		// Set the stroke width for the vertical grid.
		for(int x = 0;x <= 630;x+=70) {
			if((x % 210) == 0) {
				g2d.setColor(new Color(255,255,255));
				g2d.setStroke(new BasicStroke(10));
				g2d.drawLine(x, 0, x, 630);
			}
			else {
				g2d.setColor(new Color(255,255,255));
				g2d.setStroke(new BasicStroke(2));
				g2d.drawLine(x, 0, x, 630);
			}
		}
			
		// Set the stroke width for the horizontal grid.
		for(int y = 0;y <= 630;y+=70) {
			if((y % 210) == 0) {
				g2d.setColor(new Color(255,255,255));
				g2d.setStroke(new BasicStroke(10));
				g2d.drawLine(0, y, 630, y);
				}
			else {
				g2d.setColor(new Color(255,255,255));
				g2d.setStroke(new BasicStroke(2));
				g2d.drawLine(0, y, 630, y);
			}
		}
		
		// Paint the values into the SudokoJPanel from originalStringContents.
		Font f = new Font("Arial", Font.PLAIN, 24);
		g2d.setFont(f);
		FontRenderContext fContext = g2d.getFontRenderContext();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(Integer.parseInt(originalStringContents[i][j]) > 0 && Integer.parseInt(originalStringContents[i][j]) < 10) {
						g2d.setColor(new Color(96,96,96));
						g2d.drawString(originalStringContents[i][j],((i*70)+25),((j*70)+40));
			
				}	
			}
		}
		
		// Paint the values into the SudokoJPanel from gameStringContents.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(Integer.parseInt(gameStringContents[i][j]) != Integer.parseInt(originalStringContents[i][j])){
					if(Integer.parseInt(gameStringContents[i][j]) > 0 && Integer.parseInt(gameStringContents[i][j]) < 10) {
							g2d.setColor(new Color(255,0,127));
							g2d.drawString(gameStringContents[i][j],((i*70)+25),((j*70)+40));
					}
				}	
			}
		}
	}
}
