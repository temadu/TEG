package handlers;

import java.util.ArrayList;

import ui.DiceUI;
import ui.GameUI;

public class BattleHandler{

	DiceUI ui;
	
	public BattleHandler() {
		ui = new DiceUI();
        GameUI.getInstance().setDice(ui);
	}
	
	public void handleUpdate(ArrayList<Integer> attackerDice, ArrayList<Integer> defenderDice){
		ui.setAttackerDice(attackerDice);
		ui.setDefenderDice(defenderDice);
	}

}