package jesse;

import javax.swing.*;

/**
 * De klasse <code>Opstart</code> waarin het een instantie van Paneel wordt geinstantieerd. 
 * @author Jesse
 * @version 5.0
 * @see Paneel
 */

@SuppressWarnings("serial")
public class Opstart extends JFrame {

	public static void main( String args[] ) {
		
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
