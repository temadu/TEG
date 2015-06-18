package situationStrategies;

import java.io.Serializable;

import assets.Country;
/**
 * Strategy that only lets countries to attack other countries from the same Continent.
 */
public class ClosedFrontierStrategy implements FrontierStrategy,Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return attacker.getContinent().equals(defender.getContinent()) ? true : false;
	}

}
