package jesse;

import java.awt.*;

public class Rechthoek extends AbstracteVorm implements Vorm {
	
	/*
	 * Constructor
	 * @param g Graphics om de vorm te kunnen tekenen
	 * @param model om het model te kunnen manipuleren vanuit een Vorm-subklasse
	 * @param view om de positie te bepalen t.o.v. de view
	 * @breedte breedte van de vorm
	 * @param hoogte hoogte van de vorm
	 * @kleur kleur van de vorm
	 */
	public Rechthoek(Graphics g, ReactietestModel model, ReactietestView view, int breedte, int hoogte, Color kleur){
		super(g,model,view,breedte,hoogte,kleur);
	}

	/*
	 * (non-Javadoc)
	 * @see jesse.AbstracteVorm#teken()
	 */
	@Override
	public void teken() {
		//pen.setColor(kleur);
		pen.setClip(x, y, breedte, hoogte);
		pen.fillRect(x,y,breedte, hoogte);
	}

}
