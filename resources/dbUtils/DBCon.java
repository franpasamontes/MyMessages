package dbUtils;

import java.sql.*;

/**
 * 
 * @author Fco Javier Pasamontes Moreno
 * Class that manages bd connection
 */

public class DBCon {
	
	private String dbName = "mydb";
	private String login = "root";
	private String password = "";
	private String url="jdbc:mysql://localhost:3306/" + dbName;
	
	Connection connection = null;
	
	//Constructor
	public DBCon(){
		try{
			//MySql Driver's name
			Class.forName("com.mysql.jdbc.Driver");
			
			//Get the connection
			connection = DriverManager.getConnection(url,login,password);
			
			if (connection != null){
				System.out.println("Succesfully BD connection.\n");
			}
		}
		catch (SQLException e){
			System.out.println(e);
		}
		catch (ClassNotFoundException e){
			System.out.println(e);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	//Get and Set methods
	public Connection getConnection(){
		return this.connection;
	}
	
	//Other methods
	public void disconnect(){
		connection = null;
	}

}
