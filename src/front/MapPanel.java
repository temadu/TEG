package front;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.GameManager;
import ui.GameUI;

public class MapPanel extends JPanel implements GraphicUpdate {

	private static final long serialVersionUID = 1L;
	
	private static final int ELEMENT_SIZE = 15;
	private static final int X_GAP = 3, Y_GAP = 3, X_CENTER = ELEMENT_SIZE-X_GAP-2;
	
	private HashMap<String,Point> countryCoordinates = new HashMap<String,Point>();
	private HashMap<String,CountryHUD> countryHUDs = new HashMap<String,CountryHUD>();
	
	private final static int NO_CONTINENT = -1;
	private final static int YELLOW_CONTINENT = 0;
	private final static int BROWN_CONTINENT = 1;
	private final static int GREEN_CONTINENT = 2;
	private final static int VIOLET_CONTINENT = 3;
	private final static int BLUE_CONTINENT = 4;
	private final static int RED_CONTINENT = 5;
	
	private final Point[] yellowContinentCoordinates = { 	new Point(104,41), new Point(191,75), new Point(134,126),
															new Point(203,159),new Point(135,191),new Point(139,264),
															new Point(223,250),new Point(71,334), new Point(166,315)  };
	
	private final Point[] brownContinentCoordinates =  { 	new Point(224,321),new Point(318,320),new Point(278,369),
															new Point(342,376),new Point(253,423),new Point(369,431)  };
	
	private final Point[] greenContinentCoordinates =  { 	new Point(399,290),new Point(506,395),new Point(471,285),
															new Point(513,268),new Point(559,277),new Point(612,251),
															new Point(624,312),new Point(720,258),new Point(529,204), 
															new Point(452,176),new Point(499,161),new Point(388,146)  };
	
	private final Point[] violetContinentCoordinates = {	new Point(535,466),new Point(603,443),new Point(664,432),
															new Point(673,379)									 	  };
	
	private final Point[] blueContinentCoordinates =   {	new Point(556,152),new Point(600,185),new Point(671,112),
															new Point(606,106),new Point(554,96),new Point(603,34),
															new Point(505,58)										  };
	
	private final Point[] redContinentCoordinates =    {	new Point(388,62),new Point(320,80),new Point(284,49),
															new Point(246,86)										  };
	
	private Image bg;

	public MapPanel() {
		
		// Set the background
		bg = new ImageIcon("assets/Map/map.jpg").getImage();
		
		//...Then set the window size or call pack...
		Dimension size = new Dimension(bg.getWidth(null), bg.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
		//...Create the GUI and put it in the window...
		createCoordinates();
		createComponents();

	}

	public void createComponents() {
		
		ImageIcon fromImg = new ImageIcon("assets/Buttons/from.png");
		ImageIcon toImg = new ImageIcon("assets/Buttons/to.png");
		ImageIcon infoImg = new ImageIcon("assets/Buttons/info.png");
		ImageIcon troopImg = new ImageIcon("assets/Flags/troops.png");
		
		for(final String s : countryCoordinates.keySet()) {
			
			Point coordinate = countryCoordinates.get(s);
			JButton infoButton = new JButton(infoImg);
			JButton fromButton = new JButton(fromImg);
			JButton toButton = new JButton(toImg);
			JLabel flagLabel = new JLabel();
			JLabel troopsLabel = new JLabel("",troopImg,0);
			CountryHUD cHUD;
			
			infoButton.setLocation(coordinate.x+X_CENTER, coordinate.y+(ELEMENT_SIZE+Y_GAP)*2);
			infoButton.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			infoButton.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					GameManager.getInstance().setInformationCountry(s);
					
					// Graphic Update
					TEGWindow.getInstance().getInfoFrame().setName(s);
					TEGWindow.getInstance().getInfoFrame().setContinent(GameUI.getInstance().getCountryUI(s).getContinent());
					TEGWindow.getInstance().getInfoFrame().setOwner(GameUI.getInstance().getCountryUI(s).getOwner());
					TEGWindow.getInstance().getInfoFrame().setTroopNumber(GameUI.getInstance().getCountryUI(s).getSoldiers());
					
				}
				
			});
			
			fromButton.setLocation(coordinate.x, coordinate.y+ELEMENT_SIZE+Y_GAP);
			fromButton.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			fromButton.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					GameManager.getInstance().setAttacker(s);
					
					// Graphic Update
					TEGWindow.getInstance().getSelectionFrame().graphicUpdate();
					
				}
				
			});
			
			toButton.setLocation(coordinate.x+ELEMENT_SIZE+X_GAP, coordinate.y+ELEMENT_SIZE+Y_GAP);
			toButton.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			toButton.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					GameManager.getInstance().setDefender(s);
					
					// Graphic Update
					TEGWindow.getInstance().getSelectionFrame().graphicUpdate();
					
				}
				
			});
			  
			flagLabel.setLocation(coordinate.x, coordinate.y);
			flagLabel.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			troopsLabel.setLocation(coordinate.x+ELEMENT_SIZE+X_GAP, coordinate.y);
			troopsLabel.setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			troopsLabel.setIconTextGap(-10);
			troopsLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
			
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
		
		String continent = "";
		int continentIndex = NO_CONTINENT;
		int[] toLessen = { 	0,								  yellowContinentCoordinates.length, 	
							brownContinentCoordinates.length, greenContinentCoordinates.length,	
							violetContinentCoordinates.length, blueContinentCoordinates.length	};
		int fix = 0;
		
		for(int i = 0; i < GameUI.getInstance().getCountries().size(); i++) {
			
			if(GameUI.getInstance().getCountries().get(i).getContinent() != continent) {
				
				continent = GameUI.getInstance().getCountries().get(i).getContinent();
				continentIndex++;
				
				fix = 0;
				for(int j = 0; j <= continentIndex ; j++)
					fix += toLessen[j];
			
			}
			
			switch(continentIndex) {
			
				case YELLOW_CONTINENT : 	
					countryCoordinates.put(GameUI.getInstance().getCountries().get(i).getName(),yellowContinentCoordinates[i-fix]);
					break;
				case BROWN_CONTINENT : 	
					countryCoordinates.put(GameUI.getInstance().getCountries().get(i).getName(),brownContinentCoordinates[i-fix]);
					break;
				case GREEN_CONTINENT : 	
					countryCoordinates.put(GameUI.getInstance().getCountries().get(i).getName(),greenContinentCoordinates[i-fix]);
					break;
				case VIOLET_CONTINENT : 	
					countryCoordinates.put(GameUI.getInstance().getCountries().get(i).getName(),violetContinentCoordinates[i-fix]);
					break;
				case BLUE_CONTINENT : 	
					countryCoordinates.put(GameUI.getInstance().getCountries().get(i).getName(),blueContinentCoordinates[i-fix]);
					break;
				case RED_CONTINENT : 	
					countryCoordinates.put(GameUI.getInstance().getCountries().get(i).getName(),redContinentCoordinates[i-fix]);
					break;
					
			}
			
		}
		
	}
	
	// Print flag
	public void changeFlagColor(String countryName, String color) {
		countryHUDs.get(countryName).setFlagIcon(new ImageIcon("assets/Flags/" + color.toLowerCase() + "Flag.png"));
	}
	
	// Print troop number
	public void changeTroopsNumber(String countryName, Integer number) {
		countryHUDs.get(countryName).setTroopsNumber(number);
	}

	@Override
	public void graphicUpdate() {
		
		if(GameUI.getInstance().getDefender() != null && GameUI.getInstance().getAttacker() != null) {
			changeFlagColor(GameUI.getInstance().getDefender(),GameUI.getInstance().getOwnerUI(GameUI.getInstance().getDefender()).getColor());
			changeTroopsNumber(GameUI.getInstance().getDefender(),GameUI.getInstance().getCountryUI(GameUI.getInstance().getDefender()).getSoldiers());
			changeTroopsNumber(GameUI.getInstance().getAttacker(),GameUI.getInstance().getCountryUI(GameUI.getInstance().getAttacker()).getSoldiers());
		}
		
	}

}