package ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates a GUI for viewing all courses that a student took in the past.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class ViewAllStudentCourses {
	MenuGUI menu;
	JFrame frame;
	
	JPanel textPanel;
	JPanel buttonPanel;
	JPanel combinedPanel;
	
	/**
	 * List of all courses that the student previously took.
	 */
	JLabel text;
	
	JButton cancelButton;
	
	ViewAllStudentCourses(MenuGUI m){
		menu = m;
		frame = new JFrame();
		
		textPanel = new JPanel();
		
		ViewPastCoursesListener listener = new ViewPastCoursesListener();
		
		//List of all courses student took here
		text = new JLabel("nothing yet");
		
		cancelButton = new JButton("Back");
		cancelButton.addActionListener(listener);
		
		textPanel.add(text);
		textPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		buttonPanel = new JPanel();
		buttonPanel.add(cancelButton);
		
		combinedPanel = new JPanel();
		combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.PAGE_AXIS));
		combinedPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		combinedPanel.add(textPanel);
		combinedPanel.add(buttonPanel);
		
		frame.add(combinedPanel);
		frame.pack();
		
		frame.setVisible(true);
	}

	/**
	 * This class handles what happens when a button is clicked. When "Back" is clicked, the frame closes.
	 * @author jiho
	 *
	 */
	private class ViewPastCoursesListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
}
