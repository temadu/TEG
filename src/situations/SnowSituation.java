package situations;

import situationStrategies.SnowHandicapStrategy;

public class SnowSituation extends HandicapSituation {
	
	public SnowSituation() {
		super(new SnowHandicapStrategy());
	}

}
