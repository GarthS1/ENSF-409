package ClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class creates a GUI for removing course from a student's currently enrolled courses.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
class RemoveCourse {
	MenuGUI menu;
	JFrame frame;
	JPanel dropDownPanel;
	JPanel buttonPanel;
	JPanel combinedPanel;
	
	
	/**
	 * A drop-down menu displaying what the courses the student is currently enrolled in.
	 */
	JComboBox<String> dropDownMenu;
	
	/**
	 * Displays instruction on what the user should do onto the GUI.
	 */
	JLabel text;
	
	JButton removeButton;
	JButton cancelButton;
	
	RemoveCourse(MenuGUI m) {
		menu = m;
		frame = new JFrame();
		RemoveCourseListener listener = new RemoveCourseListener();
		
		dropDownPanel = new JPanel();
		//change this with information from the database.
		try {
			String a = menu.getInSocket().readLine();
			String [] temp = a.split("@");
			dropDownMenu = new JComboBox<String>(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		text = new JLabel("What course would you like to remove?");
		
		removeButton = new JButton("Remove");
		cancelButton = new JButton("Cancel");
		
		removeButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		dropDownPanel.setLayout(new BoxLayout(dropDownPanel, BoxLayout.PAGE_AXIS));
		dropDownPanel.add(text);
		dropDownPanel.add(Box.createVerticalStrut(10));
		dropDownPanel.add(dropDownMenu);
		dropDownPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		buttonPanel = new JPanel();
		buttonPanel.add(removeButton);
		buttonPanel.add(cancelButton);
		
		combinedPanel = new JPanel();
		combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.PAGE_AXIS));
		combinedPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		combinedPanel.add(dropDownPanel);
		combinedPanel.add(buttonPanel);
		
		frame.add(combinedPanel);
		frame.pack();
		
		frame.setVisible(true);
	}
	
	/**
	 * This class handles what happens when a button is clicked. When "Cancel" is clicked, the frame closes.
	 * When the "Remove" button is clicked, the program goes into the database and deletes the course from the student.
	 * @author Garth Slaney, Jiho Kim, Eddie Kim
	 *
	 */
	private class RemoveCourseListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == removeButton) {
				String temp = "Are you sure you want to remove " + (String)dropDownMenu.getSelectedItem() + "?";
				 int result = JOptionPane.showConfirmDialog(null, temp,
						 "confirmation", JOptionPane.YES_NO_OPTION);
				 if(result == JOptionPane.YES_OPTION) {
					 menu.getOutSocket().println(dropDownMenu.getSelectedIndex());
					 JOptionPane.showMessageDialog(null, "Successfully removed course!");
					 frame.dispose();
					 menu.frame.setVisible(true);
				 }
			} else if(e.getSource() == cancelButton) {
				menu.getOutSocket().println("Cancel");
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
}
