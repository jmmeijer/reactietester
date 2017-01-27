package jesse;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.*;

public class ReactietestView extends JPanel {
	
	private ReactietestModel model;
	private AbstracteVorm circel, driehoek, rechthoek, vierkant;
	private Border opvulling, rand;

	public ReactietestView(ReactietestModel model){
		this.model = model;
		
		opvulling = BorderFactory.createEmptyBorder(100,100,100,100);
		rand = BorderFactory.createLineBorder(Color.black);
		setBorder(opvulling);
		setBorder(rand);
		
	}
	
	public void start(){
		if(circel == null){  
			circel = new Circel(getGraphics(), 101, 101, 50, Color.RED);
			circel.start();
		}
		if(driehoek == null){  
			driehoek = new Driehoek(getGraphics(), 10, 10, 50, 50, Color.GREEN);
			driehoek.start();
		}
		
		if(vierkant == null){  
			vierkant = new Rechthoek(getGraphics(), 60, 20, 50, 50, Color.YELLOW);
			vierkant.start();
		}
		if(rechthoek == null){  
			rechthoek = new Rechthoek(getGraphics(), 300, 200, 50, 50, Color.BLUE);
			rechthoek.start();
		}

		
	}
	
	public void stop(){
		if(circel != null){  
			circel.nuStoppen();
			circel = null;
		}
		if(driehoek != null){  
			driehoek.nuStoppen();
			driehoek = null;
		}
		if(vierkant != null){  
			vierkant.nuStoppen();
			vierkant = null;
		}
		if(rechthoek != null){  
			rechthoek.nuStoppen();
			rechthoek = null;
		}

	}
	
}
