package objectives;

import backend.Player;

public abstract class Objective {
	
	private static final int COUNTRIESTOCONQUER = 26;
	private Player owner;
	private String description;
	
	public boolean generalObjectiveCheck(){
		return ((owner.countriesNumber() >= COUNTRIESTOCONQUER) ? true : false);
	}
	
	public abstract boolean checkObjective();

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
