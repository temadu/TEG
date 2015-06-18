package front;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.GameUI;

public class PlayersFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 5;
	
	private static final int TEXT_GAP = -128;
	private static final int LAYOUT_ROWS = 10;
	private static final int LAYOUT_COLS = 2;
	private static final int LAYOUT_GAPS = 5;
	
	private static final int WINDOW_HEIGHT = 330;
	private static final int WINDOW_WIDTH = 300;
	
	private JPanel panel;
    private JLabel[] colorPlayers;
    private JLabel[] namePlayers;
    private JLabel exchanges, countries, troopsToAdd;
    private JButton takeCard,endTurn;

    public PlayersFrame() {
        super("Players", 
              false, //resizable
              true,  //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

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
    	
    	int numPlayers = GameUI.getInstance().getPlayers().size();
    	
    	colorPlayers = new JLabel[numPlayers];
    	namePlayers = new JLabel[numPlayers];
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	exchanges = new JLabel(new ImageIcon("assets/Fields/playerField.png"));
    	exchanges.setIconTextGap(TEXT_GAP);
    	exchanges.setText("");
    	
    	countries = new JLabel(new ImageIcon("assets/Fields/playerField.png"));
    	countries.setIconTextGap(TEXT_GAP);
    	countries.setText(Integer.toString(GameUI.getInstance().getPlayers().get(GameUI.getInstance().getTurn()).getCountries().size()));
    	
    	troopsToAdd = new JLabel(new ImageIcon("assets/Fields/playerField.png"));
    	troopsToAdd.setIconTextGap(TEXT_GAP);
    	troopsToAdd.setText(Integer.toString(GameUI.getInstance().getTroopsToAdd()));
    	
    	takeCard = new JButton("Take Card");
    	takeCard.addActionListener(new TakeCardActionListener());
    	
    	endTurn = new JButton("End Turn");
    	endTurn.addActionListener(new EndTurnActionListener());
    	
    	for(int i = 0 ; i < numPlayers ; i++) {
    		
    		namePlayers[i] = new JLabel(GameUI.getInstance().getPlayers().get(i).getName().toUpperCase());
    		namePlayers[i].setIconTextGap(TEXT_GAP);
    		namePlayers[i].setHorizontalAlignment(JLabel.CENTER);
    		
    		colorPlayers[i] = new JLabel(new ImageIcon("assets/Colors/" + GameUI.getInstance().getPlayers().get(i).getColor() + ".png"));
    	
    	}
    	   	
    	for(int i = 0; i < numPlayers ; i++) {
    		panel.add(colorPlayers[i]);
    		panel.add(namePlayers[i]);
    	}
    	
    	graphicUpdate();
    	
    	panel.add(new JLabel("Exchanges made:"));
    	panel.add(exchanges);
    	panel.add(new JLabel("Countries:"));
    	panel.add(countries);
    	panel.add(new JLabel("Troops to add:"));
    	panel.add(troopsToAdd);
    	panel.add(takeCard);
    	panel.add(endTurn);
    	
    	add(panel);
    	
    }
    
    public void changeTurn(int turn) {
    	
    	// Indicate whose turn is it
    	for(int i = 0; i < namePlayers.length; i++) {
    		
    		if( i == turn ) {
    			namePlayers[i].setIcon(new ImageIcon("assets/Fields/turnField.png"));
    			namePlayers[i].setForeground(Color.RED);
    		} else {
    			namePlayers[i].setIcon(new ImageIcon("assets/Fields/playerField.png"));
    			namePlayers[i].setForeground(Color.BLACK);
    		}
    		
    	}
    	
    }
    
    // Print troops to add
    public void setTroopsToAdd(Integer number) {
    	troopsToAdd.setText(number.toString());
    }
    
    // Print number of countries
    public void setNumberOfCountries(Integer number) {
    	countries.setText(number.toString());
    }
    
    // Print number of exchanges
    public void setNumberOfExchanges(Integer number) {
    	exchanges.setText(number.toString());
    }

	@Override
	public void graphicUpdate() {
		
    	changeTurn(GameUI.getInstance().getTurn());
    	setTroopsToAdd(GameUI.getInstance().getTroopsToAdd());
    	setNumberOfCountries(GameUI.getInstance().getPlayers().get(GameUI.getInstance().getTurn()).getCountries().size());
    	setNumberOfExchanges(GameUI.getInstance().getPlayers().get(GameUI.getInstance().getTurn()).getCardExchangeNumber());
		
	}
	
}