package situations;

import situationStrategies.SnowHandicapStrategy;

/**
 * Situation that gives the defender country an extra dice for defending.
 * Changes the HandicapStrategy in Battle.
 */

public class SnowSituation extends HandicapSituation {
	
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public SnowSituation() {
		super(new SnowHandicapStrategy());
		this.description = "Snow";
	}

	public String getDescription() {
		return description;
	}

}
