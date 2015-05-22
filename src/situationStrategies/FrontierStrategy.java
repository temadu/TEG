package situationStrategies;

import assets.Country;

public interface FrontierStrategy {
	
	public boolean attackSituationChecker(Country attacker, Country defender);

}
