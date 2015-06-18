package situationStrategies;

import java.io.Serializable;

// Strategy that prohibits any form of attack.
public class NobodyAttackStrategy implements AttackStrategy,Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean AttackCheck() {
		return false;
	}

}
