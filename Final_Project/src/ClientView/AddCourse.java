package ClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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
import ServerModel.Registration;

/**
 * Class for creating a GUI for adding courses into a student's enrolled
 * courses.
 * 
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
	 * Place where the user types what course he/she would like to add to his
	 * current studies.
	 */
	JTextField textField;
	/**
	 * Text which describes to the user what this GUI does.
	 */
	JLabel text;
	JButton addButton;
	JButton cancelButton;

	public AddCourse(MenuGUI m) {
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
	 * This class handles what happens when a button is clicked. When "Cancel" is
	 * clicked, the frame closes. When "Add" is clicked, the program goes into the
	 * database and adds the specified course into the system if possible.
	 * 
	 * @author Garth Slaney, Jiho Kim, Eddie Kim
	 *
	 */
	private class AddCourseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addButton) {
				String answer = textField.getText();
				String temp2 = JOptionPane.showInputDialog(null, "Which section would you like to join?");
				if (temp2 != null) {
					int lectureNum = Integer.parseInt(temp2);
					int result = JOptionPane.showConfirmDialog(null, "would you like to add " + answer, "confirmation",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						String[] temp = textField.getText().split("\\s+");
						if (temp.length == 2) {
							menu.getOutSocket().println(temp[0].toUpperCase());
							menu.getOutSocket().println(temp[1]);

							menu.getOutSocket().println(lectureNum);
							try {
								String a = menu.getInSocket().readLine();
								if (a.equals("true")) {
									JOptionPane.showMessageDialog(null, "Course Successfully added!");
								} else
									JOptionPane.showMessageDialog(null, "Course registration failed. You may have more than "
											+ "6 courses or have already registered.", "fail",
											JOptionPane.ERROR_MESSAGE);
							} catch (IOException e1) {
								e1.printStackTrace();
							}

						}
					}

				}
			} else if (e.getSource() == cancelButton) {
				menu.getOutSocket().println("Cancel");
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
}
