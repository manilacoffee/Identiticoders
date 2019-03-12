package com.identiticoders.assignment.rest;

import com.identiticoders.assignment.beans.UserDepartment;
import com.identiticoders.assignment.dao.UserDepartmentDao;

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

@Path("/userDepartments")
public class UserDepartmentService
{
  @Autowired
  private UserDepartmentDao userDepartmentDao;
  
  @Path("/getAll")
  @GET
  @Produces({"application/json"})
  public Response getAll()
  {
    List<UserDepartment> users = this.userDepartmentDao.getAll();
    return Response.status(200).entity(users).build();
  }
  
  @Path("/get/{id}")
  @GET
  @Produces({"application/json"})
  public Response getById(@PathParam("id") int id)
  {
    UserDepartment userDepartment = this.userDepartmentDao.getById(id);
    return Response.status(200).entity(userDepartment).build();
  }
  
  @Path("/getByUserId/{userId}")
  @GET
  @Produces({"application/json"})
  public Response getByUserId(@PathParam("userId") int userId)
  {
    List<UserDepartment> userDepartment = this.userDepartmentDao.getByUserId(userId);
    return Response.status(200).entity(userDepartment).build();
  }
  
 @Path("/getByDepartmentId/{departmentId}")
  @GET
  @Produces({"application/json"})
  public Response getByDepartmentId(@PathParam("departmentId") int departmentId)
  {
    List<UserDepartment> userDepartment = this.userDepartmentDao.getByDepartmentId(departmentId);
    return Response.status(200).entity(userDepartment).build();
  }
  
  @Path("/save")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response save(UserDepartment userDepartment)
  {
    this.userDepartmentDao.save(userDepartment);
    return Response.status(200).build();
  }
  
  @Path("/update")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response update(UserDepartment userDepartment)
  {
    this.userDepartmentDao.update(userDepartment);
    return Response.status(200).build();
  }
  
  @Path("/delete/{id}")
  @PUT
  @Produces({"application/json"})
  public Response deleteById(@PathParam("id") int id)
  {
    this.userDepartmentDao.deleteById(id);
    return Response.status(200).build();
  }
}
