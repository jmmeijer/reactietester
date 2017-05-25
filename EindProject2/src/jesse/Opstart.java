package jesse;

import javax.swing.*;

/**
 * De klasse <code>Opstart</code> waarin het een instantie van Paneel wordt geinstantieerd.
 * 
 * @author Jesse
 * @version 0.5
 * @see Paneel
 */

@SuppressWarnings("serial")
public class Opstart extends JFrame {

	/*
	 * main methode voor de applicatie.
	 */
	public static void main( String args[] ) {
		
		/*
		 * Maak een nieuw JFrame aan.
		 */
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Reactietest" );

		/*
		 * Maak een instantie van de Paneel-klasse aan en geef deze door aan het frame.
		 */
		frame.setContentPane( new Paneel() );
		
		// Venstergrootte automatisch instellen op basis van inhoud
		frame.pack();
		
		// Het venster automatisch in het midden van her scherm plaatsen
		frame.setLocationRelativeTo(null);
		
		frame.setVisible( true );
			
	}
	
}
