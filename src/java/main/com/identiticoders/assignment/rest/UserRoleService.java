package com.identiticoders.assignment.rest;

import com.identiticoders.assignment.beans.UserRole;
import com.identiticoders.assignment.dao.UserRoleDao;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/userRoles")
public class UserRoleService
{
  @Autowired
  private UserRoleDao userRoleDao;
  
  @Path("/getAll")
  @GET
  @Produces({"application/json"})
  public Response getAll()
  {
    List<UserRole> users = this.userRoleDao.getAll();
    return Response.status(200).entity(users).build();
  }
  
  @Path("/get/{id}")
  @GET
  @Produces({"application/json"})
  public Response getById(@PathParam("id") int id)
  {
    UserRole userRole = this.userRoleDao.getById(id);
    return Response.status(200).entity(userRole).build();
  }
  
  @Path("/getByUserId/{id}")
  @GET
  @Produces({"application/json"})
  public Response getByUserId(@PathParam("id") int id)
  {
    List<UserRole> userRole = this.userRoleDao.getByUserId(id);
    return Response.status(200).entity(userRole).build();
  }
  
  @Path("/getByRoleId/{id}")
  @GET
  @Produces({"application/json"})
  public Response getByRoleId(@PathParam("id") int id)
  {
    List<UserRole> userRole = this.userRoleDao.getByRoleId(id);
    return Response.status(200).entity(userRole).build();
  }
  
  @Path("/save")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response save(UserRole userRole)
  {
    this.userRoleDao.save(userRole);
    return Response.status(200).build();
  }
  
  @Path("/update")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response update(UserRole userRole)
  {
    this.userRoleDao.update(userRole);
    return Response.status(200).build();
  }
  
  @Path("/delete/{id}")
  @PUT
  @Produces({"application/json"})
  public Response deleteById(@PathParam("id") int id)
  {
    this.userRoleDao.deleteById(id);
    return Response.status(200).build();
  }
}
