package ClientController;
import ClientView.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

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
	 * Constructor for StudentClient 
	 * @param serverName Name of the server
	 * @param portNum The port number
	 */
	public StudentClient(String serverName, int portNum) {
		try {
			aSocket = new Socket(serverName, portNum);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
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
			while(true) {
				line = JOptionPane.showInputDialog("Please enter a student ID or type \"admin\": ");
				socketOut.println(line.toLowerCase());
				response = socketIn.readLine(); //read response from the socket
				
				//Admin log in
				if(response.equals("Admin found. Logging in.")) {
					AdminGUI adminMenu = new AdminGUI(socketIn, socketOut);
					adminMenu.getInfo();
					System.out.println("System Response: " + response);
					break;
				}	//Student log in
				else if(response.equals("Student found. Logging in.")) {
					MenuGUI menu = new MenuGUI(socketOut, socketIn);
					System.out.println("System Response: " + response); 
					break;
				}
				else 
					JOptionPane.showConfirmDialog(null, "invalid student ID. please try again.", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		InetAddress inetAddress = InetAddress.getLocalHost();
    StudentClient myClient = new StudentClient(inetAddress.getHostAddress(), 9898);
		myClient.communicate();	
	}
}