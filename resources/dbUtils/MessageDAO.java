package dbUtils;

import java.sql.*;
import java.util.*;

import basics.*;

/**
 * 
 * @author Fco Javier Pasamontes Moreno
 * Class that manages message's db functionalities
 */

public class MessageDAO {

	/**
	 * 	
	 * @return list with all the messages stored in db
	 */
	public ArrayList<Message> getMsgs(){
		ArrayList<Message> msgList = new ArrayList<Message>();
		
		DBCon dbc = new DBCon();
		
		String sqlSelect = ("SELECT * FROM message");
	
		try{
			ResultSet rsSqlSelect = dbc.getConnection().createStatement().executeQuery(sqlSelect);
			while (rsSqlSelect.next()){
				Message aMsg = null;
				aMsg = new Message(rsSqlSelect.getInt("userId"),rsSqlSelect.getString("msg")); 
				
				msgList.add(aMsg);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		finally{
			dbc.disconnect();
		}
		
		return msgList;
	}
	
	/**
	 * 	
	 * @return list with all the messages stored in db from a concrete user
	 */
	public ArrayList<Message> getMsgsUser(int _idUser){
		ArrayList<Message> msgList = new ArrayList<Message>();
		
		DBCon dbc = new DBCon();
		
		String sqlSelect = ("SELECT * FROM message WHERE userId=" + _idUser);
	
		try{
			ResultSet rsSqlSelect = dbc.getConnection().createStatement().executeQuery(sqlSelect);
			while (rsSqlSelect.next()){
				Message aMsg = null;
				aMsg = new Message(rsSqlSelect.getInt("userId"),rsSqlSelect.getString("msg")); 
				
				msgList.add(aMsg);
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
		finally{
			dbc.disconnect();
		}
		
		return msgList;
	}
}
