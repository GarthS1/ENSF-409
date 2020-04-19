package ClientController;
import ClientView.*;
import ServerModel.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

/**
 * The client that runs the GUI and connects to the server
 * @author Eddie Kim, Garth Slaney, Jiho Kim
 *
 */
public class StudentClient{
	/**
	 * The client socket
	 */
	private Socket aSocket;	
	/**
	 * Output socket for client
	 */
	private PrintWriter socketOut;
	/**
	 * Input socket for client
	 */
	private BufferedReader socketIn;
	/**
	 * Input from the user
	 */
	private BufferedReader stdIn;
	/**
	 * Constructor for StudentClient 
	 * @param serverName Name of the server
	 * @param portNum The port number
	 */
	public StudentClient(String serverName, int portNum) {
		try {
			aSocket = new Socket(serverName, portNum);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Communication with the server
	 */
	public void communicate() {	
		String line = "";
		String response = "";
		
		try {
			//MAKE THIS GUI
			while(true) {
				System.out.println("Please enter a student ID: ");
				line = stdIn.readLine(); //read line from the user (i.e from the keyboard)
				socketOut.println(line);
				response = socketIn.readLine(); //read response from the socket
				
				if(!response.equals("No student with the ID entered matched. Please try again")) {
					MenuGUI menu = new MenuGUI(socketOut, socketIn);
					System.out.println("System Response: " + response); 
					break;
				}
				else 
					System.out.println("System Response: " + response); 
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
//		closeAll();
	}
	
	/**
	 * Closes the client sockets
	 */
	private void closeAll() {
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException {
	  StudentClient myClient = new StudentClient("localhost", 9898);
		myClient.communicate();	
	}
}