package front;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

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
              true, //closable
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
        setFrameIcon(new ImageIcon("assets/Icons/cards.png"));
        
    }
	
    private void createComponents() {
    	
    	final Integer[] indexs = new Integer[MAX_NUM_CARDS];
    	for(int i = 0 ; i < MAX_NUM_CARDS; i++) {
    		indexs[i] = i;
    	}
    	
    	cards = new JTegCard[MAX_NUM_CARDS];
    	cardSelection = new JButton[MAX_NUM_CARDS];
    	
    	panel = new JPanel();
    	panel.setLayout(null);
    	
    	performExchange = new JButton("Exchange");
    	performExchange.setSize(EXCHANGE_BUTTON_WIDTH,EXCHANGE_BUTTON_HEIGHT);
    	performExchange.setLocation(X_GAP+(X_GAP+JTegCard.CARD_HEIGHT)*MAX_NUM_CARDS, Y_GAP*4);
    	
    	for(final Integer i : indexs) {
    		
    		cards[i] = new JTegCard();
    		cards[i].setLocation(new Point(X_GAP+(X_GAP+JTegCard.CARD_HEIGHT)*i,Y_GAP));
    		
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
			String countryName = itr.next().getCountry();
			String icon = itr.next().getType().name();
			setCard(countryName,icon,i);
		}
		for(;i < MAX_NUM_CARDS;i++) {
			setCard("","nocard",i);
		}
		
	}
    
}
