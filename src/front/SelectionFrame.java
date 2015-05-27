package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectionFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 345;
	
	private JPanel panel;
    private JLabel from, to;
    private JButton attack,moveTroop;
    
    public SelectionFrame() {
        super("Selection", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(300,180);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/selection.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(3,2,5,5));
    	
    	from = new JLabel(new ImageIcon("assets/Fields/FromToField.png"));
    	to = new JLabel(new ImageIcon("assets/Fields/FromToField.png"));
    	
    	attack = new JButton("Attack", new ImageIcon("assets/Icons/attack.png"));
    	moveTroop = new JButton("Move", new ImageIcon("assets/Icons/move.png"));
    	
    	panel.add(new JLabel("From:"));
    	panel.add(from);
    	panel.add(new JLabel("To:"));
    	panel.add(to);
    	panel.add(attack);
    	panel.add(moveTroop);
    	
    	add(panel);
    	
    }
    
}
