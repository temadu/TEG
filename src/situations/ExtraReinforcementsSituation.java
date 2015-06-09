package situations;

import situationStrategies.NobodyAttackStrategy;

public class ExtraReinforcementsSituation extends NoAttackSituation {

	public ExtraReinforcementsSituation() {
		super.setAttackStrategy(new NobodyAttackStrategy());
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
