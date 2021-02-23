package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import experiments.dice.Dice;
import experiments.tictactoe.TicTacToe;

public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Playable> playableList = new ArrayList<>(Arrays.asList(new Dice(), new TicTacToe()));
	
	public boolean showMenu() {
		System.out.println("***** Hello, please choose an option *****\n"
				+ "[1] Dice\n"
				+ "[2] Tic Tac Toe\n"
				+ "[q] Quit");
		
		String input = sc.nextLine();
		
		if(input.equals("q")) {
			System.out.println("Thanks for playing! Goodbye");
			return false;
		}
		
		if(input.matches("[12]")) {
			int index = Integer.parseInt(input);
			playableList.get(index-1).play();
		}
		return true;
	}
	

}
