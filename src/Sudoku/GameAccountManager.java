package Sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Sudoku.GameAccount;


public class GameAccountManager {
	
	private ArrayList<GameAccount> list = new ArrayList<GameAccount>();
	private final String location = "//Users//Camille//Documents//COEN275//Assignment1//src//Sudoku//PlayerDB";
	private Scanner scanner = new Scanner(System.in);
	private File file;
	
	//This function is the constructor for the Bank class. It imports a file, and calls the reader.
	protected GameAccountManager() {
		
		file = new File(location);
		readDB();
	}
	
	private void readDB() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); //Bufferedreader reads one line.
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] accountinfo = line.split(", ");
				GameAccount gameAccount = null;
				
				if(accountinfo.length == 6) {	// string.length() array.length <-- if array is of single variables
					 gameAccount = new GameAccount(accountinfo[0], accountinfo[1],Integer.parseInt(accountinfo[2]),
							 Integer.parseInt(accountinfo[3]), Integer.parseInt(accountinfo[4]),Integer.parseInt(accountinfo[5]));
				}
				else {
					System.out.println ("Error:Incorrect account format.");
				}
				
				if (gameAccount != null) {
					list.add(gameAccount);
				}
			}		
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException Occurred");
		} catch (IOException ex) {
			System.out.println ("IOException Occurred");
		}
	}
	
	protected boolean logIn(String userName, String password) {
		
		
		GameAccount usersAccount = null;
		
		for (int i = 0; i < list.size(); i ++) { // arrayList.size() <-- if array is of objects
			GameAccount gameAccount = list.get(i);  //<-- arrayList.get(i), array[i]
			if(gameAccount.getPlayerName().equals(userName)) {
				usersAccount = gameAccount;
				break;
			}
		}
		
		if(usersAccount == null) {
			PopUpManager popUp = new PopUpManager("Error: Incorrect Username Entered");
			return false;
		}
		
			
		if (usersAccount.checkPassword(password)) {
			return true;
		
		}
		
		PopUpManager popUp = new PopUpManager("Error: Invalid Password Entered");
		return false;
	}

	protected void writeDB() {
		try {
			FileOutputStream writer = new FileOutputStream(file,false); //false because we do not 
			//want to append (add duplicates) to the original file
			
			
			for (int i = 0; i < list.size(); i ++) {
				StringBuilder account = new StringBuilder();
				account.append(list.get(i).getPlayerName());
				account.append(", ");
				account.append(list.get(i).getPassword());
				account.append(", ");
				account.append(list.get(i).getGamesPlayed());
				account.append(", ");
				account.append(list.get(i).getGamesWon());
				account.append(", ");
				account.append(list.get(i).getGamesLost());
				account.append(", ");
				account.append(list.get(i).getTotalScore());
				account.append("\n");
				
				writer.write(account.toString().getBytes());
			}
			return;
		} catch(FileNotFoundException ex) { 
			System.out.println("FileNotFoundException occurred.");
		} catch (IOException ex) {
			System.out.println("IOException occurred.");
		}
	}
}
