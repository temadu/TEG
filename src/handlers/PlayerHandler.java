package handlers;

import java.util.HashSet;
import java.util.Set;

import assets.Country;
import assets.CountryCard;
import assets.Player;
import ui.CountryCardUI;
import ui.PlayerUI;

public class PlayerHandler implements Observer<Player> {

	PlayerUI ui;
	
	
	public PlayerHandler(Player data) {
		ui = new PlayerUI(data.getName(), data.getColor());
	}

	@Override
	public void handleUpdate(Player data) {
		ui.setName(data.getName());
		ui.setLeftOverSoldiers(data.getLeftOverSoldiers());
		ui.setTotalSoldiers(data.getTotalSoldiers());
		ui.setObjective(data.getObjective().getDescription());
		ui.setCountries(countriesToUI(data.getCountries()));
		ui.setCards(cardsToUI(data.getCards()));
	}

	public Set<String> countriesToUI(Set<Country> countries){
		Set<String> aux = new HashSet<String>();
		for (Country country : countries) {
			aux.add(country.getName());
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
