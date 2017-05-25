package jesse;

import java.awt.*;
import java.util.*;

/**
 * De klasse <code>AbstracteVorm</code> met alle gedeelde methodes van de verschillende vormen. 
 * @author Jesse
 * @version 5.0
 * @see Vorm
 */

public abstract class AbstracteVorm extends Thread implements Vorm {
	protected Graphics pen;
	protected ReactietestView view;
	protected ReactietestModel model;
	protected int aantalMillisec, breedte, hoogte, x, y, dx, dy, vertraging;
	protected double teller;
	protected Color kleur, wiskleur;
	protected boolean doorgaan, pauze;
	
	/*
	 * Standaard constructor
	 * @param g Graphics voor het tekenen van de vorm.
	 */
	protected AbstracteVorm(Graphics g){
		x = y = 0;
		kleur = Color.BLACK;
		wiskleur = Color.LIGHT_GRAY;
		aantalMillisec = 20;
		doorgaan = true;
		pauze = false;
		
		teller = 0;
	}
	
	
	/*
	 * Constuctor met positie- en kleurparameters
	 * @param g Graphics voor het tekenen van de vorm
	 * @param model om het model te kunnen manipuleren vanuit een Vorm-subklasse
	 * @param view om de positie te bepalen t.o.v. de view
	 * @breedte breedte van de vorm
	 * @param hoogte hoogte van de vorm
	 * @kleur kleur van de vorm
	 */
	protected AbstracteVorm(Graphics g, ReactietestModel model, ReactietestView view, int breedte, int hoogte, Color kleur){
		this.pen = g;
		this.model = model;
		this.view = view;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.kleur = kleur;
		wiskleur = view.getBackground();
		aantalMillisec = 20;

		init();
		
		doorgaan = true;
		pauze = false;
	}
	
	/*
	 * Initialiseren van de vorm in aparte functie om deze opnieuw te kunnen aanroepen i.p.v. een nieuwe instantie van de klasse aan te maken
	 */
	protected void init(){
		
		//willekeurige startpositie bepalen, verplaatsen om meermaals aan te kunnen roepen?
		x = getRandomInRange(0,view.getWidth()-breedte);
		y = getRandomInRange(0,view.getHeight()-hoogte);
		
		//willekeurige snelheid en richting
		dx = getRandomInRange(-aantalMillisec,aantalMillisec);
		dy = getRandomInRange(-aantalMillisec,aantalMillisec);
		
		// willekeurig getal voor vertraging tussen 0 en 10 sec
		vertraging = new Random().nextInt(10000);
		
		teller = 0;
		
	}
	
	/*
	 * Genereer een willekeurig heel getal binnen een bepaalde range
	 * @min eerste getal van range
	 * @max laatste getal van range
	 */
	protected int getRandomInRange(int min, int max){
		return new Random().nextInt(max + 1 -min) + min;
	}

	/*
	 * Geeft de waarde van teller
	 */
	public double getTeller(){
		return teller;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run(){
		
		slaap(vertraging);

		pen.translate(dx, dy);
		pen.setColor(kleur);
		pen.setXORMode(wiskleur);
		
		while(doorgaan){

			// Teller dynamisch berekend op basis van verversing per aantal milliseconden.
			teller += (double) aantalMillisec / 1000;
			teken();

			slaap(aantalMillisec);
			teken();
			verplaats();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see jesse.Vorm#teken()
	 */
	public abstract void teken();
	
	public void nuStoppen(){
		doorgaan = false;
		teller = 0.0;
	}
	
	/*
	 * Reset de vorm en herinitialeer deze.
	 */
	public void reset(){
		
		if(pauze){
			init();
			slaap(5000);
			pauzeVoorbij();
			
		}
		
		//slaap(vertraging);
		//pauzeVoorbij();
	}
	
	/* 
	 * Zet de vorm op pauze
	 */
	public void pauzeer(){
		teken();
		pauze = true;
		doorgaan = false;
	}
	
	/*
	 * Beëindigt de pauze
	 */
	public synchronized void pauzeVoorbij(){
		
		pauze = false;
		doorgaan = true;
	//slaap(vertraging);
		notify();
		
	}
	
	/* 
	 * Controleert of de vorm nog pauze heeft
	 */
	public synchronized void controleerPauze() throws InterruptedException {
		
		while( pauze ){
			wait();
		}

	}
	
	/* 
	 * Controleert of de vorm nog pauze heeft
	 */
	public boolean heeftPauze(){
		return pauze;
	}
	
	/*
	 * Verplaatst de vorm naar de nieuwe positie en controleert of deze botst met de view
	 */
	public void verplaats() {
		
		//System.out.println( "" + x + " + " + dx + " <= " + view.getWidth() );
		
		if( x + dx <= 0  ) {
			/*
			x = 0;
			int correctie = (int) x + dx;
			System.out.println( "" + correctie );
			x += correctie;
			*/
			dx = -dx;
		}
		else if( x + dx + breedte >= view.getWidth() ) {
			x = view.getWidth() - breedte;
			dx = -dx;
		}
		// TODO: correctie van niet afgelegde baan.
		x += dx;
		if( y + dy <= 0 ) {
			//y = 0;
			dy = -dy;
		}
		else if( y + dy + hoogte >= view.getHeight() ) {
			y = view.getHeight() - hoogte;
			dy = -dy;
		}
		y += dy;
	}
	
	/*
	 * Zet de thread op slaap
	 * @param millisec het aantal milliseconden dat de thread moet slapen
	 */
	public void slaap(int millisec){
		try{
			Thread.sleep(millisec);
			controleerPauze();
		}
		catch(InterruptedException e){
			
		}
	}
	
}
