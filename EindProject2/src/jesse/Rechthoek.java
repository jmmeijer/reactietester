package jesse;

import java.awt.*;

public class Rechthoek extends AbstracteVorm implements Vorm {
	
	public Rechthoek(Graphics g, int x, int y, int breedte, int hoogte, Color kleur){
		super(g,x,y,breedte,hoogte,kleur);
	}

	@Override
	public void teken() {
		//pen.setColor(kleur);
		pen.setClip(x, y, breedte, hoogte);
		pen.fillRect(x,y,breedte, hoogte);
	}

}
