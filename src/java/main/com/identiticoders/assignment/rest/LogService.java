package com.identiticoders.assignment.rest;

import com.identiticoders.assignment.beans.Log;
import com.identiticoders.assignment.beans.User;
import com.identiticoders.assignment.dao.LogDao;

import java.sql.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

@Path("/logs")
public class LogService
{
  @Autowired
  private LogDao logDao;
  
  @Path("/getAll")
  @GET
  @Produces({"application/json"})
  public Response getAll()
  {
    List<Log> logs = this.logDao.getAll();
    return Response.status(200).entity(logs).build();
  }
  
  @Path("/get/{id}")
  @GET
  @Produces({"application/json"})
  public Response getById(@PathParam("id") int id)
  {
    Log log = this.logDao.getById(id);
    return Response.status(200).entity(log).build();
  }
  
  @Path("/save")
  @POST
  @Consumes({"text/plain"})
  @Produces({"application/json"})
  public Response save(@QueryParam ("changed_by") int changed_by,
			@QueryParam ("changed_to") int changed_to,
			@QueryParam ("action") String action,
			@QueryParam ("field") String field)
  {
	Log log = new Log();
	log.setAction(action);
	log.setChanged_by(changed_by);
	log.setChanged_to(changed_to);
	log.setField(field);
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentTime = sdf.format(dt);
	log.setDate(currentTime);
    
	try {
		this.logDao.save(log);
	    return Response.status(200).build();
    } catch(Exception exception) {
    	return Response.status(500).entity(null).build();
    }
	
	
  }

  
  @Path("/update")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response update(@QueryParam ("id") int id,
		  @QueryParam ("changed_by") int changed_by,
			@QueryParam ("changed_to") int changed_to,
			@QueryParam ("action") String action,
			@QueryParam ("field") String field)
  {
    
	Log log = new Log();
	log.setId(id);
	log.setAction(action);
	log.setChanged_by(changed_by);
	log.setChanged_to(changed_to);
	log.setField(field);
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentTime = sdf.format(dt);
	log.setDate(currentTime);
    this.logDao.save(log);
    this.logDao.update(log);
    return Response.status(200).build();
  }
  
  @Path("/delete/{id}")
  @PUT
  @Produces({"application/json"})
  public Response deleteById(@PathParam("id") int id)
  {
    this.logDao.deleteById(id);
    return Response.status(200).build();
  }
}
