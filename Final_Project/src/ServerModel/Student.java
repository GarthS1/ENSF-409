package ServerModel;
import java.util.ArrayList;
/**
 * The model for a student 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class Student {
	/** 
	 * Unique Id
	 */
	private int studentId;
	/**
	 * Current faculty
	 */
	private String faculty;
	/**
	 * Current major
	 */
	private String major;
	/**
	 * Current year
	 */
	private int year;
	/**
	 * All course currently registered for 
	 */
	private ArrayList<Registration> studentRegList;
	
	public Student (int id, String faculty, String major, int year) {
		this.setStudentId(id);
		this.setFaculty(faculty);
		this.setMajor(major);
		this.setYear(year);
		studentRegList = new ArrayList<Registration>();
	}
	/**
	 * Adds a registration to the student's list 
	 * @param registration Registration to be added
	 * @return if registration was successful  
	 */
	public boolean addRegistration(Registration registration) {
		boolean sameName = true;
        for(Registration r : studentRegList)
            if(r.getTheOffering().getTheCourse().getCourseName().contentEquals(registration.getTheOffering().getTheCourse().getCourseName()) &&
                    r.getTheOffering().getTheCourse().getCourseNum()== registration.getTheOffering().getTheCourse().getCourseNum())
                sameName = false;
        if(studentRegList.size() != 6 && sameName) {
            studentRegList.add(registration);
            return true;
        }
		else
			return false;
	}
	/**
	 * Removes a registration to the student's list 
	 * @param index Registration to be removed
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
			s += studentRegList.get(i).getTheOffering().getTheCourse().getCourseName() + studentRegList.get(i).getTheOffering().getTheCourse().getCourseNum() + "@";
		}
		return s;
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString () {
		String st = "Student Id: " + getStudentId() + "\n" + "Faculty: " + getFaculty() + "\n" + "Major: " +
				 getMajor() + "\n" +  "Year: " + getYear() + "\n\n";
		return st;
	}
}
