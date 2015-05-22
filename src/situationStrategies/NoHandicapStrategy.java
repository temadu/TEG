package situationStrategies;

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
