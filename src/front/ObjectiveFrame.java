package front;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.GameUI;

public class ObjectiveFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 535;
	
	private static final int TEXT_GAP = -285;
	private static final int TEXT_SIZE = 17;
	private static final String TEXT_FONT = "Verdana";
	
	private static final int LAYOUT_ROWS = 1;
	private static final int LAYOUT_COLS = 1;
	private static final int LAYOUT_GAPS = 0;
	
	private static final int WINDOW_HEIGHT = 172;
	private static final int WINDOW_WIDTH = 300;
	
    private JPanel panel;
    private JLabel objective;
    
    public ObjectiveFrame() {
        super("Objective", 
              false, //resizable
              true, //closable
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
        setFrameIcon(new ImageIcon("assets/Icons/objective.png"));
        
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	objective = new JLabel(new ImageIcon("assets/Fields/ObjectiveField.png"));
    	objective.setIconTextGap(TEXT_GAP);
    	objective.setFont(new Font(TEXT_FONT,Font.ITALIC,TEXT_SIZE));
    	objective.setVerticalTextPosition(JLabel.TOP);

    	graphicUpdate();
    	
    	panel.add(objective);
    	
    	add(panel);
    	
    }
    
    // Print objective (between <html></html> to separate the text in lines)
    public void setObjective(String objective) {
    	this.objective.setText("<html>" + objective + "</html>");
    }

	@Override
	public void graphicUpdate() {
		
		setObjective(GameUI.getInstance().getPlayers().get(GameUI.getInstance().getTurn()).getObjective());
		this.setVisible(false);
		
	}
    
    
    
}
