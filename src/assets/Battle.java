package assets;

import handlers.BattleHandler;
import handlers.Observable;

import java.util.ArrayList;

import situationStrategies.HandicapStrategy;
import situationStrategies.NoHandicapStrategy;
/**
 * Abstract class that represents the battleground between countries.
 */
public abstract class Battle{
	
	public static HandicapStrategy handicap = new NoHandicapStrategy();
	
	public static BattleHandler observer = new BattleHandler();
	/**
	 * Performs a battle between two countries using Dice and substracts troops from each country.
	 * 
	 * @param attacker Attacker Country
	 * @param defender Defender Country
	 * @return If the defender country was conquered.
	 */
	public static boolean conflict(Country attacker, Country defender){
		//no more than 4 dice!!!
		ArrayList<Integer> attackerDice;
		ArrayList<Integer> defenderDice;
		
		Console.add(attacker.getName() + " (" + attacker.getOwner().getName() + ") attacked " + defender.getName() +" (" + defender.getOwner().getName() + ").");
		
		int attackerSoldiers = attacker.getSoldiers() + handicap.getAttackingHandicap();
		int defenderSoldiers = defender.getSoldiers() + handicap.getDefendingHandicap();
		
		if(attackerSoldiers > 5)
			attackerDice = Dice.rollDice(4);
		else
			attackerDice = Dice.rollDice(attackerSoldiers-1);
		
		if(defenderSoldiers >= 5)
			defenderDice = Dice.rollDice(4);
		else
			defenderDice = Dice.rollDice(defenderSoldiers);
		
		int[] kills = diceComparator(attackerDice, defenderDice);
		
		attacker.killSoldiers(kills[1]);
		if(defender.killSoldiers(kills[0])){
			defender.changeOwner(attacker.getOwner());
			attacker.killSoldiers(1);
		}
		observer.handleUpdate(attackerDice, defenderDice);		
		
		return attacker.getOwner().equals(defender.getOwner());
			
	}
	/**
	 * Compares two arraylists as the game's Dice.
	 * 
	 * @param attackerDice 
	 * @param defenderDice
	 * @return A vector with the number of kills by the attacker and the number of kills by the defender.
	 */
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
