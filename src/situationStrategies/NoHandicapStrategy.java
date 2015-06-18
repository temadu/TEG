package situationStrategies;

import java.io.Serializable;

/**
 * Strategy that gives no handicap in a battle.
 */
public class NoHandicapStrategy implements HandicapStrategy, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public int getDefendingHandicap() {
		return 0;
	}

	@Override
	public int getAttackingHandicap() {
		return 0;
	}

}
