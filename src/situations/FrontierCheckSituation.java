package situations;

import situationStrategies.AnyFrontierStrategy;
import situationStrategies.FrontierStrategy;
import assets.Country;

public abstract class FrontierCheckSituation implements Situation {

	private static FrontierStrategy normalStrategy = new AnyFrontierStrategy();
	private FrontierStrategy attackStrategy;
	
	public FrontierCheckSituation(FrontierStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}
	
	@Override
	public void situationStart() {
		Country.setFrontierStrategy(attackStrategy);
	}

	@Override
	public void situationEnd() {
		Country.setFrontierStrategy(normalStrategy);
	}

}
