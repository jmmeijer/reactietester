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
		
		circel = driehoek = rechthoek = vierkant = null;
		
	}
	/*
	public double getTeller(){
		return circel.getTeller();
	}
	*/

	// TODO verhuizen naar controller.
	public void startCircel(){
		if( circel == null && getGraphics() != null){
			circel = new Circel(getGraphics(), model, this, grootte, Color.RED);
			// geef door aan model
			//model.voegVormToe(circel);
			circel.start();
		}
	}
	
	public void startDriehoek(){
		if(driehoek == null && getGraphics() != null){
			driehoek = new Driehoek(getGraphics(), model, this, grootte, grootte, Color.GREEN);
			//model.voegVormToe(driehoek);
			driehoek.start();
		}
	}
	
	public void startVierkant(){
		if(vierkant == null && getGraphics() != null){
			vierkant = new Rechthoek(getGraphics(), model, this, grootte, grootte, Color.YELLOW);
			//model.voegVormToe(vierkant);
			vierkant.start();
		}
	}
	
	public void startRechthoek(){
		if(rechthoek == null && getGraphics() != null){
			rechthoek = new Rechthoek(getGraphics(), model, this, grootte, grootte-10, Color.BLUE);
			//model.voegVormToe(rechthoek);
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
	
	public void klikCircel(){
		model.voegKlikToe();
		if(!circel.heeftPauze()){
			circel.pauzeer();
			//circel = null;
			model.berekenGemiddeldeReactietijd( circel.getTeller() );
		}else{
			model.voegFoutToe();
		}
	}
	
	public void klikDriehoek(){
		model.voegKlikToe();
		if(!driehoek.heeftPauze()){
			driehoek.pauzeer();
			//driehoek = null;
			model.berekenGemiddeldeReactietijd( driehoek.getTeller() );
			
			driehoek.reset();
			
			//driehoek.init();
//			//driehoek.slaap(2000);
			//driehoek.pauzeVoorbij();
			
		}else{
			model.voegFoutToe();
			//System.out.println( "" + model.aantalFouten );
		}
	}
	
	public void klikVierkant(){
		model.voegKlikToe();
		if(!vierkant.heeftPauze()){
			vierkant.pauzeer();
			model.berekenGemiddeldeReactietijd( vierkant.getTeller() );
		}else{
			model.voegFoutToe();
		}
	}
	
	public void klikRechthoek(){
		model.voegKlikToe();
		if(!rechthoek.heeftPauze()){
			rechthoek.pauzeer();
			model.berekenGemiddeldeReactietijd( rechthoek.getTeller() );
		}else{
			model.voegFoutToe();
		}
	}
	
	public void start(){
		
		startCircel();
		startDriehoek();
		startVierkant();
		startRechthoek();
		
		this.model.voegVormToe(circel);
		this.model.voegVormToe(driehoek);
		this.model.voegVormToe(vierkant);
		this.model.voegVormToe(rechthoek);
	}
	
	public void stop(){
		/*
		stopCircel();
		*/
		circel = driehoek = vierkant = rechthoek = null;
		repaint();
		
	}
	
}
