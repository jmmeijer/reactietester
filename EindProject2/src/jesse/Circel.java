package jesse;

import java.awt.*;

public class Circel extends AbstracteVorm implements Vorm {
	
	private int diameter;

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