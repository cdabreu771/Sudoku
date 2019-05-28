package Sudoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;


// This class creates the UI for the GameBoard
public class GameBoard {
	private static final Color WHITE = Color.WHITE;
	private static final Color GREEN = Color.GREEN;
	private static final Color ORANGE = Color.ORANGE;
	GameAccount account = new GameAccount();
	Timer timer;
	int mseconds = 0;
	int seconds = 0;
	int minutes = 0;
	int score = 0;
	String mSecondsString = "00";
    String secondsString = "00";
    String minutesString = "00";
	JLabel label2a = null;
	JLabel label2b = null;
	JLabel label3a = null;
	JLabel label3b = null;
	JLabel label4a = null;
	JLabel label4b = null;
	JLabel label5a = null;
	JLabel label5b = null;
	JLabel label6a = null;
	JLabel label6b = null;
	JLabel label9 = null;
	JPanel RPanel = null;
	SudokuJPanel sudokuPanel = null;
	SolutionChecker check = null;
	Thread thread;
	
	// This is the constructor for the GameBoard. It calls createGameBoard().
	//protected GameBoard(GameAccount account) {
	//	this.account = account;
	//	createGameBoard();
	//}
	// This is the constructor for the GameBoard. It calls createGameBoard().
	protected GameBoard(GameAccount account, boolean status) {
		this.account = account;
		check = new SolutionChecker(account);
		resetGameBoard();
}
	protected GameBoard(GameAccount account) {
		check = new SolutionChecker(account);
		createGameBoard();
	}
	
	// This function creates the game board.
	private void createGameBoard() {
		
		// Sudoku Game Screen
		JFrame frame = new JFrame("Sudoku");
		JPanel LPanel = new JPanel();
		LPanel.setBounds(0,0,300,800);
		RPanel = new JPanel();
		RPanel.setBounds(300,0,690,800);
		JPanel LPanelTop = new JPanel();
		LPanelTop.setBounds(0,0,300,300);
		JPanel LPanelCenter = new JPanel();
		LPanelCenter.setBounds(0,300,300,200);
		JPanel LPanelBottom = new JPanel();
		LPanelBottom.setBounds(0,500,300,300);
		sudokuPanel = new SudokuJPanel(account, this);
		
		frame.setLayout(null);
		LPanel.setLayout(null);
		LPanelTop.setLayout(null);
	
		LPanelCenter.setLayout(new BoxLayout(LPanelCenter,BoxLayout.Y_AXIS));
		LPanelBottom.setLayout(new BoxLayout(LPanelBottom,BoxLayout.Y_AXIS));
		//LPanelBottom.setLayout(null);
		RPanel.setLayout(null);
		
		// Left Top Panel: Scoreboard
		Font font1 = new Font("Arial", Font.BOLD,26);
		JLabel label1 = new JLabel("Scoreboard");
		label1.setBounds(0,0,300,50);
		label1.setFont(font1);
		label1.setHorizontalAlignment(JLabel.CENTER);
	    label1.setVerticalAlignment(JLabel.CENTER);

		label2a = new JLabel("Player Name:");
		label2a.setBounds(5,50,200,50);
		label2b = new JLabel(account.getPlayerName());
		label2b.setBounds(200,50,50,50);
		label3a = new JLabel("Number of Games Played:");
		label3a.setBounds(5,100,200,50);
		label3b = new JLabel(Integer.toString(account.getGamesPlayed()));
		label3b.setBounds(200,100,50,50);
		label4a = new JLabel("Number of Games Won:");
		label4a.setBounds(5,150,200,50);
		label4b = new JLabel(Integer.toString(account.getGamesWon()));
		label4b.setBounds(200,150,50,50);
		label5a = new JLabel("Number of Games Lost:");
		label5a.setBounds(5,200,200,50);
		label5b = new JLabel(Integer.toString(account.getGamesLost()));
		label5b.setBounds(200,200,50,50);
		label6a = new JLabel("Total Score:");
		label6a.setBounds(5,250,200,50);
		label6b = new JLabel(Integer.toString(account.getTotalScore()));
		label6b.setBounds(200,250,50,50);
		
		LPanelTop.add(label1);
		LPanelTop.add(label2a);
		LPanelTop.add(label2b);
		LPanelTop.add(label3a);
		LPanelTop.add(label3b);
		LPanelTop.add(label4a);
		LPanelTop.add(label4b);
		LPanelTop.add(label5a);
		LPanelTop.add(label5b);
		LPanelTop.add(label6a);
		LPanelTop.add(label6b);
		
		// Left Center Panel: Board Color
		JLabel label7 = new JLabel("Board Color");
		label7.setBounds(0,300,300,50);
		label7.setHorizontalAlignment(JLabel.CENTER);
	    label7.setVerticalAlignment(JLabel.CENTER);
		label7.setFont(font1);
		
		String[] options = {"White","Green","Orange"};
		JComboBox<String> colorSelection = new JComboBox<String>(options);
		colorSelection.setMaximumSize( colorSelection.getPreferredSize() );
		((JLabel) colorSelection.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		colorSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = (String) colorSelection.getSelectedItem();
			if(color.equals("White")) {
				sudokuPanel.changeColor(WHITE);
			}
			else if(color.equals("Green")) {
				sudokuPanel.changeColor(GREEN);
			}
			else if(color.equals("Orange")) {
				sudokuPanel.changeColor(ORANGE);
			}
			}
		});
			
		LPanelCenter.add(label7);
		LPanelCenter.add(colorSelection);
		
		// Left Panel Bottom: Timer
		JLabel label8 = new JLabel("Timer");
		label8.setBounds(0,600,300,50);
		label8.setHorizontalAlignment(JLabel.CENTER);
	    label8.setVerticalAlignment(JLabel.CENTER);
		label8.setFont(font1);
		label8.setAlignmentX(Component.CENTER_ALIGNMENT);
		label9 = new JLabel("00:" + "00:" + "00:" + "00");
		Font font2 = new Font("Arial", Font.PLAIN, 20);
		label9.setBounds(0,650,300,50);
		label9.setHorizontalAlignment(JLabel.CENTER);
	    label9.setVerticalAlignment(JLabel.CENTER);
	    label9.setFont(font2);
	    label9.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    JButton button1 = new JButton("Play Now");
		button1.setBounds(0,700,300,50);
		button1.setHorizontalAlignment(JButton.CENTER);
		button1.setVerticalAlignment(JButton.CENTER);
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                 thread = new Thread() {
                    public void run() {
                        try {
                            long elapsedTime = 0;
                            long startTime = System.currentTimeMillis();
                     

                            while (elapsedTime < 1800001) {

                                elapsedTime = System.currentTimeMillis() - startTime;
                                try {
                                	sleep(1);
                                } catch(InterruptedException exception) {
                                	System.out.println("Interrupted");
                                }
                                mseconds = (int) (elapsedTime % 1000);

                                if (mseconds + 1 == 1000) {
                                    mseconds = 0;
                                    seconds++;
                                }

                                if (seconds == 60) {
                                    mseconds = 0;
                                    seconds = 0;
                                    minutes++;
                                }

                                if (mseconds < 10) {
                                    mSecondsString = "0" + mseconds;
                                } else {
                                    mSecondsString = String.valueOf(mseconds);
                                }

                                if (seconds < 10) {
                                    secondsString = "0" + seconds;
                                } else {
                                    secondsString = String.valueOf(seconds);
                                }

                                if (minutes < 10) {
                                    minutesString = "0" + minutes;
                                }else {
                                    minutesString = String.valueOf(minutes);
                                }

                                label9.setText("00:   " + minutesString + "  :   " + secondsString + "  :   " + mSecondsString);
                            }

                        }catch(Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                };
        
                thread.start();
                RPanel.setVisible(true);
			}
           // stopTimer(false);
		});
		
		
		LPanelBottom.add(label8);
		LPanelBottom.add(label9);
		LPanelBottom.add(button1);
		
		
		LPanel.add(LPanelTop);
		LPanel.add(LPanelCenter);
		LPanel.add(LPanelBottom);
		
		// Right Panel: Sudoku Board
		JLabel label10 = new JLabel("Sudoku");
		label10.setHorizontalAlignment(JLabel.CENTER);
		label10.setVerticalAlignment(JLabel.CENTER);
		label10.setBounds(0,0,680,30);
		label10.setFont(font1);
		
		sudokuPanel.setBounds(20,30,680,680);
		sudokuPanel.setLayout(new GridLayout(9,9));

		RPanel.add(label10);
		RPanel.add(sudokuPanel);
		
		frame.add(LPanel);
		frame.add(RPanel);
		RPanel.setVisible(false);
	
		// Provide final details regarding JFrame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(975,700);
	    frame.setLocation(325,600);
	    frame.setResizable(false);
	    frame.setVisible(true);
	}
	
	protected void stopTimer(boolean status) {
		if (status) {
			thread.stop();
			check.setScore(minutes,seconds);
		}
	}
	public void resetGameBoard() {
		stopTimer(true);
		RPanel.setVisible(false);
		label3b.setText(Integer.toString(account.getGamesPlayed()));
		label4b.setText(Integer.toString(account.getGamesWon()));
		label5b.setText(Integer.toString(account.getGamesLost()));
		label6b.setText(Integer.toString(account.getTotalScore()));
		label9.setText("00:" + "00:" + "00:" + "00");
		mSecondsString = "00";
        secondsString = "00";
        minutesString = "00";
        mseconds = 0;
        seconds = 0;
        minutes = 0;
		
		long elapsedTime = 0;
        long startTime = System.currentTimeMillis();
        
        sudokuPanel.resetOriginalContents();
       
		
	}
}

		