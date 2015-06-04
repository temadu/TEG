package handlers;

import ui.GameUI;
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
	}

}
