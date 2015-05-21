package front;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import backend.GameBox;
import backend.Player;

public class AddPlayersFrame extends JInternalFrame {

    private static final int xOffset = 90, yOffset = 30;
    private JTextField playerNameField;
    private JPanel panel;
    private JButton addPlayerButton, endButton;
    private JComboBox<String> selectColor;
    private JLabel color, warnings;
    private JLabel[] playerTable;
    private JLabel[] playerColorTable;

    public AddPlayersFrame() {
    	
        super("New Game - Add Players", 
              false, //resizable
              false, //closable
              false, //maximizable
              false);//iconifiable

        //...Create the GUI and put it in the window...
        createComponents();

        //...Then set the window size or call pack...
        setSize(300,300);
        
        //Set the window's location.
        setLocation(xOffset, yOffset);
        
    }

    private void createComponents() {
    	
    	final String[] colors = {"Black", "White", "Red", "Blue", "Green", "Yellow"};
    	final ImageIcon[] colorIcons = new ImageIcon[colors.length];
    	
    	for(int i = 0; i < colors.length ; i++) {
    		colorIcons[i] = new ImageIcon("assets/Colors/" + colors[i] + ".png");
    	}
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(9,2,20,10));
    	
    	playerNameField = new JTextField("Player Name");
    	
    	addPlayerButton = new JButton("Add player!");
    	addPlayerButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				Player p = new Player(playerNameField.getText(),colors[selectColor.getSelectedIndex()]);
				GameManager.getInstance().getGameBox().addPlayer(p);
				
				
				
			}
    		
    	});
    	
    	endButton = new JButton("End");
    	
    	selectColor = new JComboBox<String>(colors);
    	selectColor.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED) {
					color.setIcon(colorIcons[selectColor.getSelectedIndex()]);
				}
				
			}
    		
    	});
    	
    	playerTable = new JLabel[GameBox.MAX_NUM_PLAYERS];
    	for(int i = 0; i < playerTable.length ; i++) {
    		playerTable[i] = new JLabel();
    	}
    	playerColorTable = new JLabel[GameBox.MAX_NUM_PLAYERS];
    	for(int i = 0; i < playerColorTable.length ; i++) {
    		playerColorTable[i] = new JLabel(colorIcons[i]);
    	}
    	
    	warnings = new JLabel();
    	color = new JLabel();
    	color.setIcon(colorIcons[selectColor.getSelectedIndex()]);
    	
    	panel.add(selectColor);
    	panel.add(color);
    	panel.add(playerNameField);
    	panel.add(addPlayerButton);
    	panel.add(warnings);
    	panel.add(endButton);
    	
    	for(int i = 0; i < GameBox.MAX_NUM_PLAYERS ; i++) {
    		panel.add(playerTable[i]);
    		panel.add(playerColorTable[i]);
    	}

    	add(panel);
    	
    }
    
}