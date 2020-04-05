import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * Creates the JFrame for creating a new node in the tree with the required fields
 * 
 * @author Eddie Kim
 *
 */
public class NewNodeGUI extends JFrame {

	/**
	 * A new JFrame to display the new node inserting option
	 */
	private JFrame newNode;
	/**
	 * b1 is the button for "Insert" 
	 * b2 is the button for "Return to Main Window"
	 */
	private JButton b1,b2;
	/**
	 * The text field for student ID
	 */
	private JTextField t1;
	/**
	 * The text field for faculty
	 */
	private JTextField t2;
	/**
	 * The text field for student's major
	 */
	private JTextField t3;
	/**
	 * The text field for the student's year of study
	 */
	private JTextField t4;
	/**
	 * The binary search tree used
	 */
	private BinSearchTree theTree;
	
	public NewNodeGUI( BinSearchTree theTree) {
		
		this.theTree = theTree;
		newNode = new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		b1 = new JButton("Insert");
		b2 = new JButton("Return to Main Window");
		
		newNode.setSize(520, 180);
		
		// Used this layout to add the panels to the next line
		newNode.setLayout(new GridLayout(0,1));
		
		// Labels for the different text fields
		JLabel label = new JLabel("Insert a New Node");
		JLabel label2 = new JLabel("Enter the The Student ID");
		JLabel label3 = new JLabel("Enter Faculty");
		JLabel label4 = new JLabel("Enter Student's Major");
		JLabel label5 = new JLabel("Enter Year");
		label.setHorizontalAlignment(JLabel.CENTER); // Horizontally aligns the label to center of the panel
		
		// Text field with specified text size
		t1 = new JTextField(6);
		t2 = new JTextField(12);
		t3 = new JTextField(18);
		t4 = new JTextField(5);
		
		// Adding the top label
		panel.add(label);
		
		// Adding the "Enter the student ID" and "Enter Faculty" text fields
		panel2.add(label2);
		panel2.add(t1);
		panel2.add(label3);
		panel2.add(t2);
		
		// Adding the "Enter Student's Major" and "Enter year" field
		panel3.add(label4);
		panel3.add(t3);
		panel3.add(label5);
		panel3.add(t4);
		
		// Adding the "Insert" and "Return to Main Window" buttons
		panel4.add(b1);
		panel4.add(b2);
		
		// Adding the panels to the JFrame
		newNode.add(panel);
		newNode.add(panel2);
		newNode.add(panel3);
		newNode.add(panel4);
		newNode.setVisible(true);
		
		// Inserts a new node when the "Insert" button is pressed
		b1.addActionListener(( ActionEvent e) -> {
			theTree.insert(t1.getText(), t2.getText(), t3.getText(), t2.getText());
		});
		
		// Closes the JFrame and shows the main display again
		b2.addActionListener(( ActionEvent e) -> {
			newNode.dispatchEvent(new WindowEvent(newNode, WindowEvent.WINDOW_CLOSING));
		});
	}	
}
