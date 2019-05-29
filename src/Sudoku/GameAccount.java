package Sudoku;

import java.util.Arrays;

//This class manages the contents of the game account.
public class GameAccount {

	private String playerName;
	private char[] password;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int totalScore;
	
	// This is the default constructor for the GameAccount class.
	protected GameAccount() {
		
	}
	
	// This is the constructor for the GameAccount class.
	protected GameAccount(String playerName, char[] password, int gamesPlayed, int gamesWon, int gamesLost, int totalScore) {
		this.playerName = playerName;
		this.password = password;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
		this.totalScore = totalScore;
	}

	//This function accesses the player name from the game account.
	protected String getPlayerName() {
		return playerName;
	}
	
	// This function accesses the password for the game account.
	protected char[] getPassword() {
		return password;
	}
	
	// This function accesses the number of games played from the game account.
	protected int getGamesPlayed() {
		return gamesPlayed;
	}
	
	// This function accesses the number of games won from the game account.
	protected int getGamesWon() {
		return gamesWon;
	}
	
	// This function accesses the number of games lost from the game account.
	protected int getGamesLost() {
		return gamesLost;
	}
	
	// This function accesses the total score from the game account.
	protected int getTotalScore() {
		return totalScore;
	}
	
	// This function checks the login password with the password for the game account.
	protected boolean checkPassword(char[] pin) {
		if(Arrays.equals(password, pin)) {
			return true;
		}
		return false;
	}
	
	// This function increments the number of games played.
	protected void incrementGamesPlayed() {
		gamesPlayed++;
	}
	
	// This function increments the number of games won.
	protected void incrementGamesWon() {
		gamesWon++;
	}
	
	// This function increments the number of games lost.
	protected void incrementGamesLost() {
		gamesLost++;
	}
	
	// This function recalculates the score.
	protected void setTotalScore(int num) {
		totalScore += num;
	}
	
	// This function allows the game account to be rewritten in String form.
	@Override
	public String toString() {
		return playerName + "," + password + "," + gamesPlayed + "," + gamesWon + "," + gamesLost
				+ "," + totalScore;
	}
}