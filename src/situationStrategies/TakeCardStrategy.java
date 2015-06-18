package situationStrategies;

import java.io.Serializable;

/**
 * Interface that adds a check if a player can take a CountryCard or not.
 * Used in GameManager by the Crisis Situation.
 */

public interface TakeCardStrategy extends Serializable {
	
	public boolean cardTakeCheck();

}
