package jesse;

import java.awt.*;
import javax.swing.*;

public class Paneel extends JPanel {
	
	private ReactietestModel model;
	private ReactietestView view;
	private JPanel scorePaneel, bedieningsPaneel;
	
	public Paneel(){
		
		setLayout( new BorderLayout() );
		
		model = new ReactietestModel();
		
		scorePaneel = new ScorePaneel( model );
		//scorePaneel.setPreferredSize(new Dimension(800, 50));
		
		view = new ReactietestView( model );
		view.setPreferredSize(new Dimension(800, 600));
		
		bedieningsPaneel = new BedieningsPaneel( model, view );
		
		add(view, BorderLayout.CENTER);
		add(scorePaneel, BorderLayout.LINE_END);
		add(bedieningsPaneel, BorderLayout.PAGE_END);
		
	}
	
}
