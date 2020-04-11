package ServerModel;
import java.util.ArrayList;
/**
 * The model for a course 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class Course {
	/**
	 * The name of the course
	 */
	private String courseName;
	/**
	 * The course number of the course
	 */
	private int courseNum;
	/**
	 * Courses required to take this course
	 */
	private ArrayList<Course> preReq;
	/**
	 * All offerings of the course 
	 */
	private ArrayList<CourseOffering> offeringList;

	public Course(String courseName, int courseNum, ArrayList<Course> preReq) {
		this.setCourseName(courseName);
		this.setCourseNum(courseNum);
		
		this.preReq = preReq;
		offeringList = new ArrayList<CourseOffering>();
	}

	public void addOffering(CourseOffering offering) {
		if (offering != null && offering.getTheCourse() == null) {
			offering.setTheCourse(this);
			if (!offering.getTheCourse().getCourseName().equals(courseName) || offering.getTheCourse().getCourseNum() != courseNum) {
				System.err.println("Error! This section belongs to another course!");
				return;
			}
			
			offeringList.add(offering);
		}
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getCourseName() + " " + getCourseNum ();
		st += "\nAll course sections:\n";
		for (CourseOffering c : offeringList)
			st += c;
		st += "\n-------\n";
		return st;
	}

	public CourseOffering getCourseOfferingAt(int i) {
		if (i < 0 || i >= offeringList.size() )
			return null;
		else
			return offeringList.get(i);
	}
}
