package jesse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BedieningsPaneel extends JPanel {
	
	private JButton startKnop, circelKnop, driehoekKnop, vierkantKnop, rechthoekKnop;

	public BedieningsPaneel(){
		
		
		
		
		startKnop = new JButton("Start");
		circelKnop = new JButton("Circel");
		driehoekKnop = new JButton("Driehoek");
		vierkantKnop = new JButton("Vierkant");
		rechthoekKnop = new JButton("Rechthoek");
		
		startKnop.setActionCommand("start");
		circelKnop.setActionCommand("circel");
		driehoekKnop.setActionCommand("driehoek");
		vierkantKnop.setActionCommand("vierkant");
		rechthoekKnop.setActionCommand("rechthoek");
		
		ActionListener handler = new Handler();
		
		startKnop.addActionListener(handler);
		circelKnop.addActionListener(handler);
		driehoekKnop.addActionListener(handler);
		vierkantKnop.addActionListener(handler);
		rechthoekKnop.addActionListener(handler);
		
		circelKnop.setEnabled(false);
		driehoekKnop.setEnabled(false);
		vierkantKnop.setEnabled(false);
		rechthoekKnop.setEnabled(false);
		
		add(startKnop);
		add(circelKnop);
		add(driehoekKnop);
		add(vierkantKnop);
		add(rechthoekKnop);
		
	}
	
	public void start(){
		circelKnop.setBackground(Color.RED);
		driehoekKnop.setBackground(Color.GREEN);
		vierkantKnop.setBackground(Color.YELLOW);
		rechthoekKnop.setBackground(Color.BLUE);
		rechthoekKnop.setForeground(Color.WHITE);
		
		startKnop.setEnabled(false);
		circelKnop.setEnabled(true);
		driehoekKnop.setEnabled(true);
		vierkantKnop.setEnabled(true);
		rechthoekKnop.setEnabled(true);
	}
	
	//inwendige actionhandler klasse
	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			switch (command) {
            case "start":  start();
                     break;
            case "circel":  
                     break;
            case "driehoek":  
                     break;
            case "vierkant":  
                     break;
            case "rechthoek":  
                     break;
            default:
                     break;
        }
			
		}
	}
	
}
