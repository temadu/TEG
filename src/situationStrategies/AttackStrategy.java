package situationStrategies;
/**
 * Interface that adds a check if a player can attack.
 * Used in GameManager by the NoAttackSituation.
 */
public interface AttackStrategy {
	
	public boolean AttackCheck();
	
}
