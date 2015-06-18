package front;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import ui.CountryCardUI;
import ui.GameUI;

public class CardsFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 305, yOffset = 562;
	
	private static final int WINDOW_HEIGHT = 145;
	private static final int WINDOW_WIDTH = 810;
    
	private static final int MAX_NUM_CARDS = 5;
	
	private static final int X_GAP = 25;
	private static final int Y_GAP = 4;
	
	private static final int SELECT_BUTTON_WIDTH = 16;
	
	private static final int EXCHANGE_BUTTON_HEIGHT = 75;
	private static final int EXCHANGE_BUTTON_WIDTH = 100;
	
    private JPanel panel;
    
	private JTegCard[] cards;
	private JButton[] cardSelection;
	private JButton performExchange;
	
    public CardsFrame() {
        super("Cards", 
              false, //resizable
              true,  //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        //Set the window's location.
        setLocation(xOffset, yOffset);
		
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/cards.png"));
        
    }
	
    private void createComponents() {
    	
    	// Make the indexs final for the action listener to use them
    	final Integer[] indexs = new Integer[MAX_NUM_CARDS];
    	for(int i = 0 ; i < MAX_NUM_CARDS; i++) {
    		indexs[i] = i;
    	}
    	
    	cards = new JTegCard[MAX_NUM_CARDS];
    	cardSelection = new JButton[MAX_NUM_CARDS];
    	
    	panel = new JPanel();
    	panel.setLayout(null);
    	
    	performExchange = new JButton();
    	performExchange.setSize(EXCHANGE_BUTTON_WIDTH,EXCHANGE_BUTTON_HEIGHT);
    	performExchange.setLocation(X_GAP+(X_GAP+JTegCard.CARD_HEIGHT)*MAX_NUM_CARDS, Y_GAP*4);
    	performExchange.setIcon(new ImageIcon("assets/Icons/exchange.png"));
    	performExchange.addActionListener(new ExchangeCardsActionListener());
    	
    	for(final Integer i : indexs) {
    		
    		cards[i] = new JTegCard();
    		cards[i].setLocation(new Point(X_GAP+(X_GAP+JTegCard.CARD_HEIGHT)*i,Y_GAP));
    		
    		// Card selection buttons
    		cardSelection[i] = new JButton();
    		cardSelection[i].setLocation(X_GAP-SELECT_BUTTON_WIDTH+(X_GAP+JTegCard.CARD_HEIGHT)*i,Y_GAP);
    		cardSelection[i].setSize(SELECT_BUTTON_WIDTH, JTegCard.CARD_HEIGHT);
    		cardSelection[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {
					TEGWindow.getInstance().getCardsFrame().selectCard(indexs[i]);
				}
    			
    		});
    		
    		panel.add(cards[i]);
    		panel.add(cardSelection[i]);
    	}
    	
    	panel.add(performExchange);
    	
    	graphicUpdate();
    	
    	add(panel);
    	
    }
    
    // Print card
    public void setCard(String countryName, String icon, int index) {
    	cards[index].setCountryName(countryName);
    	cards[index].setIcon(icon);
    }
    
    // Print selected card (red border)
    public void selectCard(int index) {
    	if(!cards[index].getIconText().equals("nocard") && !cards[index].isSelected())
    		cards[index].select();
    	else
    		cards[index].deselect();
    }

	@Override
	public void graphicUpdate() {
		
		Iterator<CountryCardUI> itr = GameUI.getInstance().getPlayers().get(GameUI.getInstance().getTurn()).getCards().iterator();
		int i = 0;
		for(; i < MAX_NUM_CARDS && itr.hasNext(); i++) {
			CountryCardUI aux = itr.next();
			String countryName = aux.getCountry();
			String icon = aux.getType().toString();
			setCard(countryName,icon,i);
		}
		for(;i < MAX_NUM_CARDS;i++) {
			setCard("","nocard",i);
		}
		
	}
	
	// Get a list with the player cards names.
	public List<String> getCardsNames() {
		List<String> list = new ArrayList<String>();
		
		for(int i = 0 ; i < cards.length ; i++) {
			if(!cards[i].getIconText().equals("nocard")) {
				if(cards[i].isSelected())
					list.add(cards[i].getCountryName());
			}
		}
		
		return list;
	}
    
}
