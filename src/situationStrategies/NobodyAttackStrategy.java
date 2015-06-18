package situationStrategies;
/**
 * Strategy that prohibits any form of attack.
 */
public class NobodyAttackStrategy implements AttackStrategy {

	@Override
	public boolean AttackCheck() {
		return false;
	}

}
