package ClientView;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


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
	JTextArea text;
	
	JButton cancelButton;
	
	ViewAllStudentCourses(MenuGUI m){
		menu = m;
		frame = new JFrame();
		textPanel = new JPanel();
		String temp = "";
		
		ViewPastCoursesListener listener = new ViewPastCoursesListener();
		
		try {
			temp = menu.getInSocket().readLine().replace("@", "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(temp.length() != 0)
			text = new JTextArea(temp);
		else
			text = new JTextArea("Not Enrolled in any Course");
		
		JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(300, 200));
		cancelButton = new JButton("Back");
		cancelButton.addActionListener(listener);
		
		textPanel.add(scroll);
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
	 * @author Garth Slaney, Jiho Kim, Eddie Kim
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
