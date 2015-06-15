package situations;

import situationStrategies.NobodyAttackStrategy;

public class ExtraReinforcementsSituation extends NoAttackSituation {
	
	private String description;

	public ExtraReinforcementsSituation() {
		super.setAttackStrategy(new NobodyAttackStrategy());
		description = "Extra Reinforcements";
	}

	@Override
	public String getDescription() {
		return description;
	}

}
