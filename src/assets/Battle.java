package assets;

import handlers.BattleHandler;
import handlers.Observable;

import java.util.ArrayList;

import situationStrategies.HandicapStrategy;
import situationStrategies.NoHandicapStrategy;

public abstract class Battle{
	
	public static HandicapStrategy handicap = new NoHandicapStrategy();
	
//	public static ArrayList<Integer> attackerDice;
//	public static ArrayList<Integer> defenderDice;
	
	public static BattleHandler observer = new BattleHandler();
	
	public static void conflict(Country attacker, Country defender){
		//no more than 4 dice!!!
		ArrayList<Integer> attackerDice;
		ArrayList<Integer> defenderDice;
		
		int attackerSoldiers = attacker.getSoldiers() + handicap.getAttackingHandicap();
		int defenderSoldiers = defender.getSoldiers() + handicap.getDefendingHandicap();
		
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

		observer.handleUpdate(attackerDice, defenderDice);
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

	public static void setHandicap(HandicapStrategy handicap) {
		Battle.handicap = handicap;
	}
}
