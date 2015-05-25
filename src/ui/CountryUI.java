package ui;

import assets.Player;

public class CountryUI {

	private String name;
	private int soldiers;
	private String owner;
	
	public CountryUI(String name) {
		this.name = name;
		this.soldiers = 1;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}
	
	
	
}
