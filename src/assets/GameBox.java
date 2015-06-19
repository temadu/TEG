package assets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import objectives.Objective;
import objectives.ObjectiveFactory;
import objectives.WorldDominationObjective;
import situations.Situation;
import situations.SituationFactory;

/**
 * Represents the GameBox and contains all the resources for the game.
 * That means the board, objectives, situations and country cards.
 */
public class GameBox implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Board board;
	private transient ArrayList<Objective> objectives;
	private transient ArrayList<Situation> situations;
	private ArrayList<CountryCard> countryCards;
	
	public GameBox() {
		
		board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		situations = SituationFactory.situationCreator();
		countryCards = CountryCardFactory.countryCardCreator(board.getCountries());

	}
	
	public void initializeObjectives() {
		objectives = ObjectiveFactory.objectiveCreator();
	}

	public Board getBoard() {
		return board;
	}
	
	public Objective getRandomObjective() {
		
		if(objectives == null)
			return new WorldDominationObjective();
		
		Objective objective = objectives.get(0);
		objectives.remove(0);
		
		return objective;
		
	}
	
	public Situation getRandomSituation() {
		
		Collections.shuffle(situations);
		
		return situations.get(0);
		
	}
	
	public CountryCard getRandomCard() {
		
		CountryCard card = countryCards.get(0);
		countryCards.remove(0);
		
		return card;
		
	}
	
	/**
	 * Returns three CountryCards to the deck. To be used for exchanges.
	 * @param card1
	 * @param card2
	 * @param card3
	 */
	public void returnCountryCards(CountryCard card1, CountryCard card2, CountryCard card3) {
		
		countryCards.add(card1);
		countryCards.add(card2);
		countryCards.add(card3);
	
	}
	
}
