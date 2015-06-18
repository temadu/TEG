package situations;

import situationStrategies.ClosedFrontierStrategy;

/**
 * Situation that prohibits a any country to attack a country in a different continent.
 * Changes the FrontierStrategy in Country.
 */
public class ClosedFrontierSituation extends FrontierCheckSituation {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public ClosedFrontierSituation() {
		super(new ClosedFrontierStrategy());
		this.description = "Closed Frontiers";
	}

	public String getDescription() {
		return description;
	}

	
}
