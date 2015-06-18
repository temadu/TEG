package objectives;

import java.util.ArrayList;


public class ObjectiveFactory {
	
	public static ArrayList<Objective> objectiveCreator(){
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		objectives.add(new TripleContinentObjective());
		objectives.add(new SchatariaObjective());
		objectives.add(new DestroyNextPlayerObjective());
		objectives.add(new DestroyNextPlayerObjective());
		objectives.add(new DestroyNextPlayerObjective());
		objectives.add(new DestroyNextPlayerObjective());
		return objectives;
	}
}