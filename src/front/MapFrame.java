package front;

import javax.swing.JInternalFrame;

public class MapFrame extends JInternalFrame {

    private static final int xOffset = 30, yOffset = 30;

    public MapFrame() {
        super("Map", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable

        //...Create the GUI and put it in the window...

        //...Then set the window size or call pack...
        setSize(300,300);

        //Set the window's location.
        setLocation(xOffset, yOffset);
    }
	
}
