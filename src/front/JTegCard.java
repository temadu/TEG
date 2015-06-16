package front;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JTegCard extends JLabel {
	
	public static final int CARD_WIDTH = 100;
	public static final int CARD_HEIGHT = 105;
	private static final int TEXT_GAP = -97;

	private String icon, countryName;
	private boolean selected;
	
	public JTegCard() {
		setSize(CARD_WIDTH, CARD_HEIGHT);
		setIconTextGap(TEXT_GAP);
	}
	
	public String getIconText() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
		setIcon(new ImageIcon("assets/Cards/" + icon.toLowerCase() + ".png"));
	}
	
	public void setCountryName(String countryName) {
		setText("<html><br><br><br><br>" + countryName + "</html>");
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void select() {
		selected = true;
		setIcon(new ImageIcon("assets/Cards/" + icon.toLowerCase() + "selected.png"));
	}
	
	public void deselect() {
		selected = false;
		setIcon(new ImageIcon("assets/Cards/" + icon.toLowerCase() + ".png"));
		
	}
	
}
