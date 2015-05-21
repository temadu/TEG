package front;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import backend.GameBox;
import backend.Player;

public class MapFrame extends JInternalFrame {

    private static final int xOffset = 30, yOffset = 30;
    private JPanel panel;
    private JLabel background;
    
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
        
		setBounds(100, 100, 1024, 720);
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	
    	background = new JLabel(new ImageIcon("assets/map.jpg"));
    	
    	panel.add(background);

    	add(panel);
    	
    }
    
}
