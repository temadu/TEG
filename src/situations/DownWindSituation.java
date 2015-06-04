package situations;

import situationStrategies.WindHandicapStrategy;

public class DownWindSituation extends HandicapSituation {

	private String description;
	
	public DownWindSituation() {
		super(new WindHandicapStrategy());
		this.description = "DownWind";
	}

	public String getDescription() {
		return description;
	}

	
}
