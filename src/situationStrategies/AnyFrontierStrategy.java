package situationStrategies;

import assets.Country;

public class AnyFrontierStrategy implements FrontierStrategy {

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return true;
	}

}
