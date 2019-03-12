package com.identiticoders.assignment.rest;

import com.identiticoders.assignment.beans.User;
import com.identiticoders.assignment.dao.UserDao;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

@Path("/users")
public class UserService
{
  @Autowired
  private UserDao userDao;
  
  @Path("/getAll")
  @GET
  @Produces({"application/json"})
  public Response getAll()
  {
    List<User> users = this.userDao.getAll();
    return Response.status(200).entity(users).build();
  }
  
  @Path("/get/{id}")
  @GET
  @Produces({"application/json"})
  public Response getById(@PathParam("id") int id)
  {
	  
    try {
    	User user = this.userDao.getById(id);
    	return Response.status(200).entity(user).build();
    } catch(EmptyResultDataAccessException exception) {
    	return Response.status(404).entity(null).build();
    }
    
  }
  
  @Path("/getByUsername/{username}")
  @GET
  @Produces({"application/json"})
  public Response getByUsername(@PathParam("username") String username)
  {
	  	try {
		  User user = this.userDao.getByUserName(username);
		    return Response.status(200).entity(user).build();
	    } catch(EmptyResultDataAccessException exception) {
	    	return Response.status(404).entity(null).build();
	    }
  }
  
  @Path("/save")
  @POST
  @Consumes({"text/plain"})
  @Produces({"application/json"})
  public Response save(@QueryParam ("name") String name,
		  				@QueryParam ("number") String number,
		  				@QueryParam ("username") String username,
		  				@QueryParam ("department") String department,
		  				@QueryParam ("role") String role)
  {
	User user = new User();
	user.setName(name);
	user.setNumber(number);
	user.setUsername(username);
	user.setDepartment(department);
	user.setRole(role);
	
    try {
    	this.userDao.save(user);
        return Response.status(200).build();
	    } catch(Exception exception) {
	    	return Response.status(500).entity(null).build();
	    }
  }
  
  @Path("/update")
  @PUT
  @Consumes({"text/plain"})
  @Produces({"application/json"})
  public Response update(@QueryParam ("id") int id,
		  	@QueryParam ("name") String name,
			@QueryParam ("number") String number,
			@QueryParam ("username") String username,
			@QueryParam ("department") String department,
			@QueryParam ("role") String role)
  {
	User user = this.userDao.getById(id);
	user.setName(name);
	user.setNumber(number);
	user.setUsername(username);
	user.setDepartment(department);
	user.setRole(role);
	
	try {
		this.userDao.update(user);
	    return Response.status(200).build();
	} catch(Exception exception) {
		return Response.status(500).entity(null).build();
	}
	
    
  }
  
  @Path("/delete/{id}")
  @DELETE
  @Produces({"application/json"})
  public Response deleteById(@PathParam("id") int id)
  {
	  try {
		  this.userDao.deleteById(id);
		    return Response.status(200).build();
		} catch(Exception exception) {
			return Response.status(500).entity(null).build();
		}
    
  }
  
  @Path("/getUsersByDepartment/{department}")
  @GET
  @Produces({"application/json"})
  public Response getByDepartmentId(@PathParam("department") String department)
  {   
    try {
    	 List<User> userDepartment = this.userDao.getUsersByDepartment(department);
    	 return Response.status(200).entity(userDepartment).build();
		} catch(EmptyResultDataAccessException exception) {
		 return Response.status(404).entity(null).build();
		}
  }
}
