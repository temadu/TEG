package handlers;

import assets.Player;
import ui.PlayerUI;

public class PlayerHandler implements Observer<Player> {

	PlayerUI ui;
	
	
	public PlayerHandler(Player data) {
		ui = new PlayerUI(data.getName(), data.getColor());
	}



	@Override
	public void handleUpdate(Player data) {
		ui.setLeftOverSoldiers(data.getLeftOverSoldiers());
		ui.setTotalSoldiers(data.getTotalSoldiers());
//		ui.setCards(player.getCards());
//		ui.setCountries(player.getCountries());
//		ui.setObjective(player.getObjective());
	}

	
}
