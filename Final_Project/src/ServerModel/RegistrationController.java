package ServerModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The runnable class which handles the students requests and communicates with
 * the student's client
 * 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class RegistrationController implements Runnable {
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
	 */
	StudentCatalogue stu;
	/**
	 * The student currently logged on
	 */
	Student st;

	public RegistrationController(BufferedReader socketIn, PrintWriter socketOut, CourseCatalogue cat,
			StudentCatalogue stu) {
		this.socketIn = socketIn;
		this.socketOut = socketOut;
		this.cat = cat;
		this.stu = stu;
	}

	@Override
	public void run() {
		boolean studentFound = false;
		String line;

		while (!studentFound) {
			try {
				line = socketIn.readLine();
				
				if(line.equals("admin")) {
					socketOut.println("Admin found. Logging in.");
					studentFound = true;
					runAdmin();
				}
				else {
					st = stu.searchStudent(line); // makes sure valid ID is entered before running
					if (st != null) {
						socketOut.println("Student found. Logging in.");
						studentFound = true;
						runStudent();
					} else {
						socketOut.println("No student with the ID entered matched. Please try again"); // error message if
																										// no ID matches
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void runAdmin() {
			String courseName;
			try {
				courseName = socketIn.readLine();
				int courseNum = Integer.parseInt(socketIn.readLine());
				Course myCourse = cat.searchCat(courseName, courseNum);
				if (myCourse != null) {
					cat.createCourseOffering(myCourse, Integer.parseInt(socketIn.readLine()), Integer.parseInt(socketIn.readLine()));
				}
				else {
					cat.getCourseList().add(new Course(courseName, courseNum, null));
					cat.createCourseOffering(cat.searchCat(courseName, courseNum), Integer.parseInt(socketIn.readLine()), 
							Integer.parseInt(socketIn.readLine()));
				}
			} catch (IOException e) {
				e.printStackTrace();
		}
	}

	private void runStudent() {
		String action;
		boolean exit = false; // exit condition for the loop
		while (!exit) {
			try {
				if (socketIn.ready()) {
					action = socketIn.readLine();
					switch (action) {
					case "search catalogue courses":
						String course = socketIn.readLine();
						if (course.equals("Cancel"))
							break;
						int courseId = Integer.parseInt(socketIn.readLine());
						Course courseSearched = cat.searchCat(course, courseId);
						socketOut.println(courseSearched.toString().replace("\n", "."));
						break;
					case "add course to student course":
						while (true) {
							Registration addedCourse = new Registration();
							String course1 = socketIn.readLine();
							if (course1.equals("Cancel"))
								break;
							int courseId1 = Integer.parseInt(socketIn.readLine());
							Course courseSearched1 = cat.searchCat(course1, courseId1);
							int section = Integer.parseInt(socketIn.readLine()) - 1; // need to subtract one to get effective address
							socketOut.println(addedCourse.completeRegistration(st, courseSearched1.getCourseOfferingAt(section)));
						}
						break;
					case "remove course from student course":
						socketOut.println(st.printCourses());
						String temp = socketIn.readLine();
						if(temp.equals("Cancel"))
							break;
						else {
							int removeId = Integer.parseInt(temp);
							st.removeRegistration(removeId);
						}
						break;
					case "view All courses in catalog":
						socketOut.println(cat.toString().replace("\n", "."));
						break;
					case "view all courses taken by student":
						socketOut.println(st.printCourses().replace("\n", "."));
						break;
					case "quit":
						exit = true;
						break;
					default:
						socketOut.println("Invalid input enetered. Please enter a different input.");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
