import java.util.ArrayList;
/**
 * Stores all students in the system !!!!!!!Needs further work!!!!!!!!!!
 * @author Garth
 *
 */
public class StudentCatalogue {
	
	private ArrayList<Student> theStudents;
	
	public StudentCatalogue() {
		DBManager data = new DBManager();
		setTheStudents(data.readFromDataBaseStudent());
	}

	public Student searchStudent(String string) {
		return null;
	}

	public ArrayList<Student> getTheStudents() {
		return theStudents;
	}

	public void setTheStudents(ArrayList<Student> theStudents) {
		this.theStudents = theStudents;
	}

}
