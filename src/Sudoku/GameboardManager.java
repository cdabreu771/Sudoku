package Sudoku;


public class GameboardManager {
	public static void main(String[] args) {
		String[][] solutionGrid = new String[9][9];	
		GameBoard newGame = new GameBoard();
		// Call to actionListener/create solution board
		//solutionGrid = ;
		SolutionChecker check = new SolutionChecker();
		boolean status = check.solution(solutionGrid);
		PopUpManager popUp = new PopUpManager(status);
		
		
		
		////// Priority of questions:
		/*
		1. GameBoard Covers
		2. SudokuJPanel ActionListener
		3.PopUpManager "OK" JButton ActionListener
		4. PopUpManager images
		5. Paint
		6. PopUpManager PopUpThree check "OK" JButtonlistener
		*/

	}

}
