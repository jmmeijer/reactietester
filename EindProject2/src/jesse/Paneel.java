package jesse;

import java.awt.*;
import javax.swing.*;

public class Paneel extends JPanel {
	
	private ReactietestModel model;
	private JPanel scorePaneel, view, bedieningsPaneel;
	
	public Paneel(){
		
		setLayout( new BorderLayout() );
		
		model = new ReactietestModel();
		
		scorePaneel = new ScorePaneel( model );
		scorePaneel.setPreferredSize(new Dimension(800, 50));
		
		view = new ReactietestView( model );
		view.setPreferredSize(new Dimension(100, 150));
		
		add(view, BorderLayout.CENTER);
		add(bedieningsPaneel, BorderLayout.PAGE_END);
		
	}
	
}
