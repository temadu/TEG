package situationStrategies;
/**
 * Interface that adds a handicap to the Battle.
 * Used in Battle by the HandicapSituation.
 */
public interface HandicapStrategy {
	
	public int getDefendingHandicap();
	
	public int getAttackingHandicap();

}
