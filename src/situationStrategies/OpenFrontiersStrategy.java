package situationStrategies;

import assets.Country;
/**
 * Strategy that only lets countries to attack other countries from a different Continent.
 */
public class OpenFrontiersStrategy implements FrontierStrategy {

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return attacker.getContinent().equals(defender.getContinent()) ? false : true;
	}

}
