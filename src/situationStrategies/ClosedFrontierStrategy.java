package situationStrategies;

import assets.Country;

public class ClosedFrontierStrategy implements FrontierStrategy {

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return attacker.getContinent().equals(defender.getContinent()) ? true : false;
	}

}
