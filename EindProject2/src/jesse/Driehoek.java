package jesse;

import java.awt.*;

public class Driehoek extends AbstracteVorm implements Vorm {
	private int breedte, hoogte;
	private int[] xPoints, yPoints;
	
	public Driehoek(int x, int y, Color kleur, int breedte, int hoogte){
		super(x,y,kleur);
		this.breedte = breedte;
		this.hoogte = hoogte;
		
		
		
		xPoints = new int[] {hoogte, 0, hoogte};
		yPoints = new int[] {0, breedte/2, breedte};
		
		
	}

	@Override
	public void teken(Graphics g) {
		g.setColor(kleur);
		g.setClip(x, y, breedte, hoogte);
		
		//drawPolygon(xPoints, yPoints, 3);
		
	}

}
