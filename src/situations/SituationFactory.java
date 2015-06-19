package situations;

import java.util.ArrayList;

/**
 * Factory class for implementing Situations.
 */
public class SituationFactory {
	
	/**
	 * Method for initializing Situations.
	 * @return
	 */
	public static ArrayList<Situation> situationCreator() {
		
		ArrayList<Situation> situations = new ArrayList<Situation>();
		
		situations.add(new DownWindSituation());
		situations.add(new SnowSituation());
		situations.add(new OpenFrontierSituation());
		situations.add(new ClosedFrontierSituation());
		situations.add(new NormalSituation());
		situations.add(new CrisisSituation());
		situations.add(new ExtraReinforcementsSituation());
		situations.add(new TimeOutSituation());
		
		return situations;
		
	}

}
