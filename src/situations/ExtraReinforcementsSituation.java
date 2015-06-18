package situations;

import situationStrategies.NobodyAttackStrategy;
/**
 * Situation that prohibits a any player to attack so they can only add troops and move them.
 * Changes the AttackStrategy in GameManager.
 */
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
