package front;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1110, yOffset = 5;
	
	private static final int WINDOW_HEIGHT = 200;
	private static final int WINDOW_WIDTH = 175;
	
	private static final int LAYOUT_ROWS = 5;
	private static final int LAYOUT_COLS = 2;
	private static final int LAYOUT_GAPS = 5;
	
	private static final int MAX_NUM_OF_DICE = 4;
	
    private JPanel panel;

    private JLabel[] attackerDice;
    private JLabel[] defenderDice;
    private JLabel attackerName, defenderName;
    
    
    public DiceFrame() {
        super("Dice", 
              false, //resizable
              true,  //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/dice.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	attackerDice = new JLabel[MAX_NUM_OF_DICE];
    	defenderDice = new JLabel[MAX_NUM_OF_DICE];
    	
    	attackerName = new JLabel();
    	defenderName = new JLabel();
    	
    	panel.add(attackerName);
    	panel.add(defenderName);
    	
    	for(int i = 0; i < MAX_NUM_OF_DICE; i++) {
    		
    		attackerDice[i] = new JLabel();
    		defenderDice[i] = new JLabel();
    		
    		panel.add(attackerDice[i]);
    		panel.add(defenderDice[i]);
    		
    	}
    	
    	add(panel);
    	
    }
    
    // Print attacker name
    public void setAttackerName(String name) {
    	attackerName.setText("    " + name);
    }
    
    // Print defender name
    public void setDefenderName(String name) {
    	defenderName.setText("    " + name);
    }
    
    // Print attacker's dice
    public void setAttackerDice(ArrayList<Integer> attackerDice) {
    	
    	for(int i = 0; i < MAX_NUM_OF_DICE; i++) {
    		
    		Integer number = attackerDice.get(i);
    		if(number == null)
    			this.attackerDice[i].setIcon(null);
    		else
    			this.attackerDice[i].setIcon(new ImageIcon("assets/Dice/" + number.toString() + ".png"));
    		
    	}
    	
    }
    
    // Print defender's dice
    public void setDefenderDice(ArrayList<Integer> defenderDice) {
    	
    	for(int i = 0; i < MAX_NUM_OF_DICE; i++) {
    		
    		Integer number =defenderDice.get(i);
    		if(number == null)
    			this.defenderDice[i].setIcon(null);
    		else
    			this.defenderDice[i].setIcon(new ImageIcon("assets/Dice/" + number.toString() + ".png"));
    		
    	}
    	
    }

	@Override
	public void graphicUpdate() {
		
		
		
	}
    
}
