package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class ExitMenuItem extends JMenuItem  {

	public ExitMenuItem() {
	
		setText("Exit");
		addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
			
		});
		
	}
	
}
