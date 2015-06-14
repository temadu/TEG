package front;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameUI;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int ELEMENT_SIZE = 15;
	private static final int X_GAP = 3, Y_GAP = 3, X_CENTER = ELEMENT_SIZE-X_GAP-2;
	
	private HashMap<String,Point> countryCoordinates = new HashMap<String,Point>();
	private HashMap<String,CountryHUD> countryHUDs = new HashMap<String,CountryHUD>();
	
	private Image bg;

	public MapPanel() {

		bg = new ImageIcon("assets/Map/map.jpg").getImage();
		Dimension size = new Dimension(bg.getWidth(null), bg.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		  
		createCoordinates();
		createComponents();

	}

	public void createComponents() {
		
		ImageIcon fromImg = new ImageIcon("assets/Buttons/from.png");
		ImageIcon toImg = new ImageIcon("assets/Buttons/to.png");
		ImageIcon infoImg = new ImageIcon("assets/Buttons/info.png");
		ImageIcon troopImg = new ImageIcon("assets/Flags/troops.png");
		
		for(String s : countryCoordinates.keySet()) {
			
			Point coordinate = countryCoordinates.get(s);
			JButton infoButton = new JButton(infoImg);
			JButton fromButton = new JButton(fromImg);
			JButton toButton = new JButton(toImg);
			JLabel flagLabel = new JLabel();
			JLabel troopsLabel = new JLabel("",troopImg,0);
			CountryHUD cHUD;
			
			infoButton.setLocation(coordinate.x+X_CENTER, coordinate.y+(ELEMENT_SIZE+Y_GAP)*2);
			infoButton.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			fromButton.setLocation(coordinate.x, coordinate.y+ELEMENT_SIZE+Y_GAP);
			fromButton.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			toButton.setLocation(coordinate.x+ELEMENT_SIZE+X_GAP, coordinate.y+ELEMENT_SIZE+Y_GAP);
			toButton.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			  
			flagLabel.setLocation(coordinate.x, coordinate.y);
			flagLabel.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			troopsLabel.setLocation(coordinate.x+ELEMENT_SIZE+X_GAP, coordinate.y);
			troopsLabel.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			troopsLabel.setIconTextGap(-13);
			troopsLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
			
			cHUD = new CountryHUD(infoButton,fromButton,toButton,flagLabel,troopsLabel);
			
			countryHUDs.put(s, cHUD);
			  
		}
		
		for(int j = 0; j < GameUI.getInstance().getPlayers().size(); j++) {
			for(Iterator<String> itr = GameUI.getInstance().getPlayers().get(j).getCountries().iterator() ; itr.hasNext();) {
				String countryName = itr.next();
				countryHUDs.get(countryName).setFlagIcon(new ImageIcon("assets/Flags/" + GameUI.getInstance().getPlayers().get(j).getColor().toLowerCase() + "Flag.png"));
				// PONER NUMERO DE TROPAS --> RATA: DE DONDE SACO LA CANTIDAD DE EJERCITOS DE UN PAIS ??? PLAYERUI NO DEBERIA TENER UN SET DE COUNTRYUI ?
			}
		}
		
		for(String s : countryHUDs.keySet()) {
			
			CountryHUD cHUD = countryHUDs.get(s);
			
			add(cHUD.getFlag());
			add(cHUD.getFromButton());
			add(cHUD.getToButton());
			add(cHUD.getInfoButton());
			add(cHUD.getTroops());
			
		}
		  
	}
	    
	public void paintComponent(Graphics g) {

		g.drawImage(bg, 0, 0, null);
		  
	}
	
	public void createCoordinates() {
		
		// DE DONDE SACO LOS NOMBRES ????????
		
		// Schataria Countinent
		countryCoordinates.put("Shalathra",new Point(104,41));
		countryCoordinates.put("Azealon",new Point(134,126));
		countryCoordinates.put("Northern Schataria",new Point(191,75));
		countryCoordinates.put("North Valoran",new Point(135,191));
		countryCoordinates.put("Travaria",new Point(203,159));	
		countryCoordinates.put("The Kingdom of Sun",new Point(71,334));
		countryCoordinates.put("South Valoran",new Point(139,264));	
		countryCoordinates.put("Terrafen",new Point(166,315)); 
		countryCoordinates.put("Wraithilles",new Point(223,250));
		
		// Arlas Countinent
		countryCoordinates.put("Northern Arlas",new Point(224,321));	
		countryCoordinates.put("Hagros",new Point(318,320)); 
		countryCoordinates.put("Arlas Barrens",new Point(278,369));
		countryCoordinates.put("Zeish",new Point(253,423));	
		countryCoordinates.put("Agashar",new Point(342,376)); 
		countryCoordinates.put("Southern Arlas",new Point(369,431));
		
		// Gilacia Countinent
		countryCoordinates.put("Gilacian Isles",new Point(246,86));	
		countryCoordinates.put("Ivory Tundra",new Point(284,49));	
		countryCoordinates.put("Glice",new Point(320,80));
		countryCoordinates.put("Fridigia",new Point(388,62));
		
		// Urza Countinent
		countryCoordinates.put("Uria",new Point(505,58));	
		countryCoordinates.put("Lunador",new Point(603,34));
		countryCoordinates.put("Veylor",new Point(554,96));	
		countryCoordinates.put("Central Urza",new Point(606,106)); 
		countryCoordinates.put("Eastern Urza",new Point(671,112));
		countryCoordinates.put("Solador",new Point(556,152));	
		countryCoordinates.put("Glendara",new Point(600,185));
		
		// Algos Continent
		countryCoordinates.put("Velis",new Point(535,466));
		countryCoordinates.put("Western Algos",new Point(603,443)); 
		countryCoordinates.put("Eastern Algos",new Point(664,432)); 
		countryCoordinates.put("Boria",new Point(673,379));
		
		// Arillia Continent
		countryCoordinates.put("Drakeland",new Point(388,146)); 
		countryCoordinates.put("Ssizara",new Point(452,176)); 
		countryCoordinates.put("Azissa",new Point(499,161));
		countryCoordinates.put("Shajera",new Point(529,204)); 
		countryCoordinates.put("Western Arillia",new Point(399,290)); 
		countryCoordinates.put("Inghal",new Point(471,285));
		countryCoordinates.put("Myridia",new Point(513,268)); 
		countryCoordinates.put("Dreadmarch",new Point(559,277)); 
		countryCoordinates.put("Southern Arillia",new Point(506,395));
		countryCoordinates.put("Aroya",new Point(624,312)); 
		countryCoordinates.put("Druhm",new Point(612,251)); 
		countryCoordinates.put("Azure Kingdom",new Point(720,258));
		
	}

}