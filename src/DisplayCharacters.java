import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
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
		Graphics2D g2 = (Graphics2D) g;
		String[] s = Parser.getStringArr(); 
		g.setFont(new Font("Monospaced", Font.BOLD, 35));
		int cs;

		Image imgENTER = Toolkit.getDefaultToolkit().getImage("img/ENTER.png");
		Image imgBACK = Toolkit.getDefaultToolkit().getImage("img/BACKSPACE.png");

		for (int i = 0; i < UserInput.MAX_LINE; i++) {
			for (int j = 0; j + 1 < UserInput.MAX_CHAR; j++) {
				cs = UserInput.getCharStatus(i, j);

				if (cs == 1) { // If character is typed/correct

					// If at the end of a line
					if (UserInput.getCurrentCharacter()[1] == 49) {
						// Put the enter button:
						g.setFont(new Font("default", Font.PLAIN, 35));
						g.setColor(Color.BLACK);
						g.drawString("PRESS", Lesson.width / 2 - 58, Lesson.height * 33 / 50);
						g2.drawImage(imgENTER, Lesson.width / 2 - 100, Lesson.height * 2 / 3, null);
						g.setFont(new Font("Monospaced", Font.BOLD, 35));

					}
					g.setColor(Color.GRAY);

				} else if (cs == 0) { // If character is untyped
					g.setColor(Color.BLACK);
				} else {

					// Put the backspace button:
					g.setColor(Color.BLACK);
					g.setFont(new Font("default", Font.PLAIN, 35));
					g.drawString("PRESS", Lesson.width / 2 - 58, Lesson.height * 33 / 50);
					
					g2.drawImage(imgBACK, Lesson.width / 2 - 100, Lesson.height * 2 / 3, null);

					g.setFont(new Font("Monospaced", Font.BOLD, 35));
					g.setColor(Color.RED); // If the character is
					// typed/incorrect

				}

				g.drawString(s[i].substring(j, j + 1), j * 20 + 100, i * 40 + 200);

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
		g.setFont(new Font("Default", Font.PLAIN, 40));
		g.setColor(Color.BLUE);
		g.drawString("|", x[1] * 20 + 93, x[0] * 40 + 200);
	}


}
