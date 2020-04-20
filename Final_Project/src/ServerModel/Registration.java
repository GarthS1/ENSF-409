package ServerModel;
/**
 * Tracks the student and offering together
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class Registration {
	/** 
	 * The student registering
	 */
	private Student theStudent;
	/**
	 * The course offering associated with the student 
	 */
	private CourseOffering theOffering;
	/**
	 * The grade the student received in the course 
	 */
	private char grade;
	/**
	 * Completes the registration of the course 
	 * @param st Student registering 
	 * @param of Course being registered for 
	 */
	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}
	/**
	 * Adds the registration to the offering and student object 
	 */
	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	public Student getTheStudent() {
		return theStudent;
	}
	
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
//		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
//		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;	
	}
}