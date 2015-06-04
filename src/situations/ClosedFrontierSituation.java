package situations;

import situationStrategies.ClosedFrontierStrategy;

public class ClosedFrontierSituation extends AttackCheckSituation {

	private String description;
	
	public ClosedFrontierSituation() {
		super(new ClosedFrontierStrategy());
		this.description = "Closed Frontiers";
	}

	public String getDescription() {
		return description;
	}

	
}
