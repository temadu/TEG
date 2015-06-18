package situations;

import assets.Battle;
import situationStrategies.HandicapStrategy;
import situationStrategies.NoHandicapStrategy;
/**
 * Abstract situation that chooses how much of a handicap is given to the attacker or defender country.
 * Changes the Handicap Strategy in Battle for that.
 *
 */
public abstract class HandicapSituation implements Situation {

	private static HandicapStrategy normalStrategy = new NoHandicapStrategy();
	private HandicapStrategy handicapStrategy;
	
	public HandicapSituation(HandicapStrategy handicapStrategy) {
		this.handicapStrategy = handicapStrategy;
	}
	
	@Override
	public void situationStart() {
		Battle.setHandicap(handicapStrategy);
	}

	@Override
	public void situationEnd() {
		Battle.setHandicap(normalStrategy);
	}

}
