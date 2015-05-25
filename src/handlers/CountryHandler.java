package handlers;

import ui.CountryUI;
import assets.Country;

public class CountryHandler implements Observer<Country> {

	CountryUI ui;
	
	public CountryHandler(Country data) {
		ui = new CountryUI(data.getName());
	}
	
	@Override
	public void handleUpdate(Country data) {
		ui.setOwner(data.getOwner().getName());
		ui.setSoldiers(data.getSoldiers());	
	}

}
