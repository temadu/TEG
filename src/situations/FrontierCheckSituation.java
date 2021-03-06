package situations;

import situationStrategies.AnyFrontierStrategy;
import situationStrategies.FrontierStrategy;
import assets.Country;

/**
 * Abstract situation that prohibits attack depending on the attacker and defender.
 * Changes the FrontierStrategy in Country for that.
 */

public abstract class FrontierCheckSituation implements Situation {

	private static final long serialVersionUID = 1L;
	
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
