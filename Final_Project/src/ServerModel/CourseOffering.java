package ServerModel;
import java.util.ArrayList;
/**
 * Simulates a course offering 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class CourseOffering {
	/**
	 * The section 
	 */
	private int secNum;
	/**
	 * Amount of students which can register 
	 */
	private int secCap;
	/**
	 * The course associated 
	 */
	private Course theCourse;
	/**
	 * All the students registered in the course 
	 */
	private ArrayList <Registration> offeringRegList;
	/**
	 * Tracks if there are enough students to run the course 
	 */
	private boolean enoughStudents;

	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
		setEnoughStudents(false);
	}
	/**
	 * Checks that there are enough students to run the course
	 */
	public void checkStudents() {
		if(secCap - 8 >= offeringRegList.size()) {
			setEnoughStudents(true);
		}
	}
	/**
	 * Adds a registration to the ArrayList
	 * @param registration Registration to be added
	 */
	public void addRegistration(Registration registration) {
		offeringRegList.add(registration);
	}
	
	public int getSecNum() {
		return secNum;
	}
	
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	
	public int getSecCap() {
		return secCap;
	}
	
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	
	public Course getTheCourse() {
		return theCourse;
	}
	
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	
	public boolean isEnoughStudents() {
		return enoughStudents;
	}
	
	public void setEnoughStudents(boolean enoughStudents) {
		this.enoughStudents = enoughStudents;
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}
}