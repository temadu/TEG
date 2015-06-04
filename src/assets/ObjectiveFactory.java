package assets;

import java.util.ArrayList;

import objectives.DestroyNextPlayerObjective;
import objectives.Objective;
import objectives.SchatariaObjective;
import objectives.TripleContinentObjective;


public class ObjectiveFactory {
	
	public static ArrayList<Objective> objectiveCreator(){
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		objectives.add(new TripleContinentObjective());
		objectives.add(new SchatariaObjective());
		//objectives.add(new DestroyNextPlayerObjective());
		//objectives.add(new DestroyNextPlayerObjective());
		//objectives.add(new DestroyNextPlayerObjective());
		return objectives;
	}
}