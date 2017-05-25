package jesse;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.*;

/*
 * ReactietestView-klasse met het gebied waarop de vormen getekent worden. Ook worden de vormen vanuit deze klasse geïnstantieert.
 * @author Jesse
 * @version 0.5
 * @see ReactietestModel
 */
@SuppressWarnings("serial")
public class ReactietestView extends JPanel {
	
	private ReactietestModel model;
	private AbstracteVorm circel, driehoek, vierkant, rechthoek;
	private int grootte;
	private Border rand;

	/*
	 * Constructor van de klasse ReactietestView
	 * @param model het model krijgt objecten en fouten doorgestuurd.
	 */
	public ReactietestView(ReactietestModel model){
		this.model = model;
		grootte = 50;
		rand = BorderFactory.createLineBorder(Color.black);
		//setBorder(opvulling);
		setBorder(rand);
		setBackground( Color.WHITE );
		
		circel = driehoek = rechthoek = vierkant = null;
		
	}

	// TODO verhuizen naar controller.
	/*
	 * maakt een vorm aan als deze nog niet bestaat en start hem.
	 */
	public void startCircel(){
		if( circel == null && getGraphics() != null){
			circel = new Circel(getGraphics(), model, this, grootte, Color.RED);
			circel.start();
		}
	}
	
	/*
	 * maakt een vorm aan als deze nog niet bestaat en start hem.
	 */
	public void startDriehoek(){
		if(driehoek == null && getGraphics() != null){
			driehoek = new Driehoek(getGraphics(), model, this, grootte, grootte, Color.GREEN);
			driehoek.start();
		}
	}
	
	/*
	 * maakt een vorm aan als deze nog niet bestaat en start hem.
	 */
	public void startVierkant(){
		if(vierkant == null && getGraphics() != null){
			vierkant = new Rechthoek(getGraphics(), model, this, grootte, grootte, Color.YELLOW);
			vierkant.start();
		}
	}
	
	/*
	 * maakt een vorm aan als deze nog niet bestaat en start hem.
	 */
	public void startRechthoek(){
		if(rechthoek == null && getGraphics() != null){
			rechthoek = new Rechthoek(getGraphics(), model, this, grootte, grootte-10, Color.BLUE);
			rechthoek.start();
		}
	}
	
	/*
	 * stopt de vorm als deze bestaat.
	 */
	public void stopCircel(){
		if(circel != null){  
			circel.nuStoppen();
			circel = null;
		}
	}
	
	/*
	 * stopt de vorm als deze bestaat.
	 */
	public void stopDriehoek(){
		if(driehoek != null){  
			driehoek.nuStoppen();
			driehoek = null;
		}
	}
	
	/*
	 * stopt de vorm als deze bestaat.
	 */
	public void stopVierkant(){
		if(vierkant != null){  
			vierkant.nuStoppen();
			vierkant = null;
		}
	}
	
	/*
	 * stopt de vorm als deze bestaat.
	 */
	public void stopRechthoek(){
		if(rechthoek != null){  
			rechthoek.nuStoppen();
			rechthoek = null;
		}
	}
	
	/*
	 * Pauzeert de vorm als deze geen pauze heeft en bereken de nieuwe reactietijd, voeg anders een fout toe aan het model.
	 */
	public void klikCircel(){
		if(!circel.heeftPauze()){
			circel.pauzeer();
			//circel = null;
			model.berekenGemiddeldeReactietijd( circel.getTeller() );
		}else{
			model.voegFoutToe();
		}
	}
	
	/*
	 * Pauzeert de vorm als deze geen pauze heeft en bereken de nieuwe reactietijd, voeg anders een fout toe aan het model.
	 */
	public void klikDriehoek(){
		if(!driehoek.heeftPauze()){
			driehoek.pauzeer();
			//driehoek = null;
			model.berekenGemiddeldeReactietijd( driehoek.getTeller() );
			driehoek.reset();
		}else{
			model.voegFoutToe();
		}
	}
	
	/*
	 * Pauzeert de vorm als deze geen pauze heeft en bereken de nieuwe reactietijd, voeg anders een fout toe aan het model.
	 */
	public void klikVierkant(){
		if(!vierkant.heeftPauze()){
			vierkant.pauzeer();
			model.berekenGemiddeldeReactietijd( vierkant.getTeller() );
		}else{
			model.voegFoutToe();
		}
	}
	
	/*
	 * Pauzeert de vorm als deze geen pauze heeft en bereken de nieuwe reactietijd, voeg anders een fout toe aan het model.
	 */
	public void klikRechthoek(){
		if(!rechthoek.heeftPauze()){
			rechthoek.pauzeer();
			model.berekenGemiddeldeReactietijd( rechthoek.getTeller() );
		}else{
			model.voegFoutToe();
		}
	}
	
	/*
	 * Roept alle startfuncties van de vormen aan en geef de vorm objecten door aan het model.
	 */
	public void start(){
		
		startCircel();
		startDriehoek();
		startVierkant();
		startRechthoek();
		
		model.voegVormToe(circel);
		model.voegVormToe(driehoek);
		model.voegVormToe(vierkant);
		model.voegVormToe(rechthoek);
	}
	
	/*
	 * Zet alle vorm-objecten op null
	 */
	public void stop(){
		circel = driehoek = vierkant = rechthoek = null;
		repaint();
		
	}
	
}
