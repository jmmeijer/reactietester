package jesse;

import java.util.*;

/*
 * Model voor de Reactietest waarin de vormen, het aantal klikken, fouten en gemiddelde reactietijd worden bijgehouden.
 * @author Jesse
 * @version 0.5
 */

public class ReactietestModel {
	
	public ArrayList<AbstracteVorm> vormen;
	private int aantalKlikken, aantalFouten;
	private double gemiddeldeReactietijd;
	//private double circelTijd;
	
	/*
	 * Constructor van het model
	 */
	public ReactietestModel(){
		vormen = new ArrayList<AbstracteVorm>(4);
	}
	
	/*
	 * Voegt een vorm toe aan de ArrayList vormen.
	 * @param vorm het toe te voegen vorm object.
	 */
	public void voegVormToe( AbstracteVorm vorm ){
		vormen.add( vorm );
	}
	
	/*
	 * Berekent de gem. reactietijd aan de hand van de oude gem. reactietijd, het aantal klikken, en de nieuwe reactietijd.
	 * @param reactietijd de reactietijd van de laatst geklikte vorm,
	 */
	public void berekenGemiddeldeReactietijd(double reactietijd){
		gemiddeldeReactietijd = ((gemiddeldeReactietijd * (aantalKlikken-1)) + reactietijd) / aantalKlikken;
		
	}
	
	/*
	 * Geeft de gem. reactietijd terug.
	 */
	public double getGemiddeldeReactietijd(){
		return gemiddeldeReactietijd;
	}
	
	/*
	 * Voegt een klik toe aan het totaal aantal klikken.
	 */
	public void voegKlikToe(){
		aantalKlikken++;
	}
	
	/*
	 * Voegt een fout toe aan het totaal aantal fouten.
	 */
	public void voegFoutToe(){
		aantalFouten++;
	}
	
	/*
	 * Geeft het aantal fouten terug.
	 */
	public int getAantalFouten(){
		return aantalFouten;
	}

	/*
	 * Reset het model door alle vormen te verwijderen en alle waardes op 0 te zetten.
	 */
	public void reset(){
		
		for( AbstracteVorm vorm : vormen ){
			vorm.nuStoppen();
		}
		
		vormen.clear();
		aantalKlikken = aantalFouten = 0;
		gemiddeldeReactietijd = 0;
	}
	
	
	/*
	 * Controleert of de Circel zichtbaar is.
	 */
	/*
	public boolean isCircelzichtbaar(){
		for( AbstracteVorm vorm : vormen ){

			if ( vorm instanceof Circel) {
				//Circel circel = (Circel) vorm;
				//System.out.println(circel.getTeller());
			  
				return true;
			}else{
				return false;
			}
		}
	}
	*/
	
	/*
	 * Geeft de score weer in de console.
	 */
	public void printScore(){
		for( AbstracteVorm vorm : vormen ){
			System.out.println( "" + vorm );
			double teller = vorm.getTeller();
			System.out.println( "" + teller );
		}
	}

}
