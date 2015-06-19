package front;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 * 	This class represents the HUD of each country:
 * 	flag, troop number, and buttons to attack, move
 * 	troops and fetch data of the country.
 *
 */
public class CountryHUD {
	
	private JButton infoButton, fromButton, toButton;
	private JLabel flag, troops;
	
	public CountryHUD(JButton infoButton, JButton fromButton, JButton toButton,
			JLabel flag, JLabel troops) {

		this.infoButton = infoButton;
		this.fromButton = fromButton;
		this.toButton = toButton;
		this.flag = flag;
		this.troops = troops;
		
	}

	public void setFlagIcon(ImageIcon icon) {
		flag.setIcon(icon);
	}
	
	public void setTroopsNumber(Integer number) {
		if(number >= 10)
			troops.setIconTextGap(-12);
		else
			troops.setIconTextGap(-10);
		troops.setText(number.toString());
	}

	public JButton getInfoButton() {
		return infoButton;
	}

	public JButton getFromButton() {
		return fromButton;
	}

	public JButton getToButton() {
		return toButton;
	}

	public JLabel getFlag() {
		return flag;
	}

	public JLabel getTroops() {
		return troops;
	}

}
