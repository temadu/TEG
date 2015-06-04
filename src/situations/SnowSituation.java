package situations;

import situationStrategies.SnowHandicapStrategy;

public class SnowSituation extends HandicapSituation {
	
	private String description;
	
	public SnowSituation() {
		super(new SnowHandicapStrategy());
		this.description = "Snow";
	}

	public String getDescription() {
		return description;
	}
	

}
