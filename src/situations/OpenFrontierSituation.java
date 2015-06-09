package situations;

import situationStrategies.OpenFrontiersStrategy;

public class OpenFrontierSituation extends FrontierCheckSituation {

	private String description;
	
	public OpenFrontierSituation() {
		super(new OpenFrontiersStrategy());
		this.description = "Open Frontiers";
	}

	public String getDescription() {
		return description;
	}
	
	

}
