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
	public static void createUser(User _user) throws SQLException{
		DBCon dbc = new DBCon();
		
		System.out.println("INSERT INTO usr(idUser,nme,email) VALUES (" + _user.getId() + ",'" + _user.getName() + "','" + _user.getEmail() + "')");
		String sqlInsertUser = ("INSERT INTO usr(idUser,nme,email) VALUES (" + _user.getId() + ",'" + _user.getName() + "','" + _user.getEmail() + "')");
	
		try{
			dbc.getConnection().createStatement().execute(sqlInsertUser);
		}
		catch(SQLException e){
			//System.out.println(e);
			throw e;
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
	public static void addUsersMessage(Message _myMsg) throws SQLException{
		DBCon dbc = new DBCon();
		String sqlQuery;
		System.out.println("SELECT idUser FROM usr WHERE idUser=" + _myMsg.getUserId());
		sqlQuery = "SELECT idUser FROM usr WHERE idUser=" + _myMsg.getUserId(); 
		
		try{
			Statement st = dbc.con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			
			int counter = 0;
			while (rs.next()){
				counter++;
			}
			if (counter ==1){
				System.out.println("INSERT INTO message(userId,msg) VALUES (" + _myMsg.getUserId() + ",'" + _myMsg.getMsg() + "')");
				String sqlInsertMsg = ("INSERT INTO message(userId,msg) VALUES (" + _myMsg.getUserId() + ",'" + _myMsg.getMsg() + "')");
						
				try{
					dbc.getConnection().createStatement().execute(sqlInsertMsg);
				}
				catch(SQLException e){
					System.out.println(e);
				}
				
			}
			else{
				System.out.println("El usuario no existe.\n");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			dbc.disconnect();
		}
	}
}
