package com.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import basics.User;
import dbUtils.UserDAO;

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
		
		User myNewUser = new User(_idUser,_name,_email);
	
		try{
			UserDAO.createUser(myNewUser);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return Response.status(200).entity("Usuario creado").build();
	}
	
	
	
}
