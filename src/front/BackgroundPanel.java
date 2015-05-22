package front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.Board;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JCheckBox[] countryCheckBoxes;
	private JLabel[] countryLabels;
	private Point[] checkBoxCoordinates = { new Point(147,64), new Point(187,167), new Point(257,110),
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
	private Point[] labelsCoordinates = { 	new Point(134,68), new Point(181,165), new Point(252,115),
											new Point(164,232), new Point(260,184), new Point(88,404),
											new Point(159,350), new Point(203,382), new Point(280,304),
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
	
	private Image img;
	private ImageIcon[] flagIcons;

	  public BackgroundPanel() {
		  
		  img = new ImageIcon("assets/map.jpg").getImage();
		  Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		  setPreferredSize(size);
		  setMinimumSize(size);
		  setMaximumSize(size);
		  setSize(size);
		  setLayout(null);
		  
		  createComponents();

	  }

	  public void createComponents() {
		  
		  final String[] colors = {"black", "white", "red", "blue", "green", "yellow"};
		  flagIcons = new ImageIcon[colors.length];
	
		  for(int i = 0; i < flagIcons.length ; i++) {
			  flagIcons[i] = new ImageIcon("assets/Flags/" + colors[i] + "Flag.png");
		  }
		  
		  countryCheckBoxes = new JCheckBox[Board.COUNTRY_NMBR];
		  countryLabels = new JLabel[Board.COUNTRY_NMBR];
		  
		  for(int i = 0; i < 9; i++) {
			  
			  countryCheckBoxes[i] = new JCheckBox();
			  countryCheckBoxes[i].setLocation(checkBoxCoordinates[i].x, checkBoxCoordinates[i].y);
			  countryCheckBoxes[i].setSize(20, 20);
			  
			  countryLabels[i] = new JLabel("10",flagIcons[2],0);
			  countryLabels[i].setLocation(labelsCoordinates[i].x-10, labelsCoordinates[i].y+26);
			  countryLabels[i].setSize(46, 20);
			  countryLabels[i].setIconTextGap(-17);
			  
			  add(countryCheckBoxes[i]);
			  add(countryLabels[i]);
			  
		  }
		  
	  }
	  
	  public void paintComponent(Graphics g) {
		  
		  g.drawImage(img, 0, 0, null);
		  
	  }

}