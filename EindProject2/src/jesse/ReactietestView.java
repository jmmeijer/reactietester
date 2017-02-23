package jesse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class ReactietestView extends JPanel {
	
	private ReactietestModel model;
	private AbstracteVorm circel, driehoek, vierkant, rechthoek;
	private int grootte;
	private Border opvulling, rand;

	public ReactietestView(ReactietestModel model){
		this.model = model;
		grootte = 50;
		//opvulling = BorderFactory.createEmptyBorder(100,100,100,100);
		rand = BorderFactory.createLineBorder(Color.black);
		//setBorder(opvulling);
		setBorder(rand);
		setBackground( Color.WHITE );
		
		
		//circel, driehoek, rechthoek, vierkant
		
		
	}
	/*
	public double getTeller(){
		return circel.getTeller();
	}
	*/

	
	public void startCircel(){
		if( circel == null && getGraphics() != null){
			circel = new Circel(getGraphics(), model, this, grootte, Color.RED);
			// geef door aan model
			model.voegVormToe(circel);
			circel.start();
		}
	}
	
	public void startDriehoek(){
		if(driehoek == null && getGraphics() != null){
			driehoek = new Driehoek(getGraphics(), model, this, grootte, grootte, Color.GREEN);
			model.voegVormToe(driehoek);
			driehoek.start();
		}
	}
	
	public void startVierkant(){
		if(vierkant == null && getGraphics() != null){
			vierkant = new Rechthoek(getGraphics(), model, this, grootte, grootte, Color.YELLOW);
			model.voegVormToe(vierkant);
			vierkant.start();
		}
	}
	
	public void startRechthoek(){
		if(rechthoek == null && getGraphics() != null){
			rechthoek = new Rechthoek(getGraphics(), model, this, grootte, grootte-10, Color.BLUE);
			model.voegVormToe(rechthoek);
			rechthoek.start();
		}
	}
	
	public void stopCircel(){
		if(circel != null){  
			circel.nuStoppen();
			circel = null;
		}
	}
	
	public void stopDriehoek(){
		if(driehoek != null){  
			driehoek.nuStoppen();
			driehoek = null;
		}
	}
	
	public void stopVierkant(){
		if(vierkant != null){  
			vierkant.nuStoppen();
			vierkant = null;
		}
	}
	
	public void stopRechthoek(){
		if(rechthoek != null){  
			rechthoek.nuStoppen();
			rechthoek = null;
		}
	}
	
	public void start(){
		startCircel();
		startDriehoek();
		startVierkant();
		startRechthoek();
	}
	
	public void stop(){
		/*
		stopCircel();
		*/
		for( AbstracteVorm vorm : model.vormen ){
			vorm.nuStoppen();
		}
		circel = driehoek = vierkant = rechthoek = null;
	}
	
}
