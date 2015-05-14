package front;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.*;

public class Window extends JFrame {

	private JDesktopPane desktop;
	
	// Create the application
	public Window() {
		
		super("TEG");
		
		//Make the big window be indented 50 pixels from each edge of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width  - inset*2, screenSize.height - inset*2);
 
        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane
        createFrames(); //create windows
        setContentPane(desktop);
        setJMenuBar(createMenuBar());
		
	}
	
	// Launch the application.
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

	//Create a new internal frame.
    protected void createFrames() {
    	
        MapFrame mapFrame = new MapFrame();
        mapFrame.setVisible(true);
        desktop.add(mapFrame);
        
        PlayersFrame playersFrame = new PlayersFrame();
        playersFrame.setVisible(true);
        desktop.add(playersFrame);

    }
    
    private static void createAndShowGUI() {
    	
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        //Create and set up the window.
        Window frame = new Window();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
        frame.setVisible(true);
        
    }
	
	protected JMenuBar createMenuBar() {
		
		JMenuBar menuBar  = new JMenuBar();
		JMenu gameMenu, showMenu, actionMenu, helpMenu;

		// Build the game menu.
		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		gameMenu.add(new JMenuItem("New Game"));
		gameMenu.add(new JMenuItem("Load Game"));
		gameMenu.add(new JMenuItem("Save Game"));
		gameMenu.add(new JMenuItem("End Game"));
		gameMenu.add(new ExitMenuItem());
		
		// Build the show menu.
		showMenu = new JMenu("Show");
		menuBar.add(showMenu);
		showMenu.add(new JMenuItem("Map"));
		showMenu.add(new JMenuItem("Players"));
		showMenu.add(new JMenuItem("Selection"));
		showMenu.add(new JMenuItem("Dice"));
		showMenu.add(new JMenuItem("Objective"));
		showMenu.add(new JMenuItem("My Cards"));
		
		// Build the action menu.
		actionMenu = new JMenu("Action");
		menuBar.add(actionMenu);
		actionMenu.add(new JMenuItem("Add troop"));
		actionMenu.add(new JMenuItem("Attack"));
		actionMenu.add(new JMenuItem("Move troop"));
		actionMenu.add(new JMenuItem("Take card"));
		actionMenu.add(new JMenuItem("End turn"));
		
		// Build the help menu.
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		helpMenu.add(new JMenuItem("Rules"));
		
		return menuBar;
		
	}

}