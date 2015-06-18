package situationStrategies;

/**
 * Strategy that gives the defender country an extra dice.
 */
public class SnowHandicapStrategy implements HandicapStrategy {

	@Override
	public int getDefendingHandicap() {
		return 1;
	}

	@Override
	public int getAttackingHandicap() {
		return 0;
	}

}
