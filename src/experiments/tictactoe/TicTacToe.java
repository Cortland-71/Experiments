package experiments.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import experiments.Playable;

public class TicTacToe implements Playable {
	
	private List<List<String>> moveLists = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void play() {
		boolean running = true;
		getEmptyBoard();
		while(running) {
			showBoard();
			int[] chosenIndexes = getUserRowAndColChoice();
			addPlayerMove(chosenIndexes);
			addOpponentMove();
			getResult();
		}
	}
	
	private void showBoard() {
		System.out.println("\n  1  2  3");
		for(int i = 0; i < 3; i++) {
			System.out.print(i+1);
			for(int j = 0; j < moveLists.get(i).size(); j++) {
				System.out.print("["+moveLists.get(i).get(j)+"]");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void getEmptyBoard() {
		for(int i = 0; i < 3; i++) {
			List<String> row = new ArrayList<>(Arrays.asList("_", "_", "_"));
			moveLists.add(row);
		}
	}
	
	private void addPlayerMove(int[] chosenIndexes) {
		moveLists.get(chosenIndexes[0]).set(chosenIndexes[1], "x");
		
	}
	
	private void addOpponentMove() {
		List<Integer> freeRowIndexes = new ArrayList<>();
		List<Integer> freeSpaceIndexes = new ArrayList<>();
		
		int choosenRowIndex = findFreeSpots(freeRowIndexes);
		int choosenSpaceIndex = findFreeSpots(freeSpaceIndexes);
		
		moveLists.get(choosenRowIndex).set(choosenSpaceIndex, "o");
	}
	
	private int findFreeSpots(List<Integer> searchList) {
		for(int i = 0; i < moveLists.size(); i++) {
			if(moveLists.get(i).contains("_")) searchList.add(i);
		}
		Collections.shuffle(searchList);
		int choosenIndex = searchList.get(0);
		return choosenIndex;
	}
	
	private int[] getUserRowAndColChoice() {
		int[] playerMoveArr = new int[2];
		boolean notValidInput = true;
		while(notValidInput) {
			System.out.println("You are x");
			System.out.print("Select row: ");
			String rowIndex = sc.nextLine();
			System.out.print("Select col: ");
			String colIndex = sc.nextLine();
			try {
				playerMoveArr[0] = Integer.parseInt(rowIndex)-1;
				playerMoveArr[1] = Integer.parseInt(colIndex)-1;
				
			} catch(Exception e) {
				System.out.println("\nMust enter only numbers 1 2 or 3, try again...");
				continue;
			}
			
			if(!moveLists.get(playerMoveArr[0]).get(playerMoveArr[1]).equals("_")) {
				System.out.println("\nCan't move there, try again...");
				showBoard();
				continue;
			}
			notValidInput = false;
		}
		return playerMoveArr;
	}
	
	private void getResult() {
		System.out.println(moveLists);
		checkEachRowForAWin();
	}
	
	private boolean checkEachRowForAWin() {
		for(List<String> row : moveLists) {
			if(String.join("", row).equals("xxx")) {
				System.out.println("YOU WON!");
				return true;
			} else if(String.join("", row).equals("ooo")) {
				System.out.println("YOU LOST.");
				return true;
			}
		}
		return false;
	}
}
