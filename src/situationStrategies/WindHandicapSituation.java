package situationStrategies;

public class WindHandicapSituation implements HandicapStrategy {

	@Override
	public int getDefendingHandicap() {
		return 0;
	}

	@Override
	public int getAttackingHandicap() {
		return 1;
	}

}
