package front;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JTegCard extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	public static final int CARD_WIDTH = 100;
	public static final int CARD_HEIGHT = 105;
	private static final int TEXT_GAP = -97;
	private static final int MAX_TEXT_WIDTH = 17;
	
	private static final String SPACE = "&nbsp;";
	private static final String NEW_LINE = "<br>";
	
	private String icon;
	private String countryName;
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
		
		String s1 = "", s2 = "";
		
		this.countryName = countryName;
		
		if(countryName.contains(" ")) {
			s1 = countryName.substring(0,countryName.indexOf(" "));
			s2 = countryName.substring(countryName.indexOf(" ")+1);
		} else 
			s1 = countryName;
		
		s1 = centerString(s1);
		if(!s2.equals(""))
			s2 = centerString(s2);
		
		// (between <html></html> to separate the text in lines)
		setText("<html>" + NEW_LINE + NEW_LINE + NEW_LINE + NEW_LINE +
				s1 + NEW_LINE + s2 + "</html>");
	
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
	
	public String centerString(String s) {
		
		if(s.length() < MAX_TEXT_WIDTH) {
			String aux = "";
			for(int i = 0; i < (MAX_TEXT_WIDTH/2)-(s.length()/2)-1; i++)
				aux += SPACE + SPACE;
			aux += s;
			return aux;
		}
		return s;
	}

	public String getCountryName() {
		return countryName;
	}
	
}
