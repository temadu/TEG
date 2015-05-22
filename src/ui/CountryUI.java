package ui;

import assets.Player;

public class CountryUI {

	private String name;
	private int soldiers;
	private PlayerUI owner;
	
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

	public PlayerUI getOwner() {
		return owner;
	}

	public void setOwner(PlayerUI owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}
	
	
	
}
