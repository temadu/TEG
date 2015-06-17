package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 305, yOffset = 5;
	
	private static final int WINDOW_HEIGHT = 200;
	private static final int WINDOW_WIDTH = 175;
	
	private static final int LAYOUT_ROWS = 1;
	private static final int LAYOUT_COLS = 1;
	private static final int LAYOUT_GAPS = 0;
	
    private JPanel panel;
	private JLabel winMessage;
	
	public WinnerFrame() {
        super("Winner", 
              false, //resizable
              false,  //closable
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
        setFrameIcon(new ImageIcon("assets/Icons/clap.png"));
		
    }
	
	public void createComponents() {
		
		panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
		winMessage = new JLabel();
		
		panel.add(winMessage);
		add(panel);
		
	}
	
	@Override
	public void graphicUpdate() {
		// TODO Auto-generated method stub
		
	}
	
}