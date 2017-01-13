package jesse;

import java.awt.*;

public abstract class AbstracteVorm extends Thread implements Vorm {

	protected int x,y;
	protected Color kleur;
	protected boolean doorgaan;
	
	/*
	 * Standaard constructor
	 */
	protected AbstracteVorm(){
		x = y = 0;
		kleur = Color.black;
		doorgaan = true;
	}
	
	
	/*
	 * constuctor met positie- en kleurparameters
	 */
	protected AbstracteVorm(int x, int y, Color kleur){
		this.x = x;
		this.y = y;
		this.kleur = kleur;
	}
	
	public void run(){
		
	}
	
	public void nuStoppen(){
		doorgaan = false;
	}
	
	/*
	 * abstracte methode
	 * @see jesse.Vorm#teken(java.awt.Graphics)
	 */
	public abstract void teken(Graphics g);
	
	
	
}
