package ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class for creating a GUI for adding courses into a student's enrolled courses.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class AddCourse {
	MenuGUI menu;
	JFrame frame;
	JPanel userInputPanel;
	JPanel buttonPanel;
	JPanel combinedPanel;
	/**
	 * Place where the user types what course he/she would like to add to his current studies.
	 */
	JTextField textField;
	/**
	 * Text which describes to the user what this GUI does.
	 */
	JLabel text;
	JButton addButton;
	JButton cancelButton;
	
	public AddCourse(MenuGUI m){
		menu = m;
		frame = new JFrame();
		AddCourseListener listener = new AddCourseListener();
		
		userInputPanel = new JPanel();
		textField = new JTextField();
		text = new JLabel("What course would you like to add?");
		
		addButton = new JButton("Add");
		cancelButton = new JButton("Cancel");
		
		addButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.PAGE_AXIS));
		userInputPanel.add(text);
		userInputPanel.add(Box.createVerticalStrut(10));
		userInputPanel.add(textField);
		userInputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);
		
		combinedPanel = new JPanel();
		combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.PAGE_AXIS));
		combinedPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		combinedPanel.add(userInputPanel);
		combinedPanel.add(buttonPanel);
		
		frame.add(combinedPanel);
		frame.pack();
		
		frame.setVisible(true);
	}
	/**
	 * This class handles what happens when a button is clicked. When "Cancel" is clicked, the frame closes.
	 * When "Add" is clicked, the program goes into the database and adds the specified course into the system if possible.
	 * @author Garth Slaney, Jiho Kim, Eddie Kim
	 *
	 */
	private class AddCourseListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == addButton) {
				 int result = JOptionPane.showConfirmDialog(null, "would you like to add this course?",
							"confirmation", JOptionPane.YES_NO_OPTION);
				 if(result == JOptionPane.YES_OPTION) {
					 // send something through socket?
				 }
			} else if(e.getSource() == cancelButton) {
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
}
