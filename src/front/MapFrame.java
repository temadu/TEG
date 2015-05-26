package front;

import javax.swing.JInternalFrame;

public class MapFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 300, yOffset = 15;
	private static final int WIDTH = 810, HEIGHT = 562;
    
	private BackgroundPanel panel;
    
    public MapFrame() {
        super("Map", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(WIDTH,HEIGHT);

        //Set the window's location.
        setLocation(xOffset,yOffset);
		
    }
	
    private void createComponents() {
    	
    	panel = new BackgroundPanel();
    	
    	add(panel);
    	
    }
    
}
