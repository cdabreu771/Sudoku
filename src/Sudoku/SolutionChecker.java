package Sudoku;

public class SolutionChecker {
	public boolean solution(String[][] solutionGrid){
		
		// Check rows for repeats
		for(int i= 0; i < 9; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = j + 1; k < 9; k++) {
					if(solutionGrid[i][j]==solutionGrid[i][k]) {
						return false;
					}
				}
			}
		}
		
		// Check columns for repeats.
		for(int i= 0; i < 9; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = j + 1; k < 9; k++) {
					if(solutionGrid[j][i] == solutionGrid[k][i]) {
						return false;
					}
				}
			}
		}
		
		// Check individual 3x3 grids for repeats.
		for(int i = 0; i < 9; i += 3) {
			for(int j = 0; j < 9; j+= 3) {
				for(int k = 0; k < 8; k++) {
					if(solutionGrid[i + (k%3)][j + (k/3)] == solutionGrid[i + ((2*k)%3)][j + ((2*k)/3)]) {
						return false;
					}
				}
			}
		}

	return true;
		
		
	}
}
