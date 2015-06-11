package front;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.GameManager;
import ui.GameUI;

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
    	
    	int numPlayers = GameUI.getInstance().getPlayers().size();
    	System.out.println(numPlayers);
    	
    	colorPlayers = new JLabel[numPlayers];
    	namePlayers = new JLabel[numPlayers];
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(10,2,5,5));
    	
    	exchanges = new JLabel(new ImageIcon("assets/Fields/playerField.png"));
    	exchanges.setIconTextGap(-128);
    	countries = new JLabel(new ImageIcon("assets/Fields/playerField.png"));
    	countries.setIconTextGap(-128);
    	troopsToAdd = new JLabel(new ImageIcon("assets/Fields/playerField.png"));
    	troopsToAdd.setIconTextGap(-128);
    	
    	takeCard = new JButton("Take Card");
    	takeCard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().takeCard();
			}
		});
    	
    	endTurn = new JButton("End Turn");
    	endTurn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().changeTurn();
			}
		});
    	
    	for(int i = 0 ; i < numPlayers ; i++) {
    		colorPlayers[i] = new JLabel(new ImageIcon("assets/Colors/" + GameUI.getInstance().getPlayers().get(i).getColor() + ".png"));
    		namePlayers[i] = new JLabel(GameUI.getInstance().getPlayers().get(i).getName().toUpperCase(),new ImageIcon("assets/Fields/playerField.png"),0);
    		namePlayers[i].setIconTextGap(-128);
    	}
    	   	
    	for(int i = 0; i < numPlayers ; i++) {
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