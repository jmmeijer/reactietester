package jesse;

import java.awt.*;

public abstract class AbstracteVorm extends Thread implements Vorm {
	protected Graphics pen;
	protected int breedte, hoogte, x, y, dx, dy;
	protected Color kleur, wiskleur;
	protected boolean doorgaan;
	
	/*
	 * Standaard constructor
	 */
	protected AbstracteVorm(Graphics g){
		x = y = 0;
		kleur = Color.BLACK;
		wiskleur = Color.LIGHT_GRAY;
		doorgaan = true;
	}
	
	
	/*
	 * constuctor met positie- en kleurparameters
	 */
	protected AbstracteVorm(Graphics g, int x, int y, int breedte, int hoogte, Color kleur){
		this.pen = g;
		this.x = x;
		this.y = y;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.kleur = kleur;
		wiskleur = Color.LIGHT_GRAY;
		doorgaan = true;
		dx = 3;
		dy = 2;
	}
	
	  public void run(){
		  pen.translate(dx, dy);
		  pen.setColor(kleur);
		  pen.setXORMode(wiskleur);
		  while(doorgaan){
			  teken();
			  slaap(20);
			  teken();
			  verplaats();
		  }
	  }
	
	public void nuStoppen(){
		doorgaan = false;
	}
	
	/*
	 * abstracte methode
	 * @see jesse.Vorm#teken(java.awt.Graphics)
	 */
	//public abstract void teken(Graphics g);
	
	// TODO: abstract met graphics of met kleur
	public abstract void teken();
	
	//TODO:Dynamisch randen uitlezen
	public void verplaats() {
		if( x + dx <= 0 || x + dx + breedte >= 700 ) {
			dx = -dx;
		}
		if( y + dy <= 0 || y + dy + hoogte >= 500 ) {
			dy = -dy;
		}
		x += dx;  y += dy;
	}
	
	public void slaap(int millisec){
		try{
			Thread.sleep(millisec);
		}
		catch(InterruptedException e){}
	}
	
}
