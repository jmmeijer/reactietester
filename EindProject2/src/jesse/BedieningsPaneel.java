package jesse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * De klasse BedieningsPaneel is verantwoordelijk voor het aanmaken van de knoppen en het afhandelen van events.
 * @author Jesse
 * @version 0.5
 * @see ReactietestModel
 * @see ReactietestView
 */
@SuppressWarnings("serial")
public class BedieningsPaneel extends JPanel {
	private ReactietestModel model;
	private ReactietestView view;
	private JButton startKnop, stopKnop, circelKnop, driehoekKnop, vierkantKnop, rechthoekKnop;

	/*
	 * Constructor Bedieningspaneel
	 * @param model het model moet worden aangepast na interactie met de knoppen.
	 * @view view er worden methodes in de view aangeroepen vanuit deze klasse.
	 */
	public BedieningsPaneel(ReactietestModel model, ReactietestView view){
		
		this.model = model;
		this.view = view;
		
		Border border = BorderFactory.createEmptyBorder(10,10,10,10);
		setBorder(border);
		
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
	
	/*
	 * Bij het starten van het spel worden knoppen in- en uitgeschakeld.
	 */
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
		
		// start de view
		view.start();
	}
	
	/*
	 *  Bij het stoppen van het spel worden knoppen in- en uitgeschakeld.
	 */
	public void stop(){
		stopKnop.setEnabled(false);
		stopKnop.setVisible(false);
		startKnop.setEnabled(true);
		startKnop.setVisible(true);
		
		circelKnop.setBackground(null);
		driehoekKnop.setBackground(null);
		vierkantKnop.setBackground(null);
		rechthoekKnop.setBackground(null);
		rechthoekKnop.setForeground(null);
		
		circelKnop.setEnabled(false);
		driehoekKnop.setEnabled(false);
		vierkantKnop.setEnabled(false);
		rechthoekKnop.setEnabled(false);
		
		// stop de view
		view.stop();
		// reset het model
		model.reset();
	}
	
	
	
	//inwendige actionhandler klasse
	class Handler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			switch (command) {
            case "start":
            	start();
        		break;
            case "stop":
            	stop();
        		break;
            case "circel":
            	model.voegKlikToe();
            	view.klikCircel();
            	//view.stopCircel();
            	//view.startCircel();
        		break;
            case "driehoek":
            	model.voegKlikToe();
            	view.klikDriehoek();
            	//view.stopDriehoek();
            	//view.startDriehoek();
        		break;
            case "vierkant":
            	model.voegKlikToe();
            	view.klikVierkant();
            	//view.stopVierkant();
            	//view.startVierkant();
        		break;
            case "rechthoek":
            	model.voegKlikToe();
            	view.klikRechthoek();
            	//view.stopRechthoek();
            	//view.startRechthoek();
        		break;
            default:
            	break;
			}
			
		}
	}
	
}
