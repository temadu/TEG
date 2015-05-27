package assets;

import java.util.HashMap;

import objectives.DestroyNextPlayerObjective;
import objectives.Objective;
import objectives.SchatariaObjective;
import objectives.TripleContinentObjective;


public class ObjectiveFactory {
	
	public static HashMap<Objective, Boolean> objectiveCreator(){
		HashMap<Objective, Boolean> objectives = new HashMap<Objective, Boolean>();
		objectives.put(new TripleContinentObjective(), false);
		objectives.put(new SchatariaObjective(), false);
		objectives.put(new DestroyNextPlayerObjective(), false);
		objectives.put(new DestroyNextPlayerObjective(), false);
		objectives.put(new DestroyNextPlayerObjective(), false);
		return objectives;
	}
}