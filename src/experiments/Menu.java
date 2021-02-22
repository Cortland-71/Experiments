package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import experiments.dice.Dice;

public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Playable> playableList = new ArrayList<>(Arrays.asList(new Dice()));
	
	public boolean showMenu() {
		System.out.println("***** Hello, please choose an option *****\n"
				+ "[1] Dice\n"
				+ "[q] Quit");
		
		String input = sc.nextLine();
		if(input.equals("q")) {
			System.out.println("Thanks for playing! Goodbye");
			return false;
		}
		
		if(input.matches("[1]")) {
			int index = Integer.parseInt(input);
			playableList.get(index-1).play();
		}
		return true;
		
	}
	

}
