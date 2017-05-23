package jesse;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class ScorePaneel extends JPanel implements Runnable{
	private ReactietestModel model;
	private Thread draad;
	private boolean doorgaan;
	private JLabel[] labels;
	private ArrayList<JLabel> tijdlabels;


	public ScorePaneel(ReactietestModel model, ReactietestView view){
		
		this.model = model;
		this.view = view;
		
		setLayout( new GridLayout(8,1,10,10) );
		Border border = BorderFactory.createEmptyBorder(20,20,20,20);
		setBorder(border);
		
		labels = new JLabel[4];
		tijdlabels = new ArrayList<JLabel>(4);
		Font font = new Font("Consolas", Font.BOLD, 12);
		
		//TODO: aanpassen
		labels[0] = new JLabel("Score");
		//TODO: gemiddelde reactietijd
		labels[1] = new JLabel("0");
		//TODO: aantal fouten
		labels[2] = new JLabel("Fouten");
		labels[3] = new JLabel("0");
		
		/*
		labels[4] = new JLabel("0");
		labels[5] = new JLabel("0");
		labels[6] = new JLabel("0");
		labels[7] = new JLabel("0");
		*/
		for (JLabel label : labels){
			label.setHorizontalAlignment(JTextField.RIGHT);
			label.setFont(font);
			add(label);
		}
		
		/*
		voegTijdlabelToe();
		voegTijdlabelToe();
		voegTijdlabelToe();
		voegTijdlabelToe();
		*/

		
		draad = new Thread(this);
		doorgaan = true;
	}
	
	public void voegTijdlabelToe(){
		JLabel label = new JLabel("0,00");
		tijdlabels.add(label);
	}

	public void begin(){
		draad.start();
	}
	
	@Override
	public void run() {
		
		Font font = new Font("Consolas", Font.BOLD, 12);
		
		DecimalFormat dec = new DecimalFormat("0.00 ms");
		
		JLabel circelLabel = new JLabel(dec.format(0));
		JLabel driehoekLabel = new JLabel(dec.format(0));
		JLabel vierkantLabel = new JLabel(dec.format(0));
		JLabel rechthoekLabel = new JLabel(dec.format(0));
		
		tijdlabels.add(circelLabel);
		tijdlabels.add(driehoekLabel);
		tijdlabels.add(vierkantLabel);
		tijdlabels.add(rechthoekLabel);
		
		// Voeg labels toe aan Paneel
		for (JLabel label : tijdlabels){
			label.setHorizontalAlignment(JTextField.RIGHT);
			label.setFont(font);
			add(label);
		}
		
		
		
		while(doorgaan){
			
			
			slaap(20);
			
			double gemiddeldeReactietijd = model.getGemiddeldeReactietijd();
			int aantalFouten = model.getAantalFouten();
			
			labels[1].setText( "" + dec.format(gemiddeldeReactietijd) ); 
			labels[3].setText( "" + aantalFouten ); 
			
/*
			if(view.circel != null){
				labels[4].setText("d" + view.circel.getTeller() );
			}
*/	
			
			//model.printScore();
			
			
			

			int i = 0;
			
			//System.out.println( "" + model.vormen.size() );
			
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

			

			/*
			for (JLabel label : labels){
				label.setText("");
			}
			*/

		}
		
	}
	
	public void slaap(int millisec){
		try{
			Thread.sleep(millisec);
		}
		catch(InterruptedException e){
			
		}
	}
	
}
