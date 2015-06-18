package situations;

import situationStrategies.OpenFrontiersStrategy;

/**
 * Situation that prohibits a any country to attack a country in the same continent.
 * Changes the FrontierStrategy in Country.
 */
public class OpenFrontierSituation extends FrontierCheckSituation {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public OpenFrontierSituation() {
		super(new OpenFrontiersStrategy());
		this.description = "Open Frontiers";
	}

	public String getDescription() {
		return description;
	}
	
	

}
