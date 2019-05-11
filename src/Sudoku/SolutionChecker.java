package Sudoku;

// This class checks whether the sudoku board is correct.
public class SolutionChecker {
	
	public SolutionChecker(String[][] solutionGrid) {
		solution(solutionGrid);
	}
	/* This function takes in the solution grid and iterates through the rows, columns, and
	 * 3x3 grids to confirm that there are no repeats of integers.
	 */
	public void solution(String[][] solutionGrid){
		
		// Check rows for repeats
		for(int i= 0; i < 9; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = j + 1; k < 9; k++) {
					if(solutionGrid[i][j]==solutionGrid[i][k]) {
						PopUpManager popUp = new PopUpManager(false);
					}
				}
			}
		}
		
		// Check columns for repeats.
		for(int i= 0; i < 9; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = j + 1; k < 9; k++) {
					if(solutionGrid[j][i] == solutionGrid[k][i]) {
						PopUpManager popUp = new PopUpManager(false);
					}
				}
			}
		}
		
		// Check individual 3x3 grids for repeats.
		for(int i = 0; i < 9; i += 3) {
		   for(int j = 0; j < 9; j += 3) {
		      // row, col is start of the 3 by 3 grid
		      for(int k = 0; k < 8; k++) {
		         for(int l = k + 1; l < 9; l++) {
		            if(solutionGrid[i + k%3][j + k/3]==solutionGrid[i + l%3][j + l/3]) {
		            	PopUpManager popUp = new PopUpManager(false);
		            }
		         }
		      }
		   }
		}
		PopUpManager popUp = new PopUpManager(true);
	}
}
