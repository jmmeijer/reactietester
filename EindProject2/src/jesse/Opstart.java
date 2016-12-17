package jesse;

import java.awt.*;

import javax.swing.JFrame;

public class Opstart extends JFrame {

	public static void main( String args[] ) {
		int width = 800;
		int height = 600;
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Reactietest" );

		frame.setContentPane( new Paneel() );
		
		// Venstergrootte automatisch instellen op basis van inhoud
		frame.pack();
		
		// Het venster automatisch in het midden van her scherm plaatsen
		frame.setLocationRelativeTo(null);
		
		frame.setVisible( true );
		
	}
	
}
