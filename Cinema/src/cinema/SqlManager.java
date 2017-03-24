package cinema;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/** A class that will handle the communication between the mySQL database and the java program. 
 * @author Gustaf Peter Hultgren
 * @version 1.0 **/
public class SqlManager {
	/** The one and only instance of this class. **/
	private static SqlManager instance = null;
	/** The connection to the sql database. **/
	private Connection connection = null;
	/** The statement object will tell the connection what to send. **/
	private CallableStatement statement = null;
	
	/** A private default constructor. **/
	private SqlManager() {
		
	}
	
	/** Get a reference to the one and only instance of this object.
	 * @return The singleton instance of this class. **/
	public static SqlManager getSingleton() {
		if(instance == null)
			instance = new SqlManager();
		
		return instance;
	}
	
	/** Initialize to local host database with default values. 
	 * @throws SQLException **/
	public void Initialize() throws SQLException {
		initialize("jdbc:mysql://localhost:3306/codealong?useSSL=false", "root", "root");
	}
	
	/** Initialize the connection to the database.
	 * @param uri -The URI to the database (jdbc:mysql://localhost:3306/codealong?useSSL=false).
	 * @param user -The user name to log in as.
	 * @param password -The password of the database. 
	 * @throws SQLException **/
	public void initialize(String uri, String user, String password) throws SQLException {
		connection = DriverManager.getConnection(uri, user, password);
	}
	
	/** Call the specified procedure. 
	 * @param sql -The SQL script to call the stored procedure.
	 * @return A result set of the data retrieved. 
	 * @throws SQLException **/
	public ResultSet callStoredProcedure(String sql) throws SQLException {
		statement = connection.prepareCall(sql);
		return null;
	}
	
	/** Update the database.
	 * @param update -The script for the update. **/
	public void updateDatabase(String update) {
		
	}
	
	
	/** Send a query to the database.
	 * @param query -The query to send.
	 * @return A result set containing the result data from the database. **/
	public ResultSet sendQuery(String query) {
		return null;
	}
	
	/** Close all used resources.
	 * @throws SQLException **/
	public void close() throws SQLException {
		if(statement != null) {
			statement.close();
			statement = null;
		}
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
}
