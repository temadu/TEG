package objectives;

import assets.Player;

/**
 * Abstract class that represents the general parts of an objective.
 * To be extended to add the specific parts of the objective.
 * Uses the Template Method Pattern Strategy for that.
 */

public abstract class Objective {
	
	private static final int COUNTRIESTOCONQUER = 26;
	
	private Player owner;
	private String description;
	
	// Checks if the general objective or the specific objective has been fulfilled.
	public boolean checkObjective(){
		return (((owner.countriesNumber() >= COUNTRIESTOCONQUER) || checkSpecificObjective()) ? true : false);
	}
	
	// The speciffic objective to be extended.
	public abstract boolean checkSpecificObjective();

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

}
