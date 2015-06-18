package situationStrategies;

import java.io.Serializable;
import assets.Country;

// Strategy that lets countries to attack any countries.

public class AnyFrontierStrategy implements FrontierStrategy, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean attackSituationChecker(Country attacker, Country defender) {
		return true;
	}

}
