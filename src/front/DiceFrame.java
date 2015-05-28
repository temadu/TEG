package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1110, yOffset = 5;
	
    private JPanel panel;

    private JLabel[] aDice;
    private JLabel[] dDice;
    
    public DiceFrame() {
        super("Dice", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(175,200);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/dice.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(5,2,5,5));
    	
    	aDice = new JLabel[4];
    	dDice = new JLabel[4];
    	
    	for(int i = 0; i < 4; i++) {
    		
    		aDice[i] = new JLabel(new ImageIcon("assets/Dice/one.png"));
    		dDice[i] = new JLabel(new ImageIcon("assets/Dice/three.png"));
    		
    	}
    	
    	panel.add(new JLabel("    Attacker"));
    	panel.add(new JLabel("    Defender"));
    	
    	for(int i = 0; i < 4; i++) {
    		
    		panel.add(aDice[i]);
    		panel.add(dDice[i]);
    		
    	}
    	
    	add(panel);
    	
    }
    
}
