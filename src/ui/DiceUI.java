package ui;

import java.util.ArrayList;

/**
 * UI counterpart the the Battle/Dice classes in the backend.
 * Created and Edited by the BattleHandler observer.
 * Access for reading to the frontend (Swing).
 */

public class DiceUI {
	
	private ArrayList<Integer> attackerDice;
	private ArrayList<Integer> defenderDice;
	
	public DiceUI() {
		attackerDice = new ArrayList<Integer>();
		defenderDice = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getAttackerDice() {
		return attackerDice;
	}
	
	public void setAttackerDice(ArrayList<Integer> attackerDice) {
		this.attackerDice = attackerDice;
	}
	
	public ArrayList<Integer> getDefenderDice() {
		return defenderDice;
	}
	
	public void setDefenderDice(ArrayList<Integer> defenderDice) {
		this.defenderDice = defenderDice;
	}
	
}
