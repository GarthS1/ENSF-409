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
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c;  //This line invokes the toString() method of Course
			st += "\n";
		}
		return st;
	}
}