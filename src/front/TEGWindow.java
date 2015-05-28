package front;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TEGWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private BackgroundPanel panel;
	
	private MapFrame mapFrame;
	private PlayersFrame playersFrame;
	private AddPlayersFrame addPlayersFrame;
	private SelectionFrame selectionFrame;
	private DiceFrame diceFrame;
	private InfoFrame infoFrame;
	private SituationFrame situationFrame;
	private ObjectiveFrame objectiveFrame;
	private CardsFrame cardsFrame;
	
	private static final int INSET = 50;
	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;
	
	private static TEGWindow instance;
	
	// Create the application
	private TEGWindow() {
		
		super("TEG");
		
        setBounds(INSET, INSET, WIDTH, HEIGHT);
 
        //Set up the GUI.
        panel = new BackgroundPanel(); //a specialized layered pane
        add(panel);
        createFrames(); //create windows
        setJMenuBar(new TegMenu());
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
    
    public void createNewGameWindow() {
    
    	if(addPlayersFrame != null)
    		addPlayersFrame.dispose();
    	
    	addPlayersFrame = new AddPlayersFrame();
    	addPlayersFrame.setVisible(true);
    	panel.add(addPlayersFrame);
    	addPlayersFrame.setFocusable(true);
    	addPlayersFrame.grabFocus();
    	addPlayersFrame.getContentPane().setFocusable(true);
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
		objectiveFrame.setVisible(true);
		cardsFrame.setVisible(true);
		
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
	
}