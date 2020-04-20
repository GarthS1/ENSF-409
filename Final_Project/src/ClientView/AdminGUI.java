package ClientView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class AdminGUI {
	/**
	 * Socket in
	 */
	BufferedReader in;
	
	/**
	 * Socket out
	 */
	PrintWriter out;
	
	public AdminGUI(BufferedReader socketIn, PrintWriter socketOut) {
		in = socketIn;
		out = socketOut;
		
	}
	
	/**
	 * Gathers information about the course the user (admin) wants to add and sends it to the server then
	 * prints out whether the course has been added successfully or not.
	 */
	public void getInfo() {
		String name = JOptionPane.showInputDialog(null, "What is the name of the course?");
		out.println(name);
		String courseNum = JOptionPane.showInputDialog(null, "what is the course number?");
		out.println(courseNum);
		String seats = JOptionPane.showInputDialog("What is the number of seats?");
		out.println(seats);
		
		String added;
		try {
			added = in.readLine();
			if(added.equals("true"))
				JOptionPane.showConfirmDialog(null, "Successfully added course!");
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "Course failed to be added");
		}
		
	}
}
