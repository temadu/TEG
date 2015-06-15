package front;

import java.awt.Color;
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

import assets.GameManager;

public class AddPlayersFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 90, yOffset = 30;
	
	private static final int WINDOW_HEIGHT = 300;
	private static final int WINDOW_WIDTH = 300;
	
	private static final int LAYOUT_ROWS = 9;
	private static final int LAYOUT_COLS = 2;
	private static final int LAYOUT_GAP_X = 20;
	private static final int LAYOUT_GAP_Y = 10;
	
	private static final int TEXT_GAP = -122;
    
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
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        
        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/players.png"));
      
}

    private void createComponents() {
    	
    	final String[] colors = {"Black", "White", "Red", "Blue", "Green", "Yellow"};
    	final ImageIcon[] colorIcons = new ImageIcon[colors.length];
    	
    	for(int i = 0; i < colors.length ; i++) {
    		colorIcons[i] = new ImageIcon("assets/Colors/" + colors[i] + ".png");
    	}
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAP_X,LAYOUT_GAP_Y));
    	
    	playerNameField = new JTextField("Player Name");
    	
    	addPlayerButton = new JButton("Add player!");
    	addPlayerButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				// Add player
				GameManager.getInstance().addPlayer(playerNameField.getText(), colors[selectColor.getSelectedIndex()]);
				
				// Print selected color's name player
				playerTable[selectColor.getSelectedIndex()].setText(playerNameField.getText().toUpperCase());
				
			}
    		
    	});
    	
    	endButton = new JButton("Start!");
    	endButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(GameManager.getInstance().isPlayable()) {
					GameManager.getInstance().startGame();
					TEGWindow.getInstance().initiateGameWindows();
				} else {
					warnings.setText("Not Enough Players!");
				}
			}
    		
    	});
    	
    	selectColor = new JComboBox<String>(colors);
    	selectColor.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED) {
					color.setIcon(colorIcons[selectColor.getSelectedIndex()]);
				}
				
			}
    		
    	});
    	
    	playerTable = new JLabel[GameManager.MAX_NUM_PLAYERS];
    	for(int i = 0; i < playerTable.length ; i++) {
    		playerTable[i] = new JLabel("",new ImageIcon("assets/Fields/addPlayerField.png"),0);
    		playerTable[i].setIconTextGap(TEXT_GAP);
    	}
    	playerColorTable = new JLabel[GameManager.MAX_NUM_PLAYERS];
    	for(int i = 0; i < playerColorTable.length ; i++) {
    		playerColorTable[i] = new JLabel(colorIcons[i]);
    	}
    	
    	warnings = new JLabel();
    	warnings.setForeground(Color.red);
    	color = new JLabel();
    	color.setIcon(colorIcons[selectColor.getSelectedIndex()]);
    	
    	panel.add(selectColor);
    	panel.add(color);
    	panel.add(playerNameField);
    	panel.add(addPlayerButton);
    	panel.add(warnings);
    	panel.add(endButton);
    	
    	for(int i = 0; i < GameManager.MAX_NUM_PLAYERS ; i++) {
    		panel.add(playerTable[i]);
    		panel.add(playerColorTable[i]);
    	}

    	add(panel);
    	
    }
    
}
