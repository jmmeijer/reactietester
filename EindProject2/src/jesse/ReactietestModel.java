package jesse;

import java.util.*;

public class ReactietestModel {
	
	public ArrayList<AbstracteVorm> vormen;
	private int aantalKlikken, aantalFouten;
	private double gemiddeldeReactietijd;
	//private double circelTijd;
	
	public ReactietestModel(){
		vormen = new ArrayList<AbstracteVorm>(4);
	}
	
	public void voegVormToe( AbstracteVorm vorm ){
		vormen.add( vorm );
	}
	
	public void berekenGemiddeldeReactietijd(double reactietijd){
		
		gemiddeldeReactietijd = ((gemiddeldeReactietijd * (aantalKlikken-1)) + reactietijd) / aantalKlikken;
		
	}
	
	public double getGemiddeldeReactietijd(){
		return gemiddeldeReactietijd;
	}
	
	public void voegKlikToe(){
		aantalKlikken++;
	}
	
	public void voegFoutToe(){
		aantalFouten++;
	}
	
	public int getAantalFouten(){
		return aantalFouten;
	}

	
	public void reset(){
		
		for( AbstracteVorm vorm : vormen ){
			vorm.nuStoppen();
		}
		
		vormen.clear();
		aantalKlikken = aantalFouten = 0;
		gemiddeldeReactietijd = 0;
	}
	
	
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
	
	public void printScore(){
		for( AbstracteVorm vorm : vormen ){
			System.out.println( "" + vorm );
			double teller = vorm.getTeller();
			System.out.println( "" + teller );
		}
	}

}
