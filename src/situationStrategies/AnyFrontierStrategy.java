package situationStrategies;

import assets.Country;
/**
 * Strategy that lets countries to attack any countries.
 */
public class AnyFrontierStrategy implements FrontierStrategy {

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return true;
	}

}
