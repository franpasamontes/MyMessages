package com.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

//import utilities.SendEmail;
import basics.*;
import dbUtils.*;

/**
 * 
 * @author Fco Javier Pasamontes Moreno
 *
 */

@Path("/user")
public class UserSvc {
	/*
	public Response addUser(@FormParam("id") int _id,@FormParam("name") String _name,
			@FormParam("email") String _email) {

		return Response.status(200)
				.entity("addUser is called, name : " + _name + ", email : " + _email + ", id : " + _id)
				.build();

	}
	*/
	@POST
	@Path("/add")
	public Response addUser(@FormParam("id") int _idUser, @FormParam("name") String _name, @FormParam("email") String _email){
		
		User myNewUser;
		myNewUser = new User(_idUser,_name,_email);
		System.out.println("addUser is called, name : " + _name + ", email : " + _email + ", id : " + _idUser + "\n");
		System.out.println(myNewUser.getId() + " " + myNewUser.getName() + " " + myNewUser.getEmail() + "\n");
		try{
			
			UserDAO.createUser(myNewUser);
			//If the user is well generated, we send an e-mail
			//SendEmail.sendMail(myNewUser);
		}
		catch(Exception e){
			return Response.status(200).entity("Ya existe un usuario con ese id.").build();
		}
		return Response.status(200).entity("Usuario creado.").build();
	}
	
	@POST
	@Path("/addMessage")
	public Response addMsg(@FormParam("id") int _userId, @FormParam("msg") String _msg){
		
		Message myNewMsg;
		myNewMsg = new Message(_userId,_msg);
		System.out.println("addMessage is called, id : " + _userId + ", msg : " + _msg + "\n");
		System.out.println(myNewMsg.getUserId() + " " + myNewMsg.getMsg() + "\n");
		try{
			
			UserDAO.addUsersMessage(myNewMsg);
			
		}
		catch(Exception e){
			return Response.status(200).entity("Se ha producido un error al guardar el mensaje.").build();
		}
		return Response.status(200).entity("Mensaje creado en el caso de que el usuario existiera.\n").build();
	}
	
}
