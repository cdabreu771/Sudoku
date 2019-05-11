package Sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// This class extends the JPanel and creates a mouse listener.
public class SudokuJPanel extends JPanel {
	
	private String[][]gameStringContents = new String[9][9];
	private final String location = "//Users//Camille//Documents//COEN275//Assignment1//src/Sudoku//contents.txt";
	private File file;
	int currentlySelectedRow;
	int currentlySelectedCol;
	SudokuJPanel object = this;
	int mustFill = 0;
	
	//int[] nonEditableXArray = new int[81];
	//int[] nonEditableYArray = new int[81];
	
	public SudokuJPanel(){
		file = new File(location);
		createLabels();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			int slotWidth = 70;
			int slotHeight = 70;
			
			currentlySelectedRow = e.getX() / slotHeight;
			currentlySelectedCol = e.getY() / slotWidth;
			
			//if(nonEditable)
			/// CHeck if x,y editable
			
			PopUpManager popUp = new PopUpManager(currentlySelectedRow,currentlySelectedCol,object);
			
			}
		});
	}
	public void createLabels() {
	readContents();
	}
	
	public void updateData(String num) {
		gameStringContents[currentlySelectedRow][currentlySelectedCol] = num;
		this.revalidate();
		this.repaint();
		mustFill--;
		
		if(mustFill == 0) {
			SolutionChecker solution = new SolutionChecker(gameStringContents);
		}
	}
			
	
	
	/* This function reads the input in from the file and separates each value into the 
	 * gameStringContents array.
	 */
	public void readContents() {
		final String DELIMITER = ",";
		String[]values=new String[81];
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); //Bufferedreader reads one line.
			String line = "";
			int j = 0;
			
			while((line = bufferedReader.readLine()) != null) {
				
				values = line.split(DELIMITER);
				
	            for (int i = 0; i < values.length; i++) {
	            	if (values[i].equals("0")) {
	            		mustFill ++;
	            	}
	            	gameStringContents[i][j]= values[i];
	            	
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
	
	//@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(1.0f,1.0f,1.0f));
			
			g2d.setColor(new Color(255,255,255));
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
			//// diff colored numbers for edited
			
			
			int k = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(Integer.parseInt(gameStringContents[i][j]) > 0 && Integer.parseInt(gameStringContents[i][j]) < 10) {
						g2d.setColor(new Color(0,0,255));
						g2d.drawString(gameStringContents[i][j],((i*70)+25),((j*70)+40));
						//nonEditableXArray[k] =  ((i*70)+25);
						//nonEditableYArray[k] = ((j*70)+40);
					}
					
				}
			}
		
		}
		}}
