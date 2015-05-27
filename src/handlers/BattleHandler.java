package handlers;

import java.util.ArrayList;

import assets.Battle;
import ui.DiceUI;

public class BattleHandler{

	DiceUI ui;
	
	public void handleUpdate(ArrayList<Integer> attackerDice, ArrayList<Integer> defenderDice){
		ui.setAttackerDice(attackerDice);
		ui.setDefenderDice(defenderDice);
	}

}
