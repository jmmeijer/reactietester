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
		wiskleur = view.getBackground();
		aantalMillisec = 20;

		init();
		
		doorgaan = true;
		pauze = false;
	}
	
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
	
	protected int getRandomInRange(int min, int max){
		return new Random().nextInt(max + 1 -min) + min;
	}

	public double getTeller(){
		return teller;
	}
	
	public void run(){
		
		slaap(vertraging);

		pen.translate(dx, dy);
		pen.setColor(kleur);
		pen.setXORMode(wiskleur);
		
		while(doorgaan){
			//TODO: is dit de juiste plaats voor de teller?
			// Teller dynamisch berekend op basis van verversing per aantal milliseconden.
			teller += (double) aantalMillisec / 1000;
			teken();
			//TODO: vanuit hier naar model sturen?
			slaap(aantalMillisec);
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
		teller = 0.0;
	}
	
	public void reset(){
		init();
		//slaap(vertraging);
		//pauzeVoorbij();
	}
	
	public void pauzeer(){
		teken();
		pauze = true;
		
	}
	
	public synchronized void pauzeVoorbij(){
		
		pauze = false;
	//slaap(vertraging);
		notify();
		
		
	}
	
	public synchronized void controleerPauze() throws InterruptedException {
		
		while( pauze ){
			wait();
		}

	}
	
	public boolean heeftPauze(){
		return pauze;
	}
	
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
