package ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * action listener class for the main menu. In this class, it takes care of whatever the user chooses and creates
 * a tab based on user choices or terminates the program.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class MyListener implements ActionListener{
	MenuGUI menu;
	
	MyListener(MenuGUI m){
		menu = m;
	}

	/**
	 * Cases for user choices from MenuGUI. This executes when a button from the main screen (GUI) is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.quitButton) {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to end this application?",
					"Exit application", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION)
				menu.frame.dispose();
			return;
		}
		
		menu.frame.setVisible(false);
		if(e.getSource() == menu.searchCourseButton) {
			menu.getOutSocket().println("search catalogue courses");
			new SearchCourse(menu);
		} else if(e.getSource() == menu.addCourseButton) {
			menu.getOutSocket().println("add course to student course");
			new AddCourse(menu);
		} else if(e.getSource() == menu.removeCourseButton) {
			menu.getOutSocket().println("remove course from student course");
			new RemoveCourse(menu);
		} else if(e.getSource() == menu.viewAllCatalogueButton) {
			menu.getOutSocket().println("view All courses in catalog");
			new ViewAllCatalogue(menu);
		} else if(e.getSource() == menu.viewAllStudentCoursesButton) {
			menu.getOutSocket().println("view all courses taken by student");
			new ViewAllStudentCourses(menu);
		} else if(e.getSource() == menu.quitButton) {
			menu.getOutSocket().println("quit");
		}
	}
	


}
