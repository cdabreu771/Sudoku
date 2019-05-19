package Sudoku;

public class GameAccount {
	private String playerName;
	private String password;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int totalScore;

protected GameAccount(String playerName, String password, int gamesPlayed, int gamesWon, int gamesLose, int totalScore) {
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
	protected String getPassword() {
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
	
	protected void setGamesPlayed(int num) {
		gamesPlayed = num;
	}
	
	protected void setGamesWon(int num) {
		gamesWon = num;
	}
	protected void setGamesLost(int num) {
		gamesLost = num;
	}
	protected void setTotalScore(int num) {
		totalScore = num;
	}
	
	protected boolean checkPassword(String pin) {
		if(password.equals(pin)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return playerName + "," + password + "," + gamesPlayed + "," + gamesWon + "," + gamesLost
				+ "," + totalScore;
	}
}