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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ServerModel.CourseCatalogue;

/**
 * This class creates a GUI for viewing all courses in the catalogue.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class ViewAllCatalogue {
	MenuGUI menu;
	JFrame frame;
	
	JPanel textPanel;
	JPanel buttonPanel;
	JPanel combinedPanel;

	
	/**
	 * Contains the list of all courses in the catalogue.
	 */
	JTextArea text;
	
	JButton cancelButton;
	

	ViewAllCatalogue(MenuGUI m){
		menu = m;
		frame = new JFrame();
		textPanel = new JPanel();
		ViewCatalogueListener listener = new ViewCatalogueListener();
		CourseCatalogue cat = new CourseCatalogue();
		
		//Replace this with information from the socket.
		
		String temp = "";
		try {
			temp = menu.getInSocket().readLine();
			System.out.println(temp.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp = temp.replace(".", "\n");
		
		text = new JTextArea(temp);
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
	private class ViewCatalogueListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				frame.dispose();
				menu.frame.setVisible(true);
			}
		}
	}
}
