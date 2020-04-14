package ServerModel;
/**
 * The interface needed for a mysql database code used from an example
 * @author Dr.Moshirpour
 *
 */
public interface IDBCredentials {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

	   //  Database credentials
	   static final String USERNAME = "root";
	   static final String PASSWORD = "ensf409";

}
