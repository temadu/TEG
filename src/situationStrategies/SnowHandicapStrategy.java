package situationStrategies;

import java.io.Serializable;

// Strategy that gives the defender country an extra dice.
public class SnowHandicapStrategy implements HandicapStrategy,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int getDefendingHandicap() {
		return 1;
	}

	@Override
	public int getAttackingHandicap() {
		return 0;
	}

}
