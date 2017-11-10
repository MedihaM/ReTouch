import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * The DisplayCharacters class alters the display properties (colour, font) of the characters that the 
 * user inputs.
 * @author Mediha Munimm
 * @version 1.0
 * @since 2017-11-06
 *
 */
public class DisplayCharacters {

	/**
	 * This method alters the colour of the character depending on whether a correct or incorrect
	 * character was inputed.
	 * @param g A graphics object.
	 * @throws IOException On input error.
	 */
	public static void displayCharacters(Graphics g) throws IOException {
		String[] s = Parser.getStringArr("asdf"); // move elsewhere so it
													// doesn't repeat?
		g.setFont(new Font("Calibri", Font.PLAIN, 35));
		int cs;
		
		for (int i = 0; i < UserInput.MAX_LINE; i++) {
			for (int j = 0; j + 1 < UserInput.MAX_CHAR; j++) {
				cs = UserInput.getCharStatus(i,j);

				if (cs == 1) { // If character is typed/correct
					g.setColor(Color.GRAY);
				} else if (cs == 0) { // If character is untyped
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.RED); // If the character is
											// typed/incorrect
				}
				g.drawString(s[i].substring(j, j + 1), j * 20 + 100, i * 40 + 100);

			}
		}
	}
	
	/**
	 * This method displays the line indicating the current character.
	 * @param g A graphics object.
	 * @throws IOException On input error.
	 */
	public static void displayCurrentCharacter(Graphics g) throws IOException {
		int[] x = UserInput.getCurrentCharacter();
		g.setFont(new Font("Calibri", Font.PLAIN, 40));
		g.setColor(Color.BLUE);
		g.drawString("|", x[1]*20 + 91, x[0]*40 + 100);
	}


}
