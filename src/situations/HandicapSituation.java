package situations;

import situationStrategies.HandicapStrategy;
import situationStrategies.NoHandicapStrategy;
import assets.Battle;

/**
 * Abstract situation that chooses how much of a handicap is given to the attacker or defender country.
 * Changes the Handicap Strategy in Battle for that.
 */

public abstract class HandicapSituation implements Situation {
	
	private static final long serialVersionUID = 1L;

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
