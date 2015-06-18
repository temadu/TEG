package situationStrategies;

/**
 * Strategy that gives no handicap in a battle.
 */
public class NoHandicapStrategy implements HandicapStrategy {

	@Override
	public int getDefendingHandicap() {
		return 0;
	}

	@Override
	public int getAttackingHandicap() {
		return 0;
	}

}
