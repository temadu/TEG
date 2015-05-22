package front;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import assets.GameManager;

public class TEGWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JDesktopPane desktop;
	
	private MapFrame mapFrame;
	private PlayersFrame playersFrame;
	private AddPlayersFrame addPlayersFrame;
	
	private static TEGWindow instance;
	
	// Create the application
	private TEGWindow() {
		
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
	
	public static TEGWindow getInstance() {
		
		if(instance == null) {
			instance = new TEGWindow(); 
		}
		return instance;
		
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
    private void createFrames() {
    	
        mapFrame = new MapFrame();
        desktop.add(mapFrame);
        
        playersFrame = new PlayersFrame();
        desktop.add(playersFrame);
        
    }
    
    public void createNewGameWindow() {
    
    	if(addPlayersFrame != null)
    		addPlayersFrame.dispose();
    	
    	addPlayersFrame = new AddPlayersFrame();
        addPlayersFrame.setVisible(true);
    	desktop.add(addPlayersFrame);
    	
    }
    
    private static void createAndShowGUI() {
    	
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        //Create and set up the window.
        TEGWindow.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
        TEGWindow.getInstance().setVisible(true);
        
    }
	
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar  = new JMenuBar();
		JMenu gameMenu, showMenu, actionMenu, helpMenu;
		JMenuItem exit, newGame;
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			
				// PREGUNTAR!!!!!!!!!!!!!!!!!! ESTOY MEZCLANDO GRAFICO/MANEJO DE DATOS ???????????????????????
				
				GameManager.getInstance().newGame();
				TEGWindow.getInstance().createNewGameWindow();
				
			}
			
		});

		// Build the game menu.
		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		gameMenu.add(newGame);
		gameMenu.add(new JMenuItem("Load Game"));
		gameMenu.add(new JMenuItem("Save Game"));
		gameMenu.add(new JMenuItem("End Game"));
		gameMenu.add(exit);
		
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
	
	public void showGameWindows() {
		
		addPlayersFrame.dispose();
		playersFrame.setVisible(true);
		mapFrame.setVisible(true);
		
	}
	
}