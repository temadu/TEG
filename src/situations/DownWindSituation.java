package situations;

import situationStrategies.WindHandicapStrategy;

/**
 * Situation that gives the attacker country an extra dice for attacking.
 * Changes the HandicapStrategy in Battle.
 */

public class DownWindSituation extends HandicapSituation {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public DownWindSituation() {
		super(new WindHandicapStrategy());
		this.description = "DownWind";
	}

	public String getDescription() {
		return description;
	}
	
}
