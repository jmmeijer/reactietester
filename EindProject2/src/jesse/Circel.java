package jesse;

import java.awt.*;

/**
 * Klasse <code>Circel</code>, subklasse van <code>AbstracteVorm</code> maakt gebruik van de interface <code>Vorm</code>.
 * 
 * @author Jesse
 * @version 0.5
 * @see AbstracteVorm
 * @see Vorm
 */

public class Circel extends AbstracteVorm implements Vorm {
	
	private int diameter;

	/*
	 * Constructor
	 * @param g Graphics voor het tekenen van de vorm
	 * @param model om het model te kunnen manipuleren vanuit een Vorm-subklasse
	 * @param view om de positie te bepalen t.o.v. de view
	 * @diameter diameter van de vorm
	 * @kleur kleur van de vorm
	 */
	public Circel(Graphics g, ReactietestModel model, ReactietestView view, int diameter, Color kleur){
		super(g,model,view,diameter,diameter,kleur);
		this.diameter = diameter;
	}

	@Override
	public void teken() {
		pen.setClip(x, y, breedte, hoogte);
		pen.fillOval( x, y, diameter, diameter );
		pen.drawString("circel: " + this.getTeller(),20,20);
	}

}