package handlers;

import ui.CountryUI;
import ui.GameUI;
import assets.Country;

// Observer of the Country class that changes the CountryUI accordingly.
public class CountryHandler implements Observer<Country> {

	CountryUI ui;
	
	public CountryHandler(Country data) {
		ui = new CountryUI(data.getName());
		GameUI.getInstance().addCountry(ui);
	}
	
	@Override
	public void handleUpdate(Country data) {
		ui.setName(data.getName());
		ui.setOwner(data.getOwner().getName());
		ui.setSoldiers(data.getSoldiers());	
		ui.setContinent(data.getContinent().getName());
	}

}
