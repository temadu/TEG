package front;

import javax.swing.JInternalFrame;

public class MapFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 30, yOffset = 30;
    
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
        setSize(300,300);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
		setBounds(100, 100, 1030, 710);
		
    }
	
    private void createComponents() {
    	
    	panel = new BackgroundPanel();
    	
    	add(panel);
    	
    }
    
}
