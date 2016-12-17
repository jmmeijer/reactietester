package jesse;

import javax.swing.*;

public class BedieningsPaneel extends JPanel {
	
	private JButton startKnop, balKnop, driehoekKnop, blokKnop, rechthoekKnop;

	public BedieningsPaneel(){
		
		startKnop = new JButton("Start");
		balKnop = new JButton("Start");
		driehoekKnop = new JButton("Start");
		blokKnop = new JButton("Start");
		rechthoekKnop = new JButton("Start");
		
		add(startKnop);
		add(balKnop);
		add(driehoekKnop);
		add(blokKnop);
		add(rechthoekKnop);
		
	}
	
}
