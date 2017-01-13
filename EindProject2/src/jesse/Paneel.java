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
		//scorePaneel.setPreferredSize(new Dimension(800, 50));
		
		view = new ReactietestView( model );
		view.setPreferredSize(new Dimension(100, 150));
		
		bedieningsPaneel = new BedieningsPaneel();
		
		add(view, BorderLayout.CENTER);
		add(scorePaneel, BorderLayout.LINE_END);
		add(bedieningsPaneel, BorderLayout.PAGE_END);
		
	}
	
}
