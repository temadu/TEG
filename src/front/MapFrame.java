package front;

import front.BackgroundPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MapFrame extends JInternalFrame {

    private static final int xOffset = 30, yOffset = 30;
    private BufferedImage image;
    private JDesktopPane desktop;
    private JPanel contentPane;
    
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
//       JLabel picLabel = new JLabel(new ImageIcon(image));
//        add(picLabel);
    
	
		final BackgroundPanel background = new BackgroundPanel(image,
				BackgroundPanel.SCALED, 0.50f, 0.5f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(background);
		setResizable(false);
		background.setLayout(null);
    }
	
}
