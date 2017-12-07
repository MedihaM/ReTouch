
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The SelectionPage class builds and runs the frame for the Lesson Selection
 * page
 * 
 * <p>
 * Major Revision History:
 * <p>
 * 2017-11-06 Functioning selection page
 * <p>
 * 2017-11-27 Significantly mproved graphics
 * <p>
 * 2017-12-06 Optimized code
 * 
 * @author Susan Fayez
 * @version 2.0
 * @since 2017-11-06
 */
public class SelectionPage extends javax.swing.JFrame {

	/**
	 * Constructor for SelectionPage This method runs the function that creates
	 * the form for the page
	 */
	public SelectionPage() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * It contains all the information for the design of the form
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		// declaring variables for the contents of the form
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox1.setName("jComboBox1");
		jButton1 = new javax.swing.JButton();
		jButton1.setName("jButton1");
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		// formatting the frame
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Lesson Selection");
		setBackground(new java.awt.Color(0, 204, 204));
		setPreferredSize(new java.awt.Dimension(1200, 800));
		getContentPane().setLayout(null);

		// formatting for the drop down menu
		jComboBox1.setBackground(new java.awt.Color(102, 255, 255));
		jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		jComboBox1.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "all", "asdf", "cnsnts", "hjkl", "vowels" }));
		getContentPane().add(jComboBox1);
		jComboBox1.setBounds(390, 460, 380, 60);

		// formatting for the button
		jButton1.setBackground(new java.awt.Color(102, 255, 255));
		jButton1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
		jButton1.setText("Start");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (IOException ex) {
					Logger.getLogger(SelectionPage.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(520, 560, 110, 70);

		// formatting the labels
		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		jLabel1.setText("Please select a lesson and press start to begin");
		jLabel1.setPreferredSize(new java.awt.Dimension(1200, 800));
		getContentPane().add(jLabel1);
		jLabel1.setBounds(180, 360, 1000, 60);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 78)); // NOI18N
		jLabel2.setText("Welcome to ReTouch!");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(100, 40, 1040, 109);

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel3.setText("Developed By: Abrar Attia, Susan Fayez, and Mediha Munim");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(240, 150, 1530, 80);

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24271360_921911621296126_605811305_o.jpg"))); // NOI18N
		jLabel4.setText("jLabel4");
		jLabel4.setPreferredSize(new java.awt.Dimension(1200, 800));
		getContentPane().add(jLabel4);
		jLabel4.setBounds(0, 0, 1210, 770);

		pack();
	}

	/**
	 * This method determines what happens when the button is pressed
	 * 
	 * @param evt
	 *            stores the status of the button
	 * @throws IOException
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

		// getting the lesson selected from the drop down menu
		String chosen = jComboBox1.getSelectedItem().toString();

		// runs the selected lesson
		switch (chosen) {
		case ("all"):
			UserInput.setUp("all");
			Scheduler.runTimer();
			Lesson.makeJFrame();
			dispose();
			break;
		case ("asdf"):
			UserInput.setUp("asdf");
			Scheduler.runTimer();
			Lesson.makeJFrame();
			dispose();
			break;
		case ("cnsnts"):
			UserInput.setUp("cnsnts");
			Scheduler.runTimer();
			Lesson.makeJFrame();
			dispose();
			break;
		case ("hjkl"):
			UserInput.setUp("hjkl");
			Scheduler.runTimer();
			Lesson.makeJFrame();
			dispose();
			break;
		case ("vowels"):
			UserInput.setUp("vowels");
			Scheduler.runTimer();
			Lesson.makeJFrame();
			dispose();
			break;
		}
	}

	/**
	 * This method runs the application
	 * 
	 * @param args
	 *            the command line arguments (none apply in this case)
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SelectionPage().setVisible(true);
			}
		});
	}

	// declaring the gloabal variables
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
}
