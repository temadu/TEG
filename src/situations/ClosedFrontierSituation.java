package situations;

import situationStrategies.ClosedFrontierStrategy;

public class ClosedFrontierSituation extends AttackCheckSituation {

	public ClosedFrontierSituation() {
		super(new ClosedFrontierStrategy());
	}

}
