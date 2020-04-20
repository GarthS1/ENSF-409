package ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ServerModel.Course;
import ServerModel.CourseCatalogue;

/**
 * This class creates a GUI for searching course. When the user enters a course, another window will pop up either showing the
 * information about the course or that the course was not found.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
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
	 * This.
	 */
	SearchCourse sc;
	
	/**
	 * Creates a new GUI which prompts user to enter a course he/she would like to search for.
	 * @param m is the main menu GUI which will be set to visible once the search course ends.
	 */
	SearchCourse(MenuGUI m) {
		menu = m;
		sc = this;
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
	 * @author Garth Slaney, Jiho Kim, Eddie Kim
	 *
	 */
	private class SearchCourseListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchButton) {
				String[] temp = textField.getText().split("\\s+");
				
				if(temp.length == 2)
					menu.getOutSocket().println(temp[0].toUpperCase());
					menu.getOutSocket().println(temp[1]);
				
				String course = null;
				try {
					course = menu.getInSocket().readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new ViewCourse(menu, sc, course);
				 
			} else if(e.getSource() == cancelButton) {
				menu.getOutSocket().println("Cancel");
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
	
}
