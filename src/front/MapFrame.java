package front;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class MapFrame extends JInternalFrame {

    private static final int xOffset = 30, yOffset = 30;
    private BufferedImage image;
    private JDesktopPane desktop;
    
    public MapFrame() {
        super("Map", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable

        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane

        //...Then set the window size or call pack...
        setSize(300,300);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        try {                
            image = ImageIO.read(new File("assets/fantasymap.jpg"));
         } catch (IOException ex) { }
        JLabel picLabel = new JLabel(new ImageIcon(image));
        add(picLabel);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,10,10, null);
        g.drawString("Teo es megahiper homosexual", 100, 100);
        System.out.println("llegue");
    }
	
}
