package situationStrategies;

/**
 * Strategy that gives the attacker country an extra dice.
 */
public class WindHandicapStrategy implements HandicapStrategy {

	@Override
	public int getDefendingHandicap() {
		return 0;
	}

	@Override
	public int getAttackingHandicap() {
		return 1;
	}

}
