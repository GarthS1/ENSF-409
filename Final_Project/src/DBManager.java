import java.util.ArrayList;

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

	public ArrayList readFromDataBase() {
		// TODO Auto-generated method stub
		courseList.add(new Course ("ENGG", 233, null));
		courseList.add(new Course ("ENSF", 409, null));
		courseList.add(new Course ("PHYS", 259, null));
		return courseList;
	}

	public ArrayList readFromDataBaseStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}