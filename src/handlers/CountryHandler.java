package handlers;

import ui.CountryUI;
import ui.GameUI;
import assets.Country;

public class CountryHandler implements Observer<Country> {

	CountryUI ui;
	
	public CountryHandler(Country data) {
		ui = new CountryUI(data.getName());
		GameUI.getInstance().addCountry(ui);
	}
	
	@Override
	public void handleUpdate(Country data) {
		ui.setOwner(data.getOwner().getName());
		ui.setSoldiers(data.getSoldiers());	
	}

}
