package assets;

import java.util.ArrayList;

public abstract class Battle {
	
	public static void conflict(Country attacker, Country defender){
		//no more than 4 dice!!!
		ArrayList<Integer> attackerDice;
		ArrayList<Integer> defenderDice;
		
		int attackerSoldiers = attacker.getSoldiers();
		int defenderSoldiers = defender.getSoldiers();
		
		if(attackerSoldiers > 5)
			attackerDice = Dice.rollDice(4);
		else
			attackerDice = Dice.rollDice(attackerSoldiers-1);
		
		if(defenderSoldiers > 5)
			defenderDice = Dice.rollDice(4);
		else
			defenderDice = Dice.rollDice(defenderSoldiers-1);
		
		int[] kills = diceComparator(attackerDice, defenderDice);
		
		attacker.killSoldiers(kills[0]);
		if(defender.killSoldiers(kills[1]))
			defender.changeOwner(attacker.getOwner());
	
	}
	
	private static int[] diceComparator(ArrayList<Integer> attackerDice, ArrayList<Integer> defenderDice){
		int[] kills = {0,0};
		for (Integer num : attackerDice) {
			if(attackerDice.indexOf(num) >= defenderDice.size())
				break;
			else{
				if(num > defenderDice.get(attackerDice.indexOf(num)))
					kills[0]++;
				else
					kills[1]++;
			}
		}
		return kills;
	}

}
