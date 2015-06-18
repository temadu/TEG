package assets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

// Class that represents the Dice.
public abstract class Dice {
	
	/**
	 * Gives an ArrayList of integers from 1 to 6 that represents the dice rolled.
	 * @param ammount The number of dice to be rolled.
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Integer> rollDice(int ammount) throws IllegalArgumentException {
		
		if(ammount > 4 || ammount <= 0) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < ammount ; i++) { 
			numbers.add(getRandomNumber());
		}
		
		numbers.sort(new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		return numbers;
	}
	
	private static int getRandomNumber() {
	
		Random r = new Random();
		
		return r.nextInt(6)+1;
	
	}
	
}
