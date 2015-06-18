package situationStrategies;

import java.io.Serializable;

import assets.Country;
/**
 * Interface that adds a check if a country can attack another country.
 * Used in Country by the FrontierCheckSituation.
 */
public interface FrontierStrategy extends Serializable{
	
	public boolean attackSituationChecker(Country attacker, Country defender);

}
