package situations;

import situationStrategies.AttackStrategy;
import situationStrategies.NormalAttackStrategy;
import assets.GameManager;

public abstract class NoAttackSituation implements Situation {

	private static AttackStrategy normalStrategy = new NormalAttackStrategy();
	private AttackStrategy attackStrategy;
	
	@Override
	public void situationStart() {
		GameManager.getInstance().setAttackStrategy(attackStrategy);
	}

	@Override
	public void situationEnd() {
		GameManager.getInstance().setAttackStrategy(normalStrategy);
	}

	protected void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}

}
