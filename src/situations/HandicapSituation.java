package situations;

import assets.Battle;
import situationStrategies.HandicapStrategy;
import situationStrategies.NoHandicapStrategy;

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
