package jesse;

import java.awt.*;

public class Circel extends AbstracteVorm implements Vorm {
	private int diameter;

	public Circel(int x, int y, Color kleur, int diameter){
		super(x,y,kleur);
		this.diameter = diameter;
	}

	@Override
	public void teken(Graphics g) {
		g.setColor(kleur);
		g.setClip(x, y, diameter, diameter);
		
	}

}
