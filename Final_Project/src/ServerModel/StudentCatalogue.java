package ServerModel;
import java.util.ArrayList;
/**
 * Stores all students in the system 
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class StudentCatalogue {
	/**
	 * The list of all the students in the system 
	 */
	private ArrayList<Student> theStudents;
	
	public StudentCatalogue() {
		DBManager data = new DBManager();
		setTheStudents(data.readFromDataBaseStudent());
	}
	/**
	 * Searches for the student who matches the ID number
	 * @param string The ID number of the student 
	 * @return The student if found otherwise null
	 */
	public Student searchStudent(String string) {
		int id = Integer.parseInt(string);
		for(Student s: theStudents){
			if(s.getStudentId() == id){
				return s;
			}
		}
		return null;
	}

	public ArrayList<Student> getTheStudents() {
		return theStudents;
	}

	public void setTheStudents(ArrayList<Student> theStudents) {
		this.theStudents = theStudents;
	}
}
