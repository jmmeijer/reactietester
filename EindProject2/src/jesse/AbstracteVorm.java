package jesse;

import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.util.*;
//import javax.swing.Timer;

public abstract class AbstracteVorm extends Thread implements Vorm {
	protected Graphics pen;
	protected ReactietestView view;
	protected ReactietestModel model;
	protected int aantalMillisec, breedte, hoogte, x, y, dx, dy, vertraging;
	//TODO: make protected
	protected double teller;
	protected Color kleur, wiskleur;
	protected boolean doorgaan, pauze;
	//protected javax.swing.Timer timer;
	
	/*
	 * Standaard constructor
	 */
	protected AbstracteVorm(Graphics g){
		x = y = 0;
		kleur = Color.BLACK;
		wiskleur = Color.LIGHT_GRAY;
		aantalMillisec = 20;
		doorgaan = true;
		pauze = false;
		
		teller = 0;
		//timer = new javax.swing.Timer( 100, new TimerHandler() );
	}
	
	
	/*
	 * constuctor met positie- en kleurparameters
	 */
	protected AbstracteVorm(Graphics g, ReactietestModel model, ReactietestView view, int breedte, int hoogte, Color kleur){
		this.pen = g;
		this.model = model;
		this.view = view;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.kleur = kleur;
		//wiskleur = Color.LIGHT_GRAY;
		wiskleur = view.getBackground();
		aantalMillisec = 20;
		doorgaan = true;
		pauze = false;
		
		//willekeurige startpositie bepalen
		x = getRandomInRange(0,view.getWidth()-breedte);
		y = getRandomInRange(0,view.getHeight()-hoogte);
		
		//willekeurige snelheid en richting
		dx = getRandomInRange(-aantalMillisec,aantalMillisec);
		dy = getRandomInRange(-aantalMillisec,aantalMillisec);
		
		// willekeurig getal voor vertraging tussen 0 en 10 sec
		vertraging = new Random().nextInt(10000);
		
		teller = 0;
		//timer = new javax.swing.Timer( 100, new TimerHandler() );
	}
	
	protected int getRandomInRange(int min, int max){
		return new Random().nextInt(max + 1 -min) + min;
	}
	/*
	 * Onnodig door format optie op de label
	private static double round(double getal, int decimalen) {
		// aantal decimalen mag niet minder dan 0 zijn
	    if (decimalen < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(getal);
	    bd = bd.setScale(decimalen, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	*/
	public double getTeller(){
		
		//double test = round(teller, 2);
		
		return teller;
	}
	
	public void run(){
		
		slaap(vertraging);

		pen.translate(dx, dy);
		pen.setColor(kleur);
		pen.setXORMode(wiskleur);
		//timer.start();
		
		while(doorgaan){
			//TODO: is dit de juiste plaats voor de teller?
			// Teller dynamisch berekend op basis van verversing per aantal milliseconden.
			teller += (double) aantalMillisec / 1000;
			//System.out.println(teller);
			//pen.setColor(kleur);
			teken();
			//TODO: vanuit hier naar model sturen?
			slaap(aantalMillisec);
			//pen.setColor(wiskleur);
			teken();
			verplaats();
		}
	}
	
	/*
	 * abstracte methode
	 * @see jesse.Vorm#teken(java.awt.Graphics)
	 */
	//public abstract void teken(Graphics g);
	
	// TODO: abstracte functie met graphics of met kleur
	public abstract void teken();
	
	public void nuStoppen(){
		doorgaan = false;
		//timer.stop();
		teller = 0.0;
	}
	
	public void pauzeer(){
		pauze = true;
	}
	
	public synchronized void pauzeVoorbij(){
		pauze = false;
		notify();
	}
	
	public synchronized void controleerPauze() throws InterruptedException {
		while( pauze ){
			wait();
		}
	}
	
	//TODO:Dynamisch randen uitlezen
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
		// TODO: correctie van niet afgeledge baan.
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
	
	public void slaap(int millisec){
		try{
			Thread.sleep(millisec);
			controleerPauze();
		}
		catch(InterruptedException e){
			
		}
	}
	/*
	class TimerHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			teller =+ 0.01;
			
		}
	}
	*/
}
