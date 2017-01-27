package jesse;

import java.awt.*;

public class Circel extends AbstracteVorm implements Vorm {
	
	private int diameter;

	public Circel(Graphics g, int x, int y, int diameter, Color kleur){
		super(g,x,y,diameter,diameter,kleur);
		this.diameter = diameter;
	}

	@Override
	public void teken() {
		pen.setClip(x, y, breedte, hoogte);
		pen.fillOval( x, y, diameter, diameter );
	}

}