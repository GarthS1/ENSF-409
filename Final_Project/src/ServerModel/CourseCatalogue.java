package ServerModel;
import java.util.ArrayList;
/**
 * The course catalogue which keeps track of all the course 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class CourseCatalogue {
	/**
	 * All the courses 
	 */
	private ArrayList <Course> courseList;
	
	public CourseCatalogue () {
		loadFromDataBase ();
	}
	/**
	 * Loads courses from the database
	 */
	private void loadFromDataBase() {
		DBManager db = new DBManager();
		setCourseList(db.readFromDataBase());
		
		//This code is here to add course offerings 
		Course myCourse = searchCat("ENGG", 233);
		if (myCourse != null) {
			createCourseOffering(myCourse, 1, 100);
			createCourseOffering(myCourse, 2, 200);
		}
		
		myCourse = searchCat("ENSF", 409);
		if (myCourse != null) {
			createCourseOffering(myCourse, 1, 50);
			createCourseOffering(myCourse, 2, 60);
		}
		
		myCourse = searchCat("PHYS", 259);
		if (myCourse != null) {
			createCourseOffering(myCourse, 1, 250);
			createCourseOffering(myCourse, 2, 300);
		}
	}
	/**
	 * Manually creates a new course
	 * @param c The course to be added 
	 * @param secNum The number of the course 
	 * @param secCap The number of sets allowed
	 */
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap);
			c.addOffering(theOffering);
		}
	}
	/**
	 * Search for a course
	 * @param courseName The name of the course
	 * @param courseNum	The number of the course
	 * @return the course
	 */
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		return null;
	}
	
	public ArrayList <Course> getCourseList() {
		return courseList;
	}
	
	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString () {
		String st = "All courses in the catalogue: .";
		for (Course c : courseList) {
			st += c.toString();  //This line invokes the toString() method of Course
			st += ".";
		}
		return st;
	}
}