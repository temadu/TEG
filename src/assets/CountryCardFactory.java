package assets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Factory class for the creation of the Country Cards.
 */
public class CountryCardFactory {
	private static int cardTypeNumber = 1;
	
	/**
	 * Creates a randomized CountryCard ArrayList.
	 * @param countries
	 * @return
	 */
	public static ArrayList<CountryCard> countryCardCreator(List<Country> countries){
		ArrayList<CountryCard> countryCards = new ArrayList<CountryCard>();
		for (Country country : countries) {
			countryCards.add(new CountryCard(country, getCardType()));
		}
		Collections.shuffle(countryCards);
		return countryCards;
	}
	
	private static CardType getCardType(){
		switch (cardTypeNumber) {
		case 1:
			cardTypeNumber++;
			return CardType.BALLOON;
		case 2:
			cardTypeNumber++;
			return CardType.SHIP;
		case 3:
			cardTypeNumber = 1;
			return CardType.TANK;
		}
		return CardType.TANK;
	}
}
