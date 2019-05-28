package Sudoku;

import java.util.Arrays;

public class GameAccount {
	private String playerName;
	private char[] password;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int totalScore;
	
protected GameAccount() {
	
}

protected GameAccount(String playerName, char[] password, int gamesPlayed, int gamesWon, int gamesLose, int totalScore) {
	this.playerName = playerName;
	this.password = password;
	this.gamesPlayed = gamesPlayed;
	this.gamesWon = gamesWon;
	this.gamesLost = gamesLost;
	this.totalScore = totalScore;
}


//This function accesses the account number for the bank account.
	protected String getPlayerName() {
		return playerName;
	}
	
	// This function accesses the pin for the bank account.
	protected char[] getPassword() {
		return password;
	}
	
	// This function accesses the account name for the bank account.
	protected int getGamesPlayed() {
		return gamesPlayed;
	}
	
	// This function accesses the savings account for the bank account.
	protected int getGamesWon() {
		return gamesWon;
	}
	
	protected int getGamesLost() {
		return gamesLost;
	}
	
	protected int getTotalScore() {
		return totalScore;
	}
	
	protected boolean checkPassword(char[] pin) {
		if(Arrays.equals(password, pin)) {
			return true;
		}
		return false;
	}
	protected void incrementGamesPlayed() {
		gamesPlayed++;
	}
	protected void incrementGamesWon() {
		gamesWon++;
	}
	
	protected void incrementGamesLost() {
		gamesLost++;
	}
	protected void setTotalScore(int num) {
		totalScore += num;
	}
	
	@Override
	public String toString() {
		return playerName + "," + password + "," + gamesPlayed + "," + gamesWon + "," + gamesLost
				+ "," + totalScore;
	}
}