package situationStrategies;

import assets.Country;

public class OpenFrontiersStrategy implements FrontierStrategy {

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return attacker.getContinent().equals(defender.getContinent()) ? false : true;
	}

}
