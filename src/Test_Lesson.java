
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.assertj.core.api.*;
import org.assertj.core.api.Assertions;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static java.awt.event.KeyEvent.*;
//To run tests: Open in eclipse, have pom.xml file in project & test files in src folder.
/**
 * This class tests the Lesson class.
 * This meets the testing required for the following functional requirements:
 * FREQ 4: The system sets the current character to the first character in the Lesson.
 * FREQ 5: The system moves the current character value to the next one.
 * FREQ 6: The system sets that particular character in the Lesson as completed correctly.
 * FREQ 8: If the user has completed the entire line correctly, they can move on to the next line. 
 * FREQ 14:  If the user has completed the entire Lesson correctly, the Lesson is completed.
 * FREQ 7: Incorrect characters inputed.
 * FREQ 9: Backspace pressed.
 * FREQ 10: Number of mistakes recorded.
 * FREQ 3: Text on separate lines (less than or equal to 7)
 * @author Abrar Attia
 * @version 1.0
 * @since 2017-12-02
 *
 */
public class Test_Lesson{
	
	private FrameFixture window;

	String firstLine = "The brown fox jumps quick over lazy dog but joy a";
	
	@Before
	public void setUp() throws Exception {
		// Runs the selection page and opens the "all" lesson
		SelectionPage frame = GuiActionRunner.execute(() -> new SelectionPage());
		window = new FrameFixture(frame);
		window.show();
		
		Thread.sleep(1500);
		window.comboBox("jComboBox1").selectItem(0);
		Thread.sleep(1500);
		window.button("jButton1").click();
		Thread.sleep(1500);
	
		
	}

	@After
	public void tearDown() throws Exception {
		window.cleanUp();
	}

	// Tests that the correct lesson opened and that the first character is correct
	@Test
	public void lessonSelectionTest1() throws InterruptedException {
		// confirms that the correct lesson is opened
		assertThat(UserInput.stringArray[0]).isEqualTo("The brown fox jumps quick over lazy dog but joy a");
		
		// Tests that the current character is the first character in the line
		assertThat(UserInput.currentCharacter[0]).isEqualTo(0);
		assertThat(UserInput.currentCharacter[1]).isEqualTo(0);

	}
	
	// Tests that user input of first character is recorded and correct
	@Test
	public void lessonSelectionTest2() throws InterruptedException {
		Thread.sleep(1500);
		// Find the new page: the main lesson page
		FrameFixture mainFrame = findFrame("selectedLesson").withTimeout(10000).using(window.robot());
		// Send in the first character in the line
		mainFrame.robot().type(firstLine.charAt(0));
		// Confirms that the current character is now the second character in the first line
		assertThat(UserInput.currentCharacter[1]).isEqualTo(1);
		// confirms that the first character is correct and is recorded.
		assertThat(UserInput.correctCharacters).isEqualTo(1);
		// Send in the second character as incorrect
		mainFrame.robot().type(firstLine.charAt(0));
		mainFrame.pressAndReleaseKeys(VK_BACK_SPACE);
		// Confirm that the character was incorrect
		assertThat(UserInput.incorrectCharacters).isEqualTo(1);
	}

	// Tests that user input of all characters allows movement to next line
	@Test
	public void lessonSelectionTest3() throws InterruptedException {
		Thread.sleep(1500);
		// Find the new page: the main lesson page
		FrameFixture mainFrame = findFrame("selectedLesson").withTimeout(10000).using(window.robot());
		// Send in the first line of characters
		for (int i = 1; i < firstLine.length(); i++){
			mainFrame.robot().type(firstLine.charAt(i));
		}
		
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		Thread.sleep(1000);
		assertThat(UserInput.currentCharacter[0]).isEqualTo(1);
		
	}
	

	// Tests that user input of all characters allows lesson to finish
	@Test
	public void lessonSelectionTest4() throws InterruptedException {
		Thread.sleep(1500);
		// Find the new page: the main lesson page
		FrameFixture mainFrame = findFrame("selectedLesson").withTimeout(10000).using(window.robot());
		String secondLine = "Little Boy fishes very highly anticipated how tan";
		String thirdLine = "lazy dog say alfalfa sophisticated blueberry quiz";
		String fourthLine = "bubble poor quality words Basement o Frickin HeCK";
		String fifthLine = "why so people young FINGERtips neighbour salsa yo";
		String sixthLine = "coordinate toilet black purse i generally stay in";
		String seventhLine = "the fourty dollar range when I purchase nice bows";
		
		for (int i = 0; i < secondLine.length(); i++){
			mainFrame.robot().type(secondLine.charAt(i));
		}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < thirdLine.length(); i++){
			mainFrame.robot().type(thirdLine.charAt(i));
		}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < fourthLine.length(); i++){
			mainFrame.robot().type(fourthLine.charAt(i));
		}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < fifthLine.length(); i++){
			mainFrame.robot().type(fifthLine.charAt(i));
		}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < sixthLine.length(); i++){
			mainFrame.robot().type(sixthLine.charAt(i));
		}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < seventhLine.length(); i++){
			mainFrame.robot().type(seventhLine.charAt(i));
		}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		
		Thread.sleep(1000);
		assertThat(Scheduler.elapsedTime).isNotEqualTo(null);
		assertThat(UserInput.currentCharacter[0]).isEqualTo(7);

	}
}
