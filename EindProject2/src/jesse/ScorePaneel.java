package jesse;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * De klasse <code>ScorePaneel</code> geeft de score en aantal fouten en het aantal milliseconden dat een vorm zichtbaar is weer 
 * @author Jesse
 * @version 5.0
 * @see ReactietestModel
 */

@SuppressWarnings("serial")
public class ScorePaneel extends JPanel implements Runnable{
	private ReactietestModel model;
	private Thread draad;
	private boolean doorgaan;
	private JLabel[] labels;
	private ArrayList<JLabel> tijdlabels;

	/*
	 * Constructor van het scorepaneel
	 * @param model de scores worden uitgelezen vanuit het model
	 */
	public ScorePaneel(ReactietestModel model){
		
		this.model = model;
		
		setLayout( new GridLayout(8,1,10,10) );
		Border border = BorderFactory.createEmptyBorder(20,20,20,20);
		setBorder(border);
		
		labels = new JLabel[4];
		tijdlabels = new ArrayList<JLabel>(4);
		Font font = new Font("Consolas", Font.BOLD, 12);
		
		labels[0] = new JLabel("Score");
		labels[1] = new JLabel("0");
		labels[2] = new JLabel("Fouten");
		labels[3] = new JLabel("0");
		
		for (JLabel label : labels){
			label.setHorizontalAlignment(JTextField.RIGHT);
			label.setFont(font);
			add(label);
		}
		
		voegTijdlabelToe();
		voegTijdlabelToe();
		voegTijdlabelToe();
		voegTijdlabelToe();
		
		// Voeg labels toe aan Paneel
		for (JLabel label : tijdlabels){
			label.setHorizontalAlignment(JTextField.RIGHT);
			label.setFont(font);
			add(label);
		}
		
		draad = new Thread(this);
		doorgaan = true;
	}
	
	/*
	 * Voegt een label toe aan de ArrayList tijdlabels
	 */
	public void voegTijdlabelToe(){
		DecimalFormat dec = new DecimalFormat("0.00 ms");
		JLabel label = new JLabel(dec.format(0));
		tijdlabels.add(label);
	}

	/*
	 * Start de thread
	 */
	public void begin(){
		draad.start();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		DecimalFormat dec = new DecimalFormat("0.00 ms");
		
		while(doorgaan){
			
			slaap(20);
			
			double gemiddeldeReactietijd = model.getGemiddeldeReactietijd();
			int aantalFouten = model.getAantalFouten();
			
			labels[1].setText( "" + dec.format(gemiddeldeReactietijd) ); 
			labels[3].setText( "" + aantalFouten ); 
			
			int i = 0;
			
			for( AbstracteVorm vorm : model.vormen ){
				if(vorm != null){
					double teller = vorm.getTeller();
					//System.out.println( "" + dec.format(teller) );
					JLabel label = tijdlabels.get(i);
					label.setText( "" + dec.format(teller) );
				}else{
					
				}
				i++;
			}

		}
		
	}
	
	/*
	 * Laat de thread slapen gedurende het gegeven aantal milliseconden.
	 * @param millisec het aantal milliseconden dat de thread moet slapen.
	 */
	public void slaap(int millisec){
		try{
			Thread.sleep(millisec);
		}
		catch(InterruptedException e){
			
		}
	}
	
}
