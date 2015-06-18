package situations;

import java.io.Serializable;

import situationStrategies.AttackStrategy;
import situationStrategies.NormalAttackStrategy;
import assets.GameManager;
/**
 * Abstract situation that prohibits attack.
 * Changes the AttackStrategy in GameManager for that.
 *
 */
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
