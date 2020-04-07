import java.util.Scanner;

public class RegistrationApp {
	
	public static void main (String [] args) {
		Scanner key = new Scanner(System.in);	
		int keyPressed;
		boolean exit = false;
		CourseCatalogue cat = new CourseCatalogue ();
		//Simulating database 
		Student st = new Student ("Sara", 1); // only using one student to simulate the experience of a student registering for course
		Course myCourse = cat.searchCat("ENGG", 233);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 100);
			cat.createCourseOffering(myCourse, 2, 200);
		}
		
		myCourse = cat.searchCat("ENSF", 409);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 50);
			cat.createCourseOffering(myCourse, 2, 60);
		}
		
		myCourse = cat.searchCat("PHYS", 259);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 250);
			cat.createCourseOffering(myCourse, 2, 300);
		}

		while(true) {
			displayMenu();
			keyPressed = key.nextInt();
			switch(keyPressed) {
			case 1:
				System.out.println("Please enter the name of the course your looking for. No spcaes and proper capitalization");
				String course = key.next();
				System.out.println("Please enter the number of the course your looking for. No spcaes.");
				int courseId = key.nextInt();
				Course courseSearched = cat.searchCat(course, courseId);
				System.out.println(courseSearched);
				break;
			case 2:
			  Registration addedCourse = new Registration ();
			  System.out.println("Please enter the name of the course your adding. No spcaes and proper capitalization");
				String course1 = key.next();
				System.out.println("Please enter the number of the course your adding. No spcaes.");
				int courseId1 = key.nextInt();
				Course courseSearched1 = cat.searchCat(course1, courseId1);
				System.out.println("Please enter which section you are registering for.");
				int section = key.nextInt() -1 ; //need to subtract one to get effective address 
			  addedCourse.completeRegistration(st, courseSearched1.getCourseOfferingAt(section));
				break;
			case 3:
				System.out.println("Please enter the index of the course you wish to unerroll from. Index 1 is your first course and increses by 1 for each subsquent course.");
				int removeId = key.nextInt() - 1; // decrease by 1 to get effective address 
				st.removeRegistration(removeId);
				break;
			case 4:
				System.out.println(cat);
				break;
			case 5:
				st.printCourses();
				break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("Invalid input enetered. Please enter a different input.");
			}
			if(exit)
				break;
		}
	}

	private static void displayMenu() {
		System.out.println("1.	Search catalogue courses\n2.	Add course to student courses\n3.	Remove course from student courses\n4.	"
				+"View All courses in catalogue\n5.	View all course taken by student\n6.	Quit ");
	}
}