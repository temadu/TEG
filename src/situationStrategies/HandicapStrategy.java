package situationStrategies;

import java.io.Serializable;

/**
 * Interface that adds a handicap to the Battle.
 * Used in Battle by the HandicapSituation.
 */

public interface HandicapStrategy extends Serializable {
	
	public int getDefendingHandicap();
	
	public int getAttackingHandicap();

}
