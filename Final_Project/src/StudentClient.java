import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class StudentClient{

	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private BufferedReader stdIn;
	private Student student;
	private MenuGUI view;
	
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
	
	public void communicate() {
		
		String line = "";
		String response = "";
		
		try {
			while(true) {
				System.out.println("Please enter a word: ");
				line = stdIn.readLine(); //read line from the user (i.e from the keyboard)
				socketOut.println(line);
				response = socketIn.readLine(); //read response from the socket
				System.out.println("Response is: " + response); 
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
		closeAll();
	}
	
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