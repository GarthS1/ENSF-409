package ClientView;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class used for implementing GUI (Graphic user interface) to take input from the user and make the program more
 * user friendly.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class MenuGUI {
	JFrame frame;
	
	/**
	 * List of all the buttons used in the main menu.
	 */
	JButton searchCourseButton, addCourseButton, removeCourseButton, viewAllCatalogueButton, viewAllStudentCoursesButton, quitButton;
	private JPanel panel;
	private Socket outSocket;
	
	
	/**
	 * Creates a GUI for the main menu for the convenience of the user.
	 */
	public MenuGUI(Socket out){
		outSocket = out;
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		MyListener listener = new MyListener(this);
		
		searchCourseButton = new JButton("Search catalogue courses");
		addCourseButton = new JButton("Add Courses to student courses");
		removeCourseButton = new JButton("Remove course from student courses");
		viewAllCatalogueButton  = new JButton("View all courses in catalogue");
		viewAllStudentCoursesButton = new JButton("View all courses taken by the student");
		quitButton = new JButton("QUIT");
		
		searchCourseButton.addActionListener(listener);
		addCourseButton.addActionListener(listener);
		removeCourseButton.addActionListener(listener);
		viewAllCatalogueButton.addActionListener(listener);
		viewAllStudentCoursesButton.addActionListener(listener);
		quitButton.addActionListener(listener);
		
		panel.add(searchCourseButton);
		panel.add(Box.createVerticalStrut(10));
		panel.add(addCourseButton);
		panel.add(Box.createVerticalStrut(10));
		panel.add(removeCourseButton);
		panel.add(Box.createVerticalStrut(10));
		panel.add(viewAllCatalogueButton);
		panel.add(Box.createVerticalStrut(10));
		panel.add(viewAllStudentCoursesButton);
		panel.add(Box.createVerticalStrut(10));
		panel.add(quitButton);
		
		frame.add(panel);
		frame.pack();
		
		frame.setVisible(true);
	}
	
}
