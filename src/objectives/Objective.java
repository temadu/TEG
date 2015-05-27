package objectives;

import assets.Player;

public abstract class Objective {
	
	private static final int COUNTRIESTOCONQUER = 26;
	private Player owner;
	private String description;
	
	public boolean checkObjective(){
		return (((owner.countriesNumber() >= COUNTRIESTOCONQUER) || checkSpecificObjective()) ? true : false);
	}
	
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
