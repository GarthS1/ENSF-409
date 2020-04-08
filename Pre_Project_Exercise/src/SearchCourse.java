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
 * This class creates a GUI for searching course. When the user enters a course, another window will pop up either showing the
 * information about the course or that the course was not found.
 * @author jiho
 *
 */
public class SearchCourse {
	JFrame frame;
	
	JPanel textPanel;
	JPanel buttonPanel;
	JPanel combinedPanel;
	
	/**
	 * Displays text on the GUI (asks user what he/she would like to search)
	 */
	JLabel text;
	
	/**
	 * Place where user inputs what course he/she would like to search
	 */
	JTextField textField;
	
	JButton searchButton;
	JButton cancelButton;
	
	MenuGUI menu;
	
	/**
	 * Creates a new GUI which prompts user to enter a course he/she would like to search for.
	 * @param m is the main menu GUI which will be set to visible once the search course ends.
	 */
	SearchCourse(MenuGUI m) {
		menu = m;
		frame = new JFrame();
		textPanel = new JPanel();
		
		text = new JLabel("What course would you like to search?");
		textField = new JTextField();
		
		searchButton = new JButton("Search");
		cancelButton = new JButton("Cancel");
		
		SearchCourseListener listener = new SearchCourseListener();
		
		searchButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
		textPanel.add(text);
		textPanel.add(Box.createVerticalStrut(10));
		textPanel.add(textField);
		textPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		buttonPanel = new JPanel();
		buttonPanel.add(searchButton);
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
	 * This class handles what happens when a button is clicked. When "Cancel" is clicked, the frame closes.
	 * When "Search" is pressed, the program goes through the database and retrieves information and displays the information about
	 * the specified course.
	 * @author jiho
	 *
	 */
	private class SearchCourseListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchButton) {
				 JOptionPane.showConfirmDialog(null, "Help me end my suffering...",
							"suffering", JOptionPane.YES_NO_OPTION);
			} else if(e.getSource() == cancelButton) {
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
	
}
