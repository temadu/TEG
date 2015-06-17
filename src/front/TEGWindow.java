package front;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TEGWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private BackgroundPanel panel;
	
	// Frames
	private MapFrame mapFrame;
	private PlayersFrame playersFrame;
	private AddPlayersFrame addPlayersFrame;
	private SelectionFrame selectionFrame;
	private DiceFrame diceFrame;
	private InfoFrame infoFrame;
	private SituationFrame situationFrame;
	private ObjectiveFrame objectiveFrame;
	private CardsFrame cardsFrame;
	private ConsoleFrame consoleFrame;
	private WinnerFrame winnerFrame;
	
	private TegMenu menu;
	
	private static final int INSET = 50;
	public static final int WIDTH = 1292;
	public static final int HEIGHT = 768;
	
	// Singleton
	private static TEGWindow instance;
	
	// Create the application
	private TEGWindow() {
		
		super("TEG");
		
        setBounds(INSET, INSET, WIDTH, HEIGHT);
 
        // Set up the GUI.
        panel = new BackgroundPanel();
        add(panel);
        
        menu = new TegMenu();
        setJMenuBar(menu);
        
        // Set the icon
        setIconImage(new ImageIcon("assets/Icons/teg.png").getImage());
		
	}
	
	public static TEGWindow getInstance() {
		
		if(instance == null) {
			instance = new TEGWindow(); 
		}
		return instance;
		
	}
	
	// Launch the application.
	public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

	// Create internal frames.
    private void createFrames() {
    	
    	winnerFrame = new WinnerFrame();
    	panel.add(winnerFrame);
    	
        consoleFrame = new ConsoleFrame();
        panel.add(consoleFrame);
    	
        mapFrame = new MapFrame();
        panel.add(mapFrame);
        
        playersFrame = new PlayersFrame();
        panel.add(playersFrame);
        
        selectionFrame = new SelectionFrame();
        panel.add(selectionFrame);
        
        diceFrame = new DiceFrame();
        panel.add(diceFrame);
        
        infoFrame = new InfoFrame();
        panel.add(infoFrame);
        
        situationFrame = new SituationFrame();
        panel.add(situationFrame);
        
        objectiveFrame = new ObjectiveFrame();
        panel.add(objectiveFrame);
        
        cardsFrame = new CardsFrame();
        panel.add(cardsFrame);
        
    }
    
    // Game starts ..
    public void createNewGameWindow() {
    	
    	addPlayersFrame = new AddPlayersFrame();
        panel.add(addPlayersFrame);
        addPlayersFrame.setVisible(true);
        
    }
    
    private static void createAndShowGUI() {
    	
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        //Create and set up the window.
        TEGWindow.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
        TEGWindow.getInstance().setVisible(true);
        
    }
	
	public void showGameWindows() {
		
		addPlayersFrame.dispose();
		playersFrame.setVisible(true);
		mapFrame.setVisible(true);
		selectionFrame.setVisible(true);
		infoFrame.setVisible(true);
		diceFrame.setVisible(true);
		situationFrame.setVisible(true);
		cardsFrame.setVisible(true);
		
	}
	
	@SuppressWarnings("deprecation")
	public void initiateGameWindows() {
		
		createFrames();
		showGameWindows();
		menu.getShowMenu().enable();
		menu.getActionMenu().enable();
		menu.setLoadGameEnabled(false);
		menu.setEndGameEnabled(true);
	
	}

	public MapFrame getMapFrame() {
		return mapFrame;
	}

	public PlayersFrame getPlayersFrame() {
		return playersFrame;
	}

	public SelectionFrame getSelectionFrame() {
		return selectionFrame;
	}

	public DiceFrame getDiceFrame() {
		return diceFrame;
	}

	public InfoFrame getInfoFrame() {
		return infoFrame;
	}

	public SituationFrame getSituationFrame() {
		return situationFrame;
	}

	public ObjectiveFrame getObjectiveFrame() {
		return objectiveFrame;
	}

	public CardsFrame getCardsFrame() {
		return cardsFrame;
	}

	public AddPlayersFrame getAddPlayersFrame() {
		return addPlayersFrame;
	}

	public ConsoleFrame getConsoleFrame() {
		return consoleFrame;
	}

	public WinnerFrame getWinnerFrame() {
		return winnerFrame;
	}

	public TegMenu getMenu() {
		return menu;
	}
	
	public void disposeAllWindows() {
		
		playersFrame.dispose();
		mapFrame.dispose();
		selectionFrame.dispose();
		infoFrame.dispose();
		diceFrame.dispose();
		situationFrame.dispose();
		cardsFrame.dispose();
		consoleFrame.dispose();
		
	}
	
}
