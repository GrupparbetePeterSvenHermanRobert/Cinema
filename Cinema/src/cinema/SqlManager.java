package cinema;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** A class that will handle the communication between the mySQL database and the java program. 
 * @author Gustaf Peter Hultgren
 * @version 1.0 **/
public class SqlManager {
	/** The one and only instance of this class. **/
	private static SqlManager instance = null;
	/** The connection to the SQL database. **/
	private Connection connection = null;
	
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
		initialize("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
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
	 * @param sql -The SQL script to call the stored procedure "procedure_name(input)".
	 * @return An array list of maps, where each map represents a row of data with the columns name as key.
	 * @throws SQLException **/
	public ArrayList<Map<String, Object>> callStoredProcedure(String sql) throws SQLException {
		String script = "CALL " + sql;
		
		CallableStatement statement = connection.prepareCall(script);
		ResultSet result = null;
		
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		if(statement.execute()) {
			result = statement.getResultSet();
		
			while(result.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				ResultSetMetaData data = result.getMetaData();
				
				int count = data.getColumnCount();
				for(int i = 1; i <= count; i++) {
					row.put(data.getColumnName(i), result.getObject(i));
				}
				
				list.add(row);
			}
		}
		
		result.close();
		statement.close();
		
		return list;
	}
	
	/** Update the database.
	 * @param sql -The script for the update. 
	 * @throws SQLException **/
	public void updateDatabase(String sql) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);	
		statement.executeUpdate();
		
		statement.close();
	}
	
	
	/** Send a query to the database.
	 * @param sql -The query to send.
	 * @return An array list of maps, where each map represents a row of data with the columns name as key.
	 * @throws SQLException **/
	public ArrayList<Map<String, Object>> sendQuery(String sql) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = null;
		
		result = statement.executeQuery();
		
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		while(result.next()) {
			Map<String, Object> row = new HashMap<String, Object>();
			ResultSetMetaData data = result.getMetaData();
			
			int count = data.getColumnCount();

			for(int i = 1; i <= count; i++) {
				row.put(data.getColumnName(i), result.getObject(i));
			}
			
			list.add(row);
		}
		
		result.close();
		statement.close();
		
		return list;
	}
	
	/** Close all used resources.
	 * @throws SQLException **/
	public void close() throws SQLException {
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	/** Main loop to test the class. **/
	public static void main(String[] args) {
		SqlManager manager = SqlManager.getSingleton();
		
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			manager.Initialize();
			System.out.println("Connection initialized.");
			
			//manager.updateDatabase("INSERT INTO film VALUES('The Hobbit', 125, 'A good fantasy film.')");
			//result = manager.sendQuery("SELECT * FROM film;");
			/*result = manager.callStoredProcedure("get_film_by_title('The Hobbit')");
			
			for(int i = 0; i < result.size(); i++) {
				System.out.println((String)(result.get(i).get("title")));
				System.out.println((String)(result.get(i).get("description")));
				System.out.println((long)(result.get(i).get("duration")));
			}
			
			Film film = new Film(result.get(0));
			System.out.println(film.toString()); */
			
			result = manager.callStoredProcedure("get_theater_by_id(0)");
			Theater theater = new Theater(result.get(0));
			System.out.println(theater.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {				
				manager.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
