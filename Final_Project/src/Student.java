import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<Registration> studentRegList;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
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

	public void addRegistration(Registration registration) {
		if(studentRegList.size() != 6)
			studentRegList.add(registration);
		else
			System.out.println("Unable to register as you already registered for six course");
	}
	
	public void removeRegistration(int index) {
		if(index >= 0 && studentRegList.size() > index) 
			studentRegList.remove(index);
		else 
			System.out.println("Unable to unerrol in this course. Check your index number.");
	}
	
	public void printCourses() {
		for(int i = 0; i < studentRegList.size(); i++) {
			System.out.println(studentRegList.get(i));
		}
	}

}
