package Sudoku;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// This class handles the log-in proponent.
public class LogInScreen {
	
	private GameAccount gAccount = null;
	private GameAccountManager account = new GameAccountManager();
	
	// This is the constructor for the LogInScreen class.
	protected LogInScreen() {
		buildScreen();
	}
	
	// This function builds the log in screen.
	private void buildScreen() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("//Users//Camille//Documents//COEN275//Assignment1//src//Sudoku//sudoku.png"));
		} catch (IOException ex) { System.out.print("IOException Occurred");
			ex.printStackTrace();
		}
		
		// Start Game Screen
		JFrame startFrame = new JFrame();
		JPanel startPanelR = new JPanel();
		JPanel startPanelL = new JPanel();
		JPanel startPanel1 = new JPanel();
		JPanel startPanel2 = new JPanel();
		JPanel startPanel3 = new JPanel();
		JPanel startPanel4 =new JPanel();
		JLabel imageLabel = new JLabel();
		imageLabel.setSize(300,300);
		
		Image dimage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
		        Image.SCALE_SMOOTH);
		
		ImageIcon icon = new ImageIcon(dimage);
		
		imageLabel.setIcon(icon);
		
		// Set left start game screen
		startPanelL.setLayout(new GridBagLayout());
		startPanelL.add(imageLabel);
		
		Font font = new Font("Arial", Font.BOLD,26);
		JLabel label1 = new JLabel("Sign In");
		label1.setFont(font);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
	
		Font font1 = new Font("Arial",Font.PLAIN,14);
		JLabel label2 = new JLabel("Username:");
		label2.setFont(font1);
		JLabel label3 = new JLabel("Password:");
		label3.setFont(font1);
		
		final int FINAL_WIDTH = 10;
		JTextField text1 = new JTextField(FINAL_WIDTH);
		text1.setText("");
		JPasswordField text2 = new JPasswordField(FINAL_WIDTH);
		
		JButton button1 = new JButton("Login");
		
		Color orange = Color.getHSBColor(33, 80, 100);
		Color white = Color.GRAY;
		button1.setFont(font1);
		button1.setForeground(white);
		button1.setBackground(orange);
		button1.setOpaque(true);
		button1.setBorderPainted(false);
		
		startPanelR.setSize(340,660);
		startPanelL.setSize(340,660);
		
		startPanel1.setSize(85, 100);
		startPanel2.setSize(85, 100);
		startPanel3.setSize(85, 100);
		startPanel4.setSize(85, 100);
		
		startPanel1.setLayout(new FlowLayout());
		startPanel1.setBounds(0,150,450,50);
		
		startPanel2.setLayout(new FlowLayout());
		startPanel2.setBounds(0,200,450,50);
		startPanel3.setLayout(new FlowLayout());
		startPanel3.setBounds(0,250,450,250);
		startPanel4.setLayout(new FlowLayout());
		startPanel4.setBounds(0,300,450,50);
		
		startPanel1.add(label1);
		startPanel2.add(label2);
		startPanel2.add(text1);
		startPanel3.add(label3);
		startPanel3.add(text2);
		startPanel4.add(button1);
		
		startPanelR.setLayout(null);
		
		startPanelR.add(startPanel1);
		startPanelR.add(startPanel2);
		startPanelR.add(startPanel3);
		startPanelR.add(startPanel4);
		
		GridLayout layout = new GridLayout(0,2);
		startFrame.setLayout(layout);
		startFrame.add(startPanelL);
		startFrame.add(startPanelR);
		
		startFrame.getRootPane().setDefaultButton(button1);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    startFrame.setSize(900,500);
	    startFrame.setLocation(325,600);
	    startFrame.setResizable(false);
	    startFrame.setVisible(true);
	    
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			    char[] password = text2.getText().toCharArray();
				String userName = text1.getText();
				gAccount = account.logIn(userName,password);
				
				if(gAccount != null){
					startFrame.dispose();
					GameBoard game = new GameBoard(account,gAccount);
				}
			}
		});
	}
}
