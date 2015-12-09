package com.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/userEx")
public class UserServiceExample {

	@POST
	@Path("/add")
	/*
	 * <p>Identificador: <input type="text" name="id"/></p>
		<p>Nombre: <input type="text" name="name"/></p>
		<p>E-mail: <input type="text" name="email"/></p>
	 * */
	
	public Response addUser(@FormParam("id") int _id,@FormParam("name") String _name,
			@FormParam("email") String _email) {

		return Response.status(200)
				.entity("addUser is called, name : " + _name + ", email : " + _email + ", id : " + _id)
				.build();

	}

}