package front;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int COUNTRY_NMBR = 42;
	
	private JButton[] countryInfoButtons, countryFromButtons, countryToButtons;
	private JLabel[] countryFlags, countryTroops;
	
	private static final int ELEMENT_SIZE = 15;
	private static final int X_GAP = 3, Y_GAP = 3, X_CENTER = ELEMENT_SIZE-X_GAP-2;
	
	private Point[] coordinates = { 	new Point(104,41),	new Point(134,126),	new Point(191,75),
										new Point(135,191),	new Point(203,159),	new Point(71,334),
										new Point(139,264),	new Point(166,315), new Point(223,250),
										new Point(224,321),	new Point(318,320), new Point(278,369),
										new Point(253,423),	new Point(342,376), new Point(369,431),
										new Point(246,86),	new Point(284,49),	new Point(320,80),
										new Point(388,62),	new Point(505,58),	new Point(603,34),
										new Point(554,96),	new Point(606,106), new Point(671,112),
										new Point(556,152),	new Point(600,185), new Point(535,466),
										new Point(603,443), new Point(664,432), new Point(673,379),
										new Point(388,146), new Point(452,176), new Point(499,161),
										new Point(529,204), new Point(399,290), new Point(471,285),
										new Point(513,268), new Point(559,277), new Point(506,395),
										new Point(624,312), new Point(612,251), new Point(720,258) };
	
	private Image bg;

	public MapPanel() {

		bg = new ImageIcon("assets/Map/map.jpg").getImage();
		Dimension size = new Dimension(bg.getWidth(null), bg.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		  
		createComponents();

	}

	public void createComponents() {
		  
		final String[] colors = {"black", "white", "red", "blue", "green", "yellow"};
		ImageIcon[] flagIcons = new ImageIcon[colors.length];
		ImageIcon fromImg = new ImageIcon("assets/Buttons/from.png");
		ImageIcon toImg = new ImageIcon("assets/Buttons/to.png");
		ImageIcon infoImg = new ImageIcon("assets/Buttons/info.png");
		ImageIcon troopImg = new ImageIcon("assets/Flags/troops.png");
	
		for(int i = 0; i < flagIcons.length ; i++) {
			flagIcons[i] = new ImageIcon("assets/Flags/" + colors[i] + "Flag.png");
		}
		  
		countryInfoButtons = new JButton[COUNTRY_NMBR];
		countryFromButtons = new JButton[COUNTRY_NMBR];
		countryToButtons = new JButton[COUNTRY_NMBR];
		countryFlags = new JLabel[COUNTRY_NMBR];
		countryTroops = new JLabel[COUNTRY_NMBR];
		  
		for(int i = 0; i < COUNTRY_NMBR; i++) {
			  
			countryInfoButtons[i] = new JButton(infoImg);
			countryInfoButtons[i].setLocation(coordinates[i].x+X_CENTER, coordinates[i].y+(ELEMENT_SIZE+Y_GAP)*2);
			countryInfoButtons[i].setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			countryFromButtons[i] = new JButton(fromImg);
			countryFromButtons[i].setLocation(coordinates[i].x, coordinates[i].y+ELEMENT_SIZE+Y_GAP);
			countryFromButtons[i].setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			countryToButtons[i] = new JButton(toImg);
			countryToButtons[i].setLocation(coordinates[i].x+ELEMENT_SIZE+X_GAP, coordinates[i].y+ELEMENT_SIZE+Y_GAP);
			countryToButtons[i].setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			  
			countryFlags[i] = new JLabel(flagIcons[2]);
			countryFlags[i].setLocation(coordinates[i].x, coordinates[i].y);
			countryFlags[i].setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			
			countryTroops[i] = new JLabel("10",troopImg,0);
			countryTroops[i].setLocation(coordinates[i].x+ELEMENT_SIZE+X_GAP, coordinates[i].y);
			countryTroops[i].setSize(ELEMENT_SIZE, ELEMENT_SIZE);
			countryTroops[i].setIconTextGap(-13);
			countryTroops[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
			  
			add(countryInfoButtons[i]);
			add(countryFromButtons[i]);
			add(countryToButtons[i]);
			add(countryFlags[i]);
			add(countryTroops[i]);
			  
		}
		  
	}
	    
	public void paintComponent(Graphics g) {

		g.drawImage(bg, 0, 0, null);
		  
	}

}