package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayersFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 5;
	
	private JPanel panel;
    private JLabel[] colorPlayers;
    private JLabel[] namePlayers;
    private JLabel exchanges, countries, troopsToAdd;
    private JButton takeCard,endTurn;

    public PlayersFrame() {
        super("Players", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //...Create the GUI and put it in the window...

        //...Then set the window size or call pack...
        setSize(300,330);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/players.png"));
        
        createComponents();
             
    }
    
    private void createComponents() {
    	
    	final String[] colors = {"Black", "White", "Red", "Blue", "Green", "Yellow"};
    	final ImageIcon[] colorIcons = new ImageIcon[colors.length];
    	
    	colorPlayers = new JLabel[6];
    	namePlayers = new JLabel[6];
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(10,2,5,5));
    	
    	exchanges = new JLabel("");
    	countries = new JLabel("");
    	troopsToAdd = new JLabel("");
    	takeCard = new JButton("Take Card");
    	endTurn = new JButton("End Turn");
    	
    	for(int i = 0 ; i < colors.length ; i++) {
    		colorPlayers[i] = new JLabel(new ImageIcon("assets/Colors/" + colors[i] + ".png"));
    	}
    	
    	for(int i = 0; i < colors.length ; i++) {
    		namePlayers[i] = new JLabel("Juan");
    	}
    	
    	for(int i = 0; i < colors.length ; i++) {
    		panel.add(colorPlayers[i]);
    		panel.add(namePlayers[i]);
    	}
    	
    	panel.add(new JLabel("Exchanges:"));
    	panel.add(exchanges);
    	panel.add(new JLabel("Countries:"));
    	panel.add(countries);
    	panel.add(new JLabel("Troops to add:"));
    	panel.add(troopsToAdd);
    	panel.add(takeCard);
    	panel.add(endTurn);
    	
    	add(panel);
    	
    }
	
}