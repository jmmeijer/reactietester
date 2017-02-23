package jesse;

import java.awt.*;

public class Rechthoek extends AbstracteVorm implements Vorm {
	
	public Rechthoek(Graphics g, ReactietestModel model, ReactietestView view, int breedte, int hoogte, Color kleur){
		super(g,model,view,breedte,hoogte,kleur);
	}

	@Override
	public void teken() {
		//pen.setColor(kleur);
		pen.setClip(x, y, breedte, hoogte);
		pen.fillRect(x,y,breedte, hoogte);
	}

}
