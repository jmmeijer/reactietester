package jesse;

import java.awt.Font;

import javax.swing.*;

/**
 * De klasse <code>Opstart</code> waarin het een instantie van Paneel wordt geinstantieerd.
 * 
 * @author Jesse
 * @version 0.5
 * @see Paneel
 */

@SuppressWarnings("serial")
public class Opstart {

	/*
	 * main methode voor de applicatie.
	 */
	public static void main( String args[] ) {
		
		Opstart opstart = new Opstart();
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
			
		opstart.showWelkom();
	}
	
	/*
	 * Genereert een Dialog met uitleg over het spel.
	 */
	public void showWelkom(){
		JTextPane output = new JTextPane();
        output.setEditable(false);
        output.setContentType("text/html");
        // Zorg ervoor dat de font wordt toegepast op html, zie: https://stackoverflow.com/questions/9335604/java-change-font-in-a-jtextpane-containing-html
        output.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        output.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(output);
        
		String s = "<html>"
				+ "<b>Uitleg Reactietest</b><br>"
				+ "Reactietest om je reactiesnelheid mee te testen.<br><br>"
				+ "<b>Speldoel</b><br>"
				+ "Het doel van het spel is om zo snel mogelijk op de juiste knop te klikken bij het verschijnen van een vorm.<br><br>"
				+ "<b>Spelverloop</b>"
				+ "<ol>"
				+ "<li>Op een willekeurig moment verschijnt een vorm</li>"
				+ "<li>Klik op de bijbehorende knop</li>"
				+ "<li>Jouw gemiddelde reactiesnelheid wordt berekend.</li>"
				+ "</ol><br>"
				+ "<b>Veel speelplezier!</b><br><br>"
				+ "</html>";
        output.setText(s);
        // Zet de scrollbalk bovenaan
        output.setCaretPosition(0);
		
		JOptionPane.showMessageDialog(null,
				scrollPane,
                "Welkom!",
                JOptionPane.PLAIN_MESSAGE);
	}
	
}
