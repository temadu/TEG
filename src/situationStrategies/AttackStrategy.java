package situationStrategies;

import java.io.Serializable;

/**
 * Interface that adds a check if a player can attack.
 * Used in GameManager by the NoAttackSituation.
 */
public interface AttackStrategy extends Serializable{
	
	public boolean AttackCheck();
	
}
