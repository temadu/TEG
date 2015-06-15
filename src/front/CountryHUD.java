package front;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

// Each country in the map has it's own interface.
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
