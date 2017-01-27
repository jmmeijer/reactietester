package jesse;

import java.awt.*;

public class Driehoek extends AbstracteVorm implements Vorm {
	
	private int[] xPoints, yPoints;
	
	public Driehoek(Graphics g, int x, int y, int breedte, int hoogte, Color kleur){
		super(g,x,y,breedte,hoogte,kleur);
		

	}

	@Override
	public void teken() {
		//pen.setClip(x, y, breedte, hoogte);
		
		// In teken functie omdat het geupdate moet wordens
		xPoints = new int[] {x, (x+breedte/2), (x+breedte)};
		yPoints = new int[] {(y+hoogte), y, (y+hoogte)};
		
		pen.fillPolygon(xPoints, yPoints, 3);
		//Polygon p = new Polygon(xPoints, yPoints, 3);
		//pen.fillPolygon(p);
		
		
	}

}
