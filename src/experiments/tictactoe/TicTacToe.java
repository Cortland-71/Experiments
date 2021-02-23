package experiments.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import experiments.Playable;

public class TicTacToe implements Playable {
	
	private List<List<String>> moveLists = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void play() {
		getEmptyBoard();
		showBoard();
		getUserRowAndColChoice();
		
	}
	
	private void showBoard() {
		for(List<String> row : moveLists) {
			for(String item : row) {
				System.out.print("["+item+"]");
			}
			System.out.println();
		}
	}
	
	private void getEmptyBoard() {
		for(int i = 0; i < 3; i++) {
			List<String> row = new ArrayList<>(Arrays.asList("_", "_", "_"));
			moveLists.add(row);
		}
	}
	
	private void getUserRowAndColChoice() {
		System.out.print("Enter row: ");
		String rowIndex = sc.nextLine();
		System.out.print("Enter col: ");
		String colIndex = sc.nextLine();
	}
	

}
