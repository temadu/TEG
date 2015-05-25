package assets;

import handlers.Observable;
import handlers.Observer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;

public class Dice {

	
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
