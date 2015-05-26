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

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton[] countryInfoButtons, countryFromButtons, countryToButtons;
	private JLabel[] countryFlags, countryTroops;
	
	private static final int ELEMENT_SIZE = 15;
	private static final int X_GAP = 3, Y_GAP = 3, X_CENTER = ELEMENT_SIZE-X_GAP-2;
	
	private Point[] coordinates = { 	new Point(147,64), new Point(187,167), new Point(257,110),
										new Point(218,277), new Point(272,235), new Point(101,459),
										new Point(208,342), new Point(226,430), new Point(340,354),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0),
										new Point(0,0), new Point(0,0), new Point(0,0) };
	
	private Image bg;

	public BackgroundPanel() {

		Image bg = new ImageIcon("assets/Map/map.png").getImage();
		Dimension size = new Dimension(bg.getWidth(null), bg.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		  
		//createComponents();

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
		  
		countryInfoButtons = new JButton[42];
		countryFromButtons = new JButton[42];
		countryToButtons = new JButton[42];
		countryFlags = new JLabel[42];
		countryTroops = new JLabel[42];
		  
		for(int i = 0; i < 9; i++) {
			  
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