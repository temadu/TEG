package situations;

import situationStrategies.WindHandicapStrategy;

public class DownWindSituation extends HandicapSituation {

	public DownWindSituation() {
		super(new WindHandicapStrategy());
	}

}
