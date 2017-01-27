package jesse;

import java.awt.*;

import javax.swing.*;

public class ScorePaneel extends JPanel {
	private ReactietestModel model;
	private JLabel[] labels;

	public ScorePaneel(ReactietestModel model){
		
		this.model = model;
		
		setLayout( new GridLayout(3,1) );
		
		labels = new JLabel[2];
		Font font = new Font("SansSerif", Font.BOLD,12);
		
		//TODO: aanpassen
		labels[0]= new JLabel("Score");
		labels[1] = new JLabel("Fouten");
		
		for (JLabel label : labels){
			label.setFont(font);
			add(label);
		}
		
	}
	
}
