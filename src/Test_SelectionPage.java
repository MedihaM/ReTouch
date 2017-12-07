/**
 * To run tests: 
 *  - open project in eclipse
 *  - Have test files in src folder
 *  - Have pom.xml file in highest level (project folder)
 *  - Run as JUnit test
 */
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.assertj.core.api.*;
import org.assertj.core.api.Assertions;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
// To run tests: Open in eclipse, have pom.xml file in project & test files in src folder.
/**
 * This class tests the SelectionPage class.
 * This meets the testing required for the following functional requirements:
 * FREQ1: user directed to the beginning of the selected lesson page
 * 
 * @author Abrar Attia
 * @version 1.0
 * @since 2017-12-02
 *
 */
public class Test_SelectionPage{
	
	private FrameFixture window;
	
	@Before
	public void setUp() throws Exception {
		// Runs the selection page and opens the first frame
		SelectionPage frame = GuiActionRunner.execute(() -> new SelectionPage());
		window = new FrameFixture(frame);
		window.show();
		  
	}

	@After
	public void tearDown() throws Exception {
		// Terminates the window
		window.cleanUp();
		
	}

	// FREQ1 in Test Plan: Correct lesson page opens when certain lesson is selected and 'start' button clicked.
	@Test
	public void lessonSelectionTest1() throws InterruptedException {
		Thread.sleep(1500);
		// Selects the third item in the drop down menu; the "cnsnts" lesson
		window.comboBox("jComboBox1").selectItem(2);
		Thread.sleep(1500);
		// Clicks on the START button
		window.button("jButton1").click();
		
		// COnfirms that the lesson has opened and the file has been parsed
		assertThat(UserInput.stringArray).isNotEmpty();
		// Confirms that the first line in the opened lesson matches the selected lesson
		assertThat(UserInput.stringArray[0]).isEqualTo("by Plmg thnks fr th mmrs ty hjsd D SHdbsnMNDs KDJ");
	}
}
