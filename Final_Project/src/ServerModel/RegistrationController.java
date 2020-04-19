package ServerModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * The runnable class which handles the students requests and communicates with the student's client
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class RegistrationController implements Runnable{
	/**
	 * Input stream
	 */
	BufferedReader socketIn;
	/**
	 * Output stream
	 */
	PrintWriter socketOut;
	/**
	 * The course catalogue which is used 
	 */
	CourseCatalogue cat;
	/**
	 * The student catalogue which is used
	 * */
	StudentCatalogue stu;
	/**
	 * The student currently logged on
	 */
	Student st;
	
	public RegistrationController(BufferedReader socketIn, PrintWriter socketOut, CourseCatalogue cat, StudentCatalogue stu) {
		this.socketIn = socketIn;
		this.socketOut = socketOut;
		this.cat = cat;
		this.stu = stu;
	}
	
	@Override
	public void run() {	
		boolean studentFound = false;
		String line;
		
		while(!studentFound) {
			try {
				line = socketIn.readLine();
				st = stu.searchStudent(line);  //makes sure valid ID is entered before running
				if(st != null) {
					socketOut.println("Student found. Logging in.");
					studentFound = true; 
				}
				else {
					socketOut.println("No student with the ID entered matched. Please try again");	//error message if no ID matches 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String action; 
		boolean exit = false;			//exit condition for the loop
		while(!exit) {
			try {
				action = socketIn.readLine();
				switch(action) {
				case "search catalogue courses":
					String course = socketIn.readLine();
					int courseId = Integer.parseInt(socketIn.readLine());
					Course courseSearched = cat.searchCat(course, courseId);
					socketOut.println(courseSearched);
					break;
				case "add course to student course":
				  Registration addedCourse = new Registration ();
					String course1 = socketIn.readLine();
					int courseId1 = Integer.parseInt(socketIn.readLine());
					Course courseSearched1 = cat.searchCat(course1, courseId1);
					int section = Integer.parseInt(socketIn.readLine()) - 1; //need to subtract one to get effective address 
				  addedCourse.completeRegistration(st, courseSearched1.getCourseOfferingAt(section));
					break;
				case "remove course from student course":
					socketOut.println(st.printCourses());
					int removeId = Integer.parseInt(socketIn.readLine()); 
					st.removeRegistration(removeId);
					break;
				case "view All courses in catalog":
					socketOut.print(cat);
					break;
				case "view all courses taken by student":
					socketOut.print(st.printCourses());
					break;
				case "quit":
					exit = true;
					break;
				default:
					socketOut.print("Invalid input enetered. Please enter a different input.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
		