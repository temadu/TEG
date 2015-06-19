package situationStrategies;

import java.io.Serializable;

/**
 * Strategy that lets any form of attack.
 */
public class NormalAttackStrategy implements AttackStrategy, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean AttackCheck() {
		return true;
	}

}
