package front;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class CardsFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 305, yOffset = 562;
	
	private static final int WINDOW_HEIGHT = 145;
	private static final int WINDOW_WIDTH = 810;
	
	private static final int LAYOUT_ROWS = 5;
	private static final int LAYOUT_COLS = 2;
	private static final int LAYOUT_GAPS = 5;
    
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
    	

    	
    }
    
}
