package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// This class creates the UI for the GameBoard
public class GameBoard {
	
	private static final Color WHITE = Color.WHITE;
	private static final Color GREEN = Color.GREEN;
	private static final Color ORANGE = Color.ORANGE;
	private GameAccount account = null;
	private Timer timer;
	private int mseconds = 0;
	private int seconds = 0;
	private int minutes = 0;
	private int score = 0;
	private String mSecondsString = "00";
    private String secondsString = "00";
    private String minutesString = "00";
	private JLabel nameLabel = null;
	private JLabel name = null;
	private JLabel gamesPlayedLabel = null;
	private JLabel gamesPlayed = null;
	private JLabel gamesWonLabel = null;
	private JLabel gamesWon = null;
	private JLabel gamesLostLabel = null;
	private JLabel gamesLost = null;
	private JLabel scoreLabel = null;
	private JLabel scoreVal = null;
	private JLabel timerStr = null;
	private JPanel RPanel = null;
	private SudokuJPanel sudokuPanel = null;
	private GameAccountManager manager = null;
	private Thread thread;
	
	// This is the constructor for the GameBoard. It calls createGameBoard().
	protected GameBoard(GameAccountManager accountManager,GameAccount account) {
		this.account = account;
		manager = accountManager;
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
		
		// Layouts
		frame.setLayout(null);
		LPanel.setLayout(null);
		LPanelTop.setLayout(null);
		LPanelCenter.setLayout(new BoxLayout(LPanelCenter,BoxLayout.Y_AXIS));
		LPanelBottom.setLayout(new BoxLayout(LPanelBottom,BoxLayout.Y_AXIS));
		RPanel.setLayout(null);
		
		// Left Top Panel: Scoreboard
		Font font1 = new Font("Arial", Font.BOLD,26);
		JLabel scoreBoard = new JLabel("Scoreboard");
		scoreBoard.setBounds(0,0,300,50);
		scoreBoard.setFont(font1);
		scoreBoard.setHorizontalAlignment(JLabel.CENTER);
	    scoreBoard.setVerticalAlignment(JLabel.CENTER);

		nameLabel = new JLabel("Player Name:");
		nameLabel.setBounds(5,50,200,50);
		name = new JLabel(account.getPlayerName());
		name.setBounds(200,50,50,50);
		gamesPlayedLabel = new JLabel("Number of Games Played:");
		gamesPlayedLabel.setBounds(5,100,200,50);
		gamesPlayed = new JLabel(Integer.toString(account.getGamesPlayed()));
		gamesPlayed.setBounds(200,100,50,50);
		gamesWonLabel = new JLabel("Number of Games Won:");
		gamesWonLabel.setBounds(5,150,200,50);
		gamesWon = new JLabel(Integer.toString(account.getGamesWon()));
		gamesWon.setBounds(200,150,50,50);
		gamesLostLabel = new JLabel("Number of Games Lost:");
		gamesLostLabel.setBounds(5,200,200,50);
		gamesLost = new JLabel(Integer.toString(account.getGamesLost()));
		gamesLost.setBounds(200,200,50,50);
		scoreLabel = new JLabel("Total Score:");
		scoreLabel.setBounds(5,250,200,50);
		scoreVal = new JLabel(Integer.toString(account.getTotalScore()));
		scoreVal.setBounds(200,250,50,50);
		
		LPanelTop.add(scoreBoard);
		LPanelTop.add(nameLabel);
		LPanelTop.add(name);
		LPanelTop.add(gamesPlayedLabel);
		LPanelTop.add(gamesPlayed);
		LPanelTop.add(gamesWonLabel);
		LPanelTop.add(gamesWon);
		LPanelTop.add(gamesLostLabel);
		LPanelTop.add(gamesLost);
		LPanelTop.add(scoreLabel);
		LPanelTop.add(scoreVal);
		
		// Left Center Panel: Board Color
		JLabel boardColor = new JLabel("Board Color");
		boardColor.setBounds(0,300,300,50);
		boardColor.setHorizontalAlignment(JLabel.CENTER);
	    boardColor.setVerticalAlignment(JLabel.CENTER);
		boardColor.setFont(font1);
		
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
			
		LPanelCenter.add(boardColor);
		LPanelCenter.add(colorSelection);
		
		// Left Panel Bottom: Timer
		JLabel timerLabel = new JLabel("Timer");
		timerLabel.setBounds(0,600,300,50);
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
	    timerLabel.setVerticalAlignment(JLabel.CENTER);
		timerLabel.setFont(font1);
		timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerStr = new JLabel("00:" + "00:" + "00:" + "00");
		Font font2 = new Font("Arial", Font.PLAIN, 20);
		timerStr.setBounds(0,650,300,50);
		timerStr.setHorizontalAlignment(JLabel.CENTER);
	    timerStr.setVerticalAlignment(JLabel.CENTER);
	    timerStr.setFont(font2);
	    timerStr.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    JButton playButton = new JButton("Play Now");
		playButton.setBounds(0,700,300,50);
		playButton.setHorizontalAlignment(JButton.CENTER);
		playButton.setVerticalAlignment(JButton.CENTER);
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                 thread = new Thread() {
                    public void run() {
                        try {
                            long elapsedTime = 0;
                            long startTime = System.currentTimeMillis();
                     

                            while (minutes < 30) {
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

                                timerStr.setText("00:   " + minutesString + "  :   " + secondsString + "  :   " + mSecondsString);
                            }

                        }catch(Exception exception) {
                            exception.printStackTrace();
                        }
                        	sudokuPanel.setVisible(false);
                        	PopUpManager popUp = new PopUpManager("Time's up! You lost the game.");
                        	account.incrementGamesLost();
                        	account.incrementGamesPlayed();
                        	manager.writeDB(account);
                    }
                };
                thread.start();
                RPanel.setVisible(true);
			}
		});
		
		LPanelBottom.add(timerLabel);
		LPanelBottom.add(timerStr);
		LPanelBottom.add(playButton);
		
		LPanel.add(LPanelTop);
		LPanel.add(LPanelCenter);
		LPanel.add(LPanelBottom);
		
		// Right Panel: Sudoku Board
		JLabel sudokuLabel = new JLabel("Sudoku");
		sudokuLabel.setHorizontalAlignment(JLabel.CENTER);
		sudokuLabel.setVerticalAlignment(JLabel.CENTER);
		sudokuLabel.setBounds(0,0,680,30);
		sudokuLabel.setFont(font1);
		
		sudokuPanel.setBounds(20,30,680,680);
		sudokuPanel.setLayout(new GridLayout(9,9));

		RPanel.add(sudokuLabel);
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
	    
	    frame.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	            manager.writeDB(account);
	        }
	    });   
	}
	
	// This function returns the minutes counted by the timer.
	protected int getMinutes(){
		return minutes;
	}
	
	// This function returns the seconds counted by the timer.
	protected int getSeconds(){
		return seconds;
	}
	
	// This function stops the timer thread.
	@SuppressWarnings("deprecation")
	protected void stopTimer(boolean status) {
		if (status) {
			thread.stop();
		}
	}
		
	// This function resets the game board.	
	protected void resetGameBoard() {
		stopTimer(true);
		
		RPanel.setVisible(false);
		
		gamesPlayed.setText(Integer.toString(account.getGamesPlayed()));
		gamesWon.setText(Integer.toString(account.getGamesWon()));
		gamesLost.setText(Integer.toString(account.getGamesLost()));
		scoreVal.setText(Integer.toString(account.getTotalScore()));
		timerStr.setText("00:" + "00:" + "00:" + "00");
		mSecondsString = "00";
        secondsString = "00";
        minutesString = "00";
        mseconds = 0;
        seconds = 0;
        minutes = 0;
		
		long elapsedTime = 0;
        long startTime = System.currentTimeMillis();
        
        sudokuPanel.resetContents();
	}
}
