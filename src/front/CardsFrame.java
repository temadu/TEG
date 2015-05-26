package front;

import javax.swing.JInternalFrame;

public class CardsFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 335, yOffset = 577;
    
    public CardsFrame() {
        super("Cards", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(810,130);

        //Set the window's location.
        setLocation(xOffset, yOffset);
		
    }
	
    private void createComponents() {
    	

    	
    }
    
}
