package jesse;

import java.awt.*;
import javax.swing.*;

/*
 * @author Jesse
 * @version 0.5
 * @see ReactietestModel
 * @see ReactietestView
 * @see ScorePaneel
 * @see BedieningsPaneel
 */
@SuppressWarnings("serial")
public class Paneel extends JPanel {
	
	private ReactietestModel model;
	private ReactietestView view;
	private ScorePaneel scorePaneel;
	private JPanel bedieningsPaneel;
	
	/*
	 * Maakt instanties aan van de benodigde klassen.
	 */
	public Paneel(){
		
		setLayout( new BorderLayout() );
		
		/*
		 * Instantie van het model;
		 */
		model = new ReactietestModel();
		
		/*
		 * Instantie van de view waaraan het mode wordt meegegeven.
		 */
		view = new ReactietestView( model );
		view.setPreferredSize(new Dimension(800, 600));
		view.setMinimumSize(new Dimension(800, 600));
		
		/*
		 * Instantie van het bedieningspaneel waaraan zowel het model als de view wordt meegegeven.
		 */
		bedieningsPaneel = new BedieningsPaneel( model, view );
		
		// TODO: Moet ook bedieningspaneel meekrijgen?
		/*
		 * Instantie van het scorepaneel waaraan het model wordt meegegeven.
		 */
		scorePaneel = new ScorePaneel( model );
		scorePaneel.setPreferredSize(new Dimension(120, 10));
		scorePaneel.begin();
		
		/*
		 * Voeg de verschillende views toe aan de layout van het paneel
		 */
		add(view, BorderLayout.CENTER);
		add(scorePaneel, BorderLayout.LINE_END);
		add(bedieningsPaneel, BorderLayout.PAGE_END);
		
	}
	
}
