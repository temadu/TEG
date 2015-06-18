package objectives;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Factory Class for initializing the Objectives.
 *
 */
public class ObjectiveFactory {
	
	/**
	 * Creates the objectives for the players in the game.
	 * @return A randomized list of objectives.
	 */
	public static ArrayList<Objective> objectiveCreator(){
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		objectives.add(new TripleContinentObjective());
		objectives.add(new SchatariaObjective());
		objectives.add(new DestroyNextPlayerObjective());
		objectives.add(new DestroyNextPlayerObjective());
		objectives.add(new DestroyNextPlayerObjective());
		objectives.add(new DestroyNextPlayerObjective());
		Collections.shuffle(objectives);
		return objectives;
	}
}