package experiments.dice;

import java.util.Random;

public class Dice {
	
	public void roll() {
		Random rand = new Random();
		int diceUp = 0;
		int total = 0;
		
		for(int i = 0; i < 2; i++) {
			diceUp = rand.nextInt((6 - 1) +1) + 1;
			System.out.println("Dice " + (i+1) + ": " + diceUp);
			total += diceUp;
		}
		System.out.println(total);
	}

}
