package handlers;

import java.util.HashSet;
import java.util.Set;

import ui.GameUI;
import assets.Country;
import assets.GameManager;

public class GameHandler implements Observer<GameManager> {

	GameUI ui;
	
	public GameHandler() {
		ui = GameUI.getInstance();
	}


	@Override
	public void handleUpdate(GameManager data) {
		ui.setSubturn(data.getSubturn());
		ui.setTroopsToAdd(data.getTroopsToAdd());
		ui.setTurn(data.getTurn());
		ui.setSituation(data.getSituation().getDescription());
		if(data.getAttacker() != null)
			ui.setAttacker(data.getAttacker().getName());
		if(data.getDefender() != null)
			ui.setDefender(data.getDefender().getName());
	}


}
