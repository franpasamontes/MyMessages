package dbUtils;

import java.sql.*;
import basics.*;

/**
 * 
 * @author Fco Javier Pasamontes Moreno
 * Class that manages user's db functionalities
 */

public class UserDAO extends DBCon{
	
	/**
	 * User's db generation
	 * @param _user
	 */
	public void createUser(User _user){
		DBCon dbc = new DBCon();
		
		String sqlInsertUser = ("INSERT INTO user(idUser,name,email) VALUES (" + _user.getId() + ",'" + _user.getName() + "','" + _user.getEmail() + "')");
	
		try{
			dbc.getConnection().createStatement().execute(sqlInsertUser);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		finally{
			dbc.disconnect();
		}
	}

	/**
	 * Message's db generation
	 * @param _idUser
	 * @param _msg
	 */
	public void addUsersMessage(int _idUser, String _msg){
		DBCon dbc = new DBCon();
		
		String sqlInsertUser = ("INSERT INTO message(userId,msg) VALUES (" + _idUser + ",'" + _msg + "')");
				
		try{
			dbc.getConnection().createStatement().execute(sqlInsertUser);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		finally{
			dbc.disconnect();
		}
	}
}
