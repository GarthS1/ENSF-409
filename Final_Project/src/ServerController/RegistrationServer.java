package ServerController;
import ServerModel.* ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * The server which handles inquires by students/administrators   
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class RegistrationServer {
	/**
	 * The client's socket  
	 */
	private Socket aSocket; 
	/**
	 * The socket by which the server connects to the client 
	 */
	private ServerSocket serverSocket;
	/**
	 * The output stream for the server
	 */
	private PrintWriter socketOut;
	/**
	 * The input stream for the server
	 */
	private BufferedReader socketIn;
	/**
	 * The threadpool used to handle multiple threads 
	 */
	private ExecutorService pool;
	/**
	 * Constructor for the server 
	 * @param port The port which the server connects to 
	 */
	public RegistrationServer(int port) {
		try {
			serverSocket = new ServerSocket (port);
			pool = Executors.newCachedThreadPool(); 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Runs the server until an IOException occurs
	 */
	public void runServer() {
		CourseCatalogue cat = new CourseCatalogue();  		//constructs new course catalogue for the server
		StudentCatalogue stu = new StudentCatalogue();    //constructs new students catalogue for the server 
		try {
			while(true) {				
				aSocket = serverSocket.accept(); 
				System.out.println("Connection accepted by server");
				socketIn = new BufferedReader ( new InputStreamReader(aSocket.getInputStream()) );
				socketOut = new PrintWriter ( aSocket.getOutputStream(), true);
				RegistrationController reg = new RegistrationController(socketIn, socketOut, cat, stu); 
				pool.execute(reg);	//executes the runnable in a thread pool
			}
			}catch(IOException e) {
				e.getStackTrace();
		}
		closeConnection();
	}
	/**
	 * Closes the server
	 */
	private void closeConnection() {
		try {
			socketIn.close();
			socketOut.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		RegistrationServer myServer = new RegistrationServer (9898);
		System.out.println("Your current IP address : " + InetAddress.getLocalHost());
		myServer.runServer();
	}
}
