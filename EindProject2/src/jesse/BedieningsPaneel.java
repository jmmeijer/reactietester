package jesse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BedieningsPaneel extends JPanel {
	private ReactietestModel model;
	private ReactietestView view;
	private JButton startKnop, stopKnop, circelKnop, driehoekKnop, vierkantKnop, rechthoekKnop;

	public BedieningsPaneel(ReactietestModel model,ReactietestView view){
		
		this.model = model;
		this.view = view;
		
		
		startKnop = new JButton("Start");
		stopKnop = new JButton("Stop");
		circelKnop = new JButton("Circel");
		driehoekKnop = new JButton("Driehoek");
		vierkantKnop = new JButton("Vierkant");
		rechthoekKnop = new JButton("Rechthoek");
		
		startKnop.setActionCommand("start");
		stopKnop.setActionCommand("stop");
		circelKnop.setActionCommand("circel");
		driehoekKnop.setActionCommand("driehoek");
		vierkantKnop.setActionCommand("vierkant");
		rechthoekKnop.setActionCommand("rechthoek");
		
		ActionListener handler = new Handler();
		
		startKnop.addActionListener(handler);
		stopKnop.addActionListener(handler);
		circelKnop.addActionListener(handler);
		driehoekKnop.addActionListener(handler);
		vierkantKnop.addActionListener(handler);
		rechthoekKnop.addActionListener(handler);
		
		stopKnop.setEnabled(false);
		stopKnop.setVisible(false);
		circelKnop.setEnabled(false);
		driehoekKnop.setEnabled(false);
		vierkantKnop.setEnabled(false);
		rechthoekKnop.setEnabled(false);
		
		add(startKnop);
		add(stopKnop);
		add(circelKnop);
		add(driehoekKnop);
		add(vierkantKnop);
		add(rechthoekKnop);
		
	}
	
	public void start(){
		
		stopKnop.setEnabled(true);
		stopKnop.setVisible(true);
		startKnop.setEnabled(false);
		startKnop.setVisible(false);
		
		
		circelKnop.setBackground(Color.RED);
		driehoekKnop.setBackground(Color.GREEN);
		vierkantKnop.setBackground(Color.YELLOW);
		rechthoekKnop.setBackground(Color.BLUE);
		rechthoekKnop.setForeground(Color.WHITE);
		
		startKnop.setEnabled(false);
		stopKnop.setEnabled(true);
		circelKnop.setEnabled(true);
		driehoekKnop.setEnabled(true);
		vierkantKnop.setEnabled(true);
		rechthoekKnop.setEnabled(true);
		
		view.start();
	}
	
	public void stop(){
		stopKnop.setEnabled(false);
		stopKnop.setVisible(false);
		startKnop.setEnabled(true);
		startKnop.setVisible(true);
		
		
		circelKnop.setEnabled(false);
		driehoekKnop.setEnabled(false);
		vierkantKnop.setEnabled(false);
		rechthoekKnop.setEnabled(false);
		
		view.stop();
	}
	
	//inwendige actionhandler klasse
	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			switch (command) {
            case "start":  start();
        		break;
            case "stop":  stop();
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
