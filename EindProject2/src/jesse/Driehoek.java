package jesse;

import java.awt.*;

/*
 * De klasse <code>Driehoek</code> is een subklasse van <code>AbstracteVorm</code> en respresenteert een driehoek
 * @author Jesse
 * @version 0.5
 * @see AbstracteVorm
 * @see Vorm
 */

public class Driehoek extends AbstracteVorm implements Vorm {
	
	private int[] xPoints, yPoints;
	
	/*
	 * Constructor
	 * @param g Graphics voor het tekenen van de vorm
	 * @param model om het model te kunnen manipuleren vanuit een Vorm-subklasse
	 * @param view om de positie te bepalen t.o.v. de view
	 * @breedte breedte van de vorm
	 * @param hoogte hoogte van de vorm
	 * @kleur kleur van de vorm
	 */
	public Driehoek(Graphics g, ReactietestModel model, ReactietestView view, int breedte, int hoogte, Color kleur){
		super(g,model,view,breedte,hoogte,kleur);
	}
	
	/*
	 * (non-Javadoc)
	 * @see jesse.AbstracteVorm#teken()
	 */
	@Override
	public void teken() {
		//pen.setClip(x, y, breedte, hoogte);
		
		// In teken functie omdat het geupdate moet wordens
		xPoints = new int[] {x, (x+breedte/2), (x+breedte)};
		yPoints = new int[] {(y+hoogte), y, (y+hoogte)};
		
		pen.fillPolygon(xPoints, yPoints, 3);
		
	}

}
