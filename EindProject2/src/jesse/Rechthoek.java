package jesse;

import java.awt.*;

public class Rechthoek extends AbstracteVorm implements Vorm {
	private int breedte, hoogte;
	
	public Rechthoek(int x, int y, Color kleur, int breedte, int hoogte){
		super(x,y,kleur);
		this.breedte = breedte;
		this.hoogte = hoogte;
	}

	@Override
	public void teken(Graphics g) {
		g.setColor(kleur);
		g.setClip(x, y, breedte, hoogte);
		
	}

}
