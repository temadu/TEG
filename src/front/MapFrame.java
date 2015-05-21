package front;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class MapFrame extends JInternalFrame {

    private static final int xOffset = 30, yOffset = 30;
    private BufferedImage image;
    
    public MapFrame() {
        super("Map", 
              true, //resizable
              false, //closable
              false, //maximizable
              false);//iconifiable
        
        //...Then set the window size or call pack...
        setSize(300,300);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        try {                
            image = ImageIO.read(new File("assets/fantasymap.jpg"));
         } catch (IOException ex) { }
	
		final BackgroundPanel background = new BackgroundPanel(image,
				BackgroundPanel.SCALED, 0.50f, 0.5f);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 680);
		setContentPane(background);
		background.setLayout(null);
		
    }
	
}
