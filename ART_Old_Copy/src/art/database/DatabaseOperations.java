package art.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import art.dashboard.ObjectOperations;
import art.datastructures.BOAttribute;
import art.datastructures.BusinessObject;

public class DatabaseOperations {

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public DatabaseOperations() {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/art_db?"
							+ "user=root&password=1");

			System.out
					.println("Connection Successfull and the DATABASE NAME IS:"
							+ connection.getMetaData().getDatabaseProductName());
		} catch (Exception e) {
			System.out.println("Error in Database Operations :"
					+ e.getMessage());
		}
	}

	public ResultSet executeQuery(String query) {
		try {
			// statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println("Error in Database Operations :"
					+ e.getMessage());
		} finally {
			try {
				// close all connections
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in Database Operations :"
						+ e.getMessage());
			}
		}
		return resultSet;

	}
	
	/***************************************************************************
	 * Method: readBusinessObjectData
	 * 
	 * Purpose: This method takes care of reading a business objects from database
	 * and append to an Arraylist
	 * 
	 * Attributes: objectName - this is the attribute which contains business
	 * object name as provided by user from front end
	 * 
	 * 
	 ****************************************************************************/
	public ArrayList<BusinessObject> readBusinessObjectData(String query) {
		ArrayList<BusinessObject> existingRecords= new ArrayList<BusinessObject>();
		try {
			// statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				existingRecords.add(new BusinessObject(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), null));
			}
		} catch (Exception e) {
			System.out.println("Error in Database Operations :"
					+ e.getMessage());
		} finally {
			try {
				// close all connections
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in Database Operations :"
						+ e.getMessage());
			}
		}
		return existingRecords;

	}
	
	
	
	

	public void updateDB(String query) {
		try {
			System.out.println("Query: "+query);
			// statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			statement.execute(query);
		} catch (Exception e) {
			System.out.println("Error in DatabaseOperations -> updateDB() :"
					+ e.getMessage());
		} finally {
			try {
				// close all connections
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in DatabaseOperations -> updateDB() :"
						+ e.getMessage());
			}
		}

	}
}
