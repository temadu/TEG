package handlers;

import java.util.HashSet;
import java.util.Set;

import ui.CountryCardUI;
import ui.CountryUI;
import ui.GameUI;
import ui.PlayerUI;
import assets.Country;
import assets.CountryCard;
import assets.Player;

public class PlayerHandler implements Observer<Player> {

	PlayerUI ui;
	
	
	public PlayerHandler(Player data) {
		ui = new PlayerUI(data.getName(), data.getColor());
		if(!GameUI.getInstance().getPlayers().contains(this)){
			GameUI.getInstance().getPlayers().add(ui);
		}
	}

	@Override
	public void handleUpdate(Player data) {
		ui.setName(data.getName());
		ui.setLeftOverSoldiers(data.getLeftOverSoldiers());
		ui.setTotalSoldiers(data.getTotalSoldiers());
		ui.setObjective(data.getObjective().getDescription());
		ui.setCountries(countriesToCountryUI(data.getCountries()));
		ui.setCards(cardsToUI(data.getCards()));
		ui.setIsDead(data.getIsDead());	
	}

	public Set<CountryUI> countriesToCountryUI(Set<Country> countries){
		Set<CountryUI> aux = new HashSet<CountryUI>();
		for (Country country : countries) {
			aux.add(GameUI.getInstance().getCountryUI(country.getName()));
		}
		return aux;
	}
	
	
	public Set<CountryCardUI> cardsToUI(Set<CountryCard> countryCards){
		Set<CountryCardUI> aux = new HashSet<CountryCardUI>();
		for (CountryCard card : countryCards) {
			aux.add(new CountryCardUI(card.getCountry().getName(),card.getType()));
		}
		return aux;
	}
	
}
