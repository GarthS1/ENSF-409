import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;

/**
 * This class shows the buttons and excutes the logic behind each.
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class Interface extends JFrame {
	/**
	 * The buttons used for the four methods called 
	 */
	private JButton b1	, b2, b3, b4;
	/**
	 * The label on the top of the panel
	 */
	private JLabel l1;
	/**
	 * The test area in the center
	 */
	private JTextArea t1;
	/**
	 * The logic behind the function calls 
	 */
	private Logic theLogic;
	/**
	 * The constructor for the interface
	 * @param s The string title
	 */
	public Interface (String s) {
		super (s);
		
		setLayout(new BorderLayout());
		Panel sPanel = new Panel();
		b1 = new JButton("Insert");
		b2 = new JButton("Find");
		b3 = new JButton("Browse");
		b4 = new JButton("Create Tree from File");
		l1 = new JLabel("                                    An Application to Maintain Student Records");
		t1 = new JTextArea("");
		theLogic = new Logic();

		getContentPane().add(l1, "North"); 
		sPanel.add(b1);
		sPanel.add(b2);		
		sPanel.add(b3);		
		sPanel.add(b4);
		add("South", sPanel);
		add("Center", t1);
		
		setVisible(true);
		setSize(500,500);
		
		b1.addActionListener(( ActionEvent e) -> {
			theLogic.insert();
		});
		
		b2.addActionListener(( ActionEvent e) -> {
			theLogic.find();
		});
		
		b3.addActionListener(( ActionEvent e) -> {
			theLogic.browse(t1);
		});
		
		b4.addActionListener(( ActionEvent e) -> {
			theLogic.createTreeFromFile();
		});
	}
	
	public static void main(String[] args) {
		Interface myFrame = new Interface("Main Window "); 
	}	
}
