package ClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is used to display information about a specific course to the user using a GUI.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class ViewCourse {
	JFrame frame;

	JPanel textPanel;
	JPanel buttonPanel;
	JPanel combinedPanel;

	/**
	 * Displays text on the GUI (asks user what he/she would like to search)
	 */
	JLabel text;

	JButton backButton;

	MenuGUI menu;
	
	SearchCourse search;

	/**
	 * Creates a new GUI which displays information about the course the user searched for.
	 * 
	 * @param m the main menu GUI
	 * @param s the search course menu GUI which will be set to visible once the 
	 * information displayed is closed.
	 */
	ViewCourse(MenuGUI m, SearchCourse s) {
		search = s;
		search.frame.setVisible(false);
		menu = m;
		frame = new JFrame();
		textPanel = new JPanel();

		// gather input from the socket using MenuGUI socket.
		text = new JLabel("Information about the course retrieved from the socket");

		backButton = new JButton("Back");

		SearchCourseListener listener = new SearchCourseListener();

		backButton.addActionListener(listener);

		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
		textPanel.add(text);
		textPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		buttonPanel = new JPanel();
		buttonPanel.add(backButton);

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
	 * This class handles what happens when a button is clicked. When "Back" is
	 * clicked, the frame closes.
	 * 
	 * @author Garth Slaney, Jiho Kim, Eddie Kim
	 *
	 */
	private class SearchCourseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == backButton) {
				frame.dispose();
				search.frame.setVisible(true);
			}
		}
	}
}
