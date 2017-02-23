package jesse;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class ScorePaneel extends JPanel implements Runnable{
	private ReactietestModel model;
	private ReactietestView view;
	//TODO: naar model?
	private Thread draad;
	private boolean doorgaan;
	private JLabel[] labels;
	private ArrayList<JLabel> tijdlabels;


	public ScorePaneel(ReactietestModel model, ReactietestView view){
		
		this.model = model;
		
		setLayout( new GridLayout(8,1,10,10) );
		Border border = BorderFactory.createEmptyBorder(20,20,20,20);
		setBorder(border);
		
		labels = new JLabel[8];
		tijdlabels = new ArrayList<JLabel>(4);
		Font font = new Font("SansSerif", Font.BOLD,12);
		Font font2 = new Font("Consolas", Font.BOLD, 12);
		
		//TODO: aanpassen
		labels[0] = new JLabel("Score");
		//TODO: gemiddelde reactietijd
		labels[1] = new JLabel("0");
		//TODO: aantal fouten
		labels[2] = new JLabel("Fouten");
		labels[3] = new JLabel("0");
		
		
		labels[4] = new JLabel("0");
		labels[5] = new JLabel("0");
		labels[6] = new JLabel("0");
		labels[7] = new JLabel("0");
		
		/*
		voegTijdlabelToe();
		voegTijdlabelToe();
		voegTijdlabelToe();
		voegTijdlabelToe();
		*/
		for (JLabel label : labels){
			label.setHorizontalAlignment(JTextField.RIGHT);
			label.setFont(font2);
			add(label);
		}
		/*
		for (JLabel label : tijdlabels){
			label.setHorizontalAlignment(JTextField.RIGHT);
			label.setFont(font2);
			add(label);
		}
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
		// TODO Auto-generated method stub
		
		while(doorgaan){
			//labels[4].setText("test");
			slaap(20);
			
			/*
			if(view.circel == null){
				labels[4].setText("d" + view.circel.getTeller() );
			}
			*/
			
			//System.out.println("test");
			//model.printScore();
			
			
			DecimalFormat dec = new DecimalFormat("0.00");
			
			int i = 4;
			
			for( AbstracteVorm vorm : model.vormen ){
				
				double teller = vorm.getTeller();
				
				//System.out.println( "" + dec.format(teller) );
				
				labels[i].setText( "" + dec.format(teller) );
				
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
