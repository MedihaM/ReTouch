
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * The UserInput class accepts user input and compares all the inputed characters to the characters in the lesson.
 * @author Mediha Munimm
 * @version 1.0
 * @since 2017-11-06
 */
public class UserInput {

	static String[] stringArray = new String[7];

	// position of the current integer [line, char]
	public static int[] currentCharacter = { 0, 0 };

	// number of correctly entered characters
	public static int correctCharacters = 0;

	// number of incorrectly entered characters
	public static int incorrectCharacters = 0;

	// Holds the character of the first incorrect character. If there is none,
	// then it equals -1
	static int firstIncorrectChar = -1;

	static int MAX_LINE = 7; // number of lines
	static int MAX_CHAR = 50; // number of characters per line
	static int[][] charStatus = new int[MAX_LINE][MAX_CHAR];
	// The charStatus = 0 if it is untyped, 1 if it has been typed correctly,
	// 2 if it has been typed incorrectly

	/**
	 * This method manages user input and compares it to the expected character.
	 * 
	 * @param jf A frame component.
	 */
	public static void keyboardInput(JFrame jf) {
		// Add the keyboard input option:
		jf.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent ke) {
				char typedChar = ke.getKeyChar();

				// If backspaced is pressed, go back if it isn't at the end of
				// the line
				if (typedChar == KeyEvent.VK_BACK_SPACE) {
					if (currentCharacter[1] != 0) {
						currentCharacter[1]--;
						setCharStatus(currentCharacter[0], currentCharacter[1], 0);

						// If you erase the first incorrect character,
						// characters
						// won't be marked as incorrect anymore:
						if (currentCharacter[1] == firstIncorrectChar) {
							firstIncorrectChar = -1;
						}
					}
				} else if (currentCharacter[1] == MAX_CHAR - 1) {
					
					// If the end of the line has been reached, move on to the
					// next line when ENTER is pressed
					if (typedChar == KeyEvent.VK_ENTER && firstIncorrectChar < 0) {
						// If the last character of the last line is reached: Indicate that the program is done
						if (currentCharacter[0] == MAX_LINE -1){
							new Results();
							jf.dispose();
							
						}
						currentCharacter[1] = 0;
						currentCharacter[0]++;
					}
				} else if (typedChar == stringArray[currentCharacter[0]].charAt(currentCharacter[1])
						&& firstIncorrectChar < 0) {
					setCharStatus(currentCharacter[0], currentCharacter[1], 1);
					correctCharacters += 1;
					currentCharacter[1] += 1; // next character
				} else {
					// if no previous char was incorrect, indicate this one
					if (firstIncorrectChar < 0)
						firstIncorrectChar = currentCharacter[1];

					setCharStatus(currentCharacter[0], currentCharacter[1], 2);
					incorrectCharacters += 1;
					currentCharacter[1] += 1; // next character
				}

			}

		});

	}

	/**
	 * This method sets the status of the current character.
	 * @param line The current line.
	 * @param c The current character.
	 * @param value The new value of the character.
	 */
	public static void setCharStatus(int line, int c, int value) {
		charStatus[line][c] = value;
	}

	/**
	 * This method retrieves the status of the current character.
	 * @param line The current line.
	 * @param c The current character.
	 * @return int The value of the character.
	 */
	public static int getCharStatus(int line, int c) {
		return charStatus[line][c];
	}

	/**
	 * This method returns the position of the current integer / character.
	 * @return int[] The position of the character.
	 */
	public static int[] getCurrentCharacter() {
		return currentCharacter;
	}
	
	/**
	 * This method initializes the characters.
	 * 
	 * @param lesson The lesson that has been selected by the user parsed into a string.
	 * @throws IOException On input error.
	 */
	public static void setUp(String lesson) throws IOException {
		for (int i = 0; i < MAX_LINE; i++) {
			for (int j = 0; j < MAX_CHAR; j++) {
				setCharStatus(i, j, 0); // Set all characters as
										// untyped
			}
		}
		stringArray = Parser.getStringArr(lesson);
	}

}
