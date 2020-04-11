package ServerModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Loads from the database !!! NEED FURTHER IMPLEMATION THIS IS A SHALLOW SIML!!!!!!
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class DBManager {
	
	ArrayList <Course> courseList;

	public DBManager () {
		courseList = new ArrayList<Course>();
	}

	public ArrayList<Course> readFromDataBase() {
		courseList.add(new Course ("ENGG", 233, null));
		courseList.add(new Course ("ENSF", 409, null));
		courseList.add(new Course ("PHYS", 259, null));
		return courseList;
	}

	public ArrayList<Student> readFromDataBaseStudent() {
		String fileName = JOptionPane.showInputDialog(null, "What is the name of the text file that contains your information?");
		ArrayList<Student> student = new ArrayList<Student>();
		saveData(fileName, student);
		
		return student;
	}
	
	private void saveData(String fileName, ArrayList<Student> stu) {
		File inputFile = new File(fileName);
		Scanner scan;
		try {
			scan = new Scanner(inputFile);
			while(scan.hasNext()) {
				stu.add(new Student(null, Integer.parseInt(scan.next()) ) );
				for(int i = 0; i < 3; i++)
					scan.next();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Invalid File.", "Invalid File", JOptionPane.PLAIN_MESSAGE);
		}
	}

}