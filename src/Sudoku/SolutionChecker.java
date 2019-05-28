package Sudoku;

// This class checks whether the sudoku board is correct.
public class SolutionChecker {
	GameBoard board = null;
	private GameAccount account = new GameAccount();
	boolean status = true;
	int score = 0;
	protected SolutionChecker(GameAccount account)
	{
		this.account=account;
	}
	protected SolutionChecker(String[][] solutionGrid, GameAccount account, GameBoard board) {
		this.board = board;
		this.account = account;
		solution(solutionGrid, board);
		
	}
	
	/* This function takes in the solution grid and iterates through the rows, columns, and
	 * 3x3 grids to confirm that there are no repeats of integers.
	 */
	private void solution(String[][] solutionGrid, GameBoard board){
		
		account.incrementGamesPlayed();
		
		// Check rows for duplicates
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = j + 1; k < 9; k++) {
					if(Integer.parseInt(solutionGrid[i][j])==Integer.parseInt(solutionGrid[i][k])) {
						status = false;
					}
				}
			}
		}

		// Check columns for duplicates.
		for(int j = 0; j < 9; j++) {
			for(int i = 0; i < 8; i++) {
				for(int k = i + 1; k < 9; k++) {
					if(Integer.parseInt(solutionGrid[i][j])==Integer.parseInt(solutionGrid[k][j])) {
						status = false;
					}
				}
			}
		}

		// Check 3x3 squares for duplicates.
		for(int i = 0; i < 9; i += 3) {
			for(int j = 0; j < 9; j += 3) {
				for(int k = 0; k < 8; k++) {
					for(int l = k + 1; l < 9; l++) {
						if(Integer.parseInt(solutionGrid[i + k%3][j + k/3])==Integer.parseInt(solutionGrid[i + l%3][j + l/3])) {
							status = false;
						}
					}
				}
			}
		}
	}
	
	protected void setScore(int minutes, int seconds) {
		if (status) {
			account.incrementGamesWon();
			score += 500;
			int minsLeft = 29 - minutes;
			int secsLeft = 60 - seconds;
			score += (minsLeft * 60) + secsLeft;
			
		}
		else {
			account.incrementGamesLost();
			score = 0;
		}
		
		account.setTotalScore(score);
		PopUpManager popUp = new PopUpManager(status,account,board);
	}
}

