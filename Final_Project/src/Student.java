import java.util.ArrayList;
/**
 * The model for a student 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class Student {
	/**
	 * Name
	 */
	private String studentName;
	/** 
	 * Unique Id
	 */
	private int studentId;
	/**
	 * All course currently registered for 
	 */
	private ArrayList<Registration> studentRegList;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
	}
	/**
	 * Adds a registration to the student's list 
	 * @param registration Registration to be added
	 */
	public void addRegistration(Registration registration) {
		if(studentRegList.size() != 6)
			studentRegList.add(registration);
		else
			System.out.println("Unable to register as you already registered for six course");
	}
	/**
	 * Removes a registration to the student's list 
	 * @param registration Registration to be removed
	 */
	public void removeRegistration(int index) {
		if(index >= 0 && studentRegList.size() > index) 
			studentRegList.remove(index);
		else 
			System.out.println("Unable to unerrol in this course. Check your index number.");
	}
	/**
	 * Makes a string of course 
	 * @return All the students courses 
	 */
	public String printCourses() {
		String s = "";
		for(int i = 0; i < studentRegList.size(); i++) {
			s += studentRegList.get(i) + "\n";
		}
		return s;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}
}
