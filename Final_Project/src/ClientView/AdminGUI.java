package ClientView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * Class for Admin GUI
 * 
 * @author Eddie Kim, Jiho Kim, Garth Slaney
 *
 */
public class AdminGUI {
	/*
	 * Socket in
	 */
	BufferedReader in;

	/*
	 * Socket out
	 */
	PrintWriter out;

	/**
	 * AdminGUI Constructor
	 * 
	 * @param socketIn  Socket in
	 * @param socketOut Socket out
	 */
	public AdminGUI(BufferedReader socketIn, PrintWriter socketOut) {
		in = socketIn;
		out = socketOut;

	}

	/**
	 * Gathers information about the course the user (admin) wants to add and sends
	 * it to the server then prints out whether the course has been added
	 * successfully or not.
	 */
	public void getInfo() {
		String name = JOptionPane.showInputDialog(null, "What is the name of the course?");
		out.println(name);
		String courseNum = JOptionPane.showInputDialog(null, "what is the course number?");
		out.println(courseNum);
		String lectureNum = JOptionPane.showInputDialog(null, "What is the lecture number?");
		out.println(lectureNum);
		String seats = JOptionPane.showInputDialog("What is the number of seats?");
		out.println(seats);

		JOptionPane.showMessageDialog(null, "Successfully added course!");

	}
}