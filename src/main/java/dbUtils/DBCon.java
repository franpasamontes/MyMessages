package dbUtils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * 
 * @author Fco Javier Pasamontes Moreno
 * Class that manages bd connection
 */

public class DBCon {
	Connection con = null;
	
	//Constructor
	public DBCon(){
		
		
		String dbName = "mydb";
		String login = "root";
		String password = "root";
		String url="jdbc:mysql://localhost:3306/" + dbName;
		
		try{
			//MySql Driver's name
			Class.forName("com.mysql.jdbc.Driver");
			
			//Get the connection
			con = DriverManager.getConnection(url,login,password);
			
			if (con != null){
				System.out.println("Succesfully DB connection.\n");
			}
			else{
				System.out.println("Wrong DB connection.\n");
			}
		}
		catch (SQLException e){
			System.out.println("DBCon SQLEx: " + e);
		}
		catch (ClassNotFoundException e){
			System.out.println("DBCon ClassNotFoundEx: " + e);
		}
		catch (Exception e){
			System.out.println("DBCon Ex: " + e);
		}
	}
	
	//Get and Set methods
	public Connection getConnection(){
		return this.con;
	}
	
	//Other methods
	public void disconnect(){
		this.con = null;
	}

}
