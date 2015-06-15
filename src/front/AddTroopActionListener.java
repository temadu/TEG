package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameUI;
import assets.GameManager;

public class AddTroopActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent a) {
		
		String countryName = TEGWindow.getInstance().getInfoFrame().getCountryNameLabel().getText();
		
		if(countryName != null) {
			
			GameManager.getInstance().addTroop();
			
			// Graphic update
			TEGWindow.getInstance().getMapFrame().getPanel().changeTroopsNumber(countryName, GameUI.getInstance().getCountryUI(countryName).getSoldiers());
			TEGWindow.getInstance().getInfoFrame().setTroopNumber(GameUI.getInstance().getCountryUI(countryName).getSoldiers());
			TEGWindow.getInstance().getPlayersFrame().setTroopsToAdd(GameUI.getInstance().getTroopsToAdd());
			
		}

	}

}
