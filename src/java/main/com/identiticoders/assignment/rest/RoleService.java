package com.identiticoders.assignment.rest;

import com.identiticoders.assignment.beans.Role;
import com.identiticoders.assignment.dao.RoleDao;

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

@Path("/roles")
public class RoleService
{
  @Autowired
  private RoleDao roleDao;
  
  @Path("/getAll")
  @GET
  @Produces({"application/json"})
  public Response getAll()
  {
    List<Role> users = this.roleDao.getAll();
    return Response.status(200).entity(users).build();
  }
  
  @Path("/get/{id}")
  @GET
  @Produces({"application/json"})
  public Response getById(@PathParam("id") int id)
  {
    Role role = this.roleDao.getById(id);
    return Response.status(200).entity(role).build();
  }
  
  @Path("/save")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response save(Role role)
  {
    this.roleDao.save(role);
    return Response.status(200).build();
  }
  
  @Path("/update")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response update(Role role)
  {
    this.roleDao.update(role);
    return Response.status(200).build();
  }
  
  @Path("/delete/{id}")
  @PUT
  @Produces({"application/json"})
  public Response deleteById(@PathParam("id") int id)
  {
    this.roleDao.deleteById(id);
    return Response.status(200).build();
  }
}
