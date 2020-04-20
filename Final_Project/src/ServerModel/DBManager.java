package ServerModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Loads from the mysql database. Much of the code used in from in class examples
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class DBManager implements IDBCredentials{
	/**
	 * The courselist used from the database
	 */
	private ArrayList <Course> courseList;
	/**
	 * The studentlist used from the database
	 */
	private ArrayList<Student> studentList;
	/**
	 * The connection used for the database 
	 */
	private Connection conn;

	public DBManager () {
		initializeConnection();
	}
	/**
	 * Reads from the database all the courses stored
	 * @return The student arraylist with all the courses 
	 */
	public ArrayList<Course> readFromDataBase() {
		courseList = new ArrayList<Course>();
		Statement stmt; 
		String query = "SELECT * FROM COURSE";
		
		try { 
			stmt= conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
			while (rs.next()) 
				courseList.add(new Course(rs.getString(1), rs.getInt(2), null));
			stmt.close();
		}catch (SQLException e) {
			System.out.println("Problem");
			e.printStackTrace();
		} 
		close();
		return courseList;
	}
	/**
	 * Reads from the database all the students stored
	 * @return The student arraylist with all the students 
	 */
	public ArrayList<Student> readFromDataBaseStudent() {
		studentList = new ArrayList<Student>();	
		Statement stmt; 
		String query = "SELECT * FROM STUDENT";
		
		try { 
			stmt= conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
			while (rs.next()) 
				studentList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			stmt.close();
		}catch (SQLException e) {
			System.out.println("Problem");
			e.printStackTrace();
		} 
		
		close();
		return studentList;
	}
	/**
	 * Connects with the database
	 */
	public void initializeConnection() {
		try {
			// Register JDBC driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Problem");
			e.printStackTrace();
		}
	}
	/**
	 * Closes the connection with the database
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Inserts the user statement into the student table 
	 * @param id The students id
	 * @param faculty The student's faculty
	 * @param major The student's major
	 * @param year The year the student's currently in
	 */
	public void insertUserPreparedStatementStudent(int id, String faculty, String major, int year) {
		try {
			String query = "INSERT INTO STUDENT (ID,faculty , major, YEAR) values(?,?,?,?)";
			PreparedStatement pStat = conn.prepareStatement(query);
			pStat.setInt(1, id);
			pStat.setString(2, faculty);
			pStat.setString(3, major);
			pStat.setInt(4, year);
			pStat.executeUpdate();
			pStat.close();
		} catch (SQLException e) {
			System.out.println("problem inserting user");
			e.printStackTrace();
		}
	}
	/**
	 * Creates the table for the students 
	 */
	private void createTableStudent() {
		String sql = "CREATE TABLE STUDENT " + "(id INTEGER not NULL, " + " faculty VARCHAR(255), "
				+ " major VARCHAR(255), " + "year INTEGER, " +" PRIMARY KEY ( id ))";
		try {
			Statement stmt = conn.createStatement(); // construct a statement
			stmt.executeUpdate(sql); // execute my query (i.e. sql)
			stmt.close();
			populateStudents();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Table can NOT be created!");
		}
		System.out.println("Created table in given database...");	
	}
	/**
	 * Populates the table with students 
	 */
	private void populateStudents() {
		File inputFile = new File("input.txt");
		Scanner scan;
		try {
			scan = new Scanner(inputFile);
			while(scan.hasNext()) 
				insertUserPreparedStatementStudent(Integer.parseInt(scan.next()), scan.next(), scan.next(), Integer.parseInt(scan.next()));
			scan.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Invalid File.", "Invalid File", JOptionPane.PLAIN_MESSAGE);
		}
	}
	/**
	 * Populates the table with courses 
	 */
	private void populateCourses() {
		try {
			PreparedStatement pStat = conn.prepareStatement("INSERT INTO COURSE (name, courseNum) values('ENGG',233)");
			pStat.executeUpdate();
			pStat = conn.prepareStatement("INSERT INTO COURSE (name, courseNum) values('ENSF',409)");
			pStat.executeUpdate();
			pStat = conn.prepareStatement("INSERT INTO COURSE (name, courseNum) values('PHYS',259)");
			pStat.executeUpdate();
			pStat.close();
		} catch (SQLException e) {
			System.out.println("problem inserting course");
			e.printStackTrace();
		}
	}
	/**
	 * Creates the table for courses
	 */
	private void createTableCourses() {
		String sql = "CREATE TABLE COURSE " + "(name VARCHAR(255), " + " courseNum INTEGER,"  +" PRIMARY KEY ( name ))";
		try {
			Statement stmt = conn.createStatement(); // construct a statement
			stmt.executeUpdate(sql); // execute my query (i.e. sql)
			stmt.close();
			populateCourses();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Table can NOT be created!");
		}
		System.out.println("Created table in given database...");
	}
	/**
	 * Main function to generate the tables needed in the database
	 * @param args needed to work 
	 */
	public static void main(String args[]) {
		DBManager mydb = new DBManager();
		mydb.createTableStudent();
		mydb.createTableCourses();
		mydb.close();
	}
}

//Code for testing purposes and Milestone 2
/*private void saveData(String fileName, ArrayList<Student> stu) {
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
	public ArrayList<Student> readFromDataBaseStudent() {
		String fileName = JOptionPane.showInputDialog(null, "What is the name of the text file that contains your information?");
		ArrayList<Student> student = new ArrayList<Student>();
		saveData(fileName, student);
		
		return student;
	}
*/
