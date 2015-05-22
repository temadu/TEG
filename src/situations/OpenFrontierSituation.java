package situations;

import situationStrategies.OpenFrontiersStrategy;

public class OpenFrontierSituation extends AttackCheckSituation {

	public OpenFrontierSituation() {
		super(new OpenFrontiersStrategy());
	}

}
