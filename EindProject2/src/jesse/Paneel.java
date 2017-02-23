package jesse;

import java.awt.*;
import javax.swing.*;

public class Paneel extends JPanel {
	
	private ReactietestModel model;
	private ReactietestView view;
	private ScorePaneel scorePaneel;
	private JPanel bedieningsPaneel;
	
	public Paneel(){
		
		setLayout( new BorderLayout() );
		
		model = new ReactietestModel();
		
		view = new ReactietestView( model );
		view.setPreferredSize(new Dimension(800, 600));
		view.setMinimumSize(new Dimension(800, 600));
		
		bedieningsPaneel = new BedieningsPaneel( model, view );
		
		// TODO: Moet ook bedieningspaneel meekrijgen?
		scorePaneel = new ScorePaneel( model, view );
		//scorePaneel.setPreferredSize(new Dimension(800, 50));
		scorePaneel.begin();
		
		add(view, BorderLayout.CENTER);
		add(scorePaneel, BorderLayout.LINE_END);
		add(bedieningsPaneel, BorderLayout.PAGE_END);
		
	}
	
}
