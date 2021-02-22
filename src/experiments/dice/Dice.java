package experiments.dice;

import java.util.Random;
import java.util.Scanner;

public class Dice {
	
	public void play() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			roll();
			String answer = sc.nextLine();
			if(answer.equals("n")) {
				System.out.println("Thanks for playing!");
				break;
			}
		}
		
	}
	
	private void roll() {
		Random rand = new Random();
		int diceUp = 0;
		int total = 0;
		
		for(int i = 0; i < 2; i++) {
			diceUp = rand.nextInt((6 - 1) +1) + 1;
			System.out.println("Dice " + (i+1) + ": " + diceUp);
			total += diceUp;
		}
		System.out.println(total);
		
		System.out.println("Continue? y/n");
	}

}
