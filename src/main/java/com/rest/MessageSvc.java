package com.rest;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

//import utilities.CSVFormatter;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import basics.*;
import dbUtils.*;

/**
 * 
 * @author Fco Javier Pasamontes Moreno
 *
 */

@Path("/message")
public class MessageSvc {
	
	@POST
	@Path("/viewAll")
	public Response viewAllMessages(){
		
		ArrayList<Message> allMessages;
		allMessages = MessageDAO.getMsgs();
		String show = "ID       Message<br>\n------------------<br><br>\n\n";
		for(Message msg: allMessages){
			show = show + msg.getUserId() + "  " + msg.getMsg() + "<br>\n";
		}

		return Response.status(200).entity(show).build();
	}
	
	@POST
	@Path("/viewUsersMsg")
	public Response viewUsersMessages(@FormParam("id") int _idUser){
		
		ArrayList<Message> allMessages;
		allMessages = MessageDAO.getMsgsUser(_idUser);
		String show = "ID       Message<br>\n------------------<br><br>\n\n";
		for(Message msg: allMessages){
			show = show + msg.getUserId() + "  " + msg.getMsg() + "<br>\n";
		}

		return Response.status(200).entity(show).build();
	}
	
	@POST
	@Path("/AllMsgs.csv")
	public Response exportAllMsgs() throws FileNotFoundException, SQLException{
		
		ArrayList<Message> allMessages;
		allMessages = MessageDAO.getMsgs();
		/*
		CSVFormatter.writeCsvFile("..\\allmsgs", allMessages);
		FileInputStream fis = new FileInputStream("..\\allmsgs");
		
		return Response.status(200).entity(fis).build();
		*/
		
		//<br> tags aren't shown in web browser.
		String show = "ID;Message;<br>\n";
		for(Message msg: allMessages){
			show = show + msg.getUserId() + ";" + msg.getMsg() + ";<br>\n";
		}
		
		return Response.status(200).entity(show).build();
		
	}
	
}
