package situationStrategies;

import java.io.Serializable;

/**
 * Strategy that lets any form of attack.
 */
public class NormalAttackStrategy implements AttackStrategy {

	@Override
	public boolean AttackCheck() {
		return true;
	}

}
