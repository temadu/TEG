package situationStrategies;

import java.io.Serializable;

/**
 * Strategy that gives the attacker country an extra dice.
 */
public class WindHandicapStrategy implements HandicapStrategy, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int getDefendingHandicap() {
		return 0;
	}

	@Override
	public int getAttackingHandicap() {
		return 1;
	}

}
