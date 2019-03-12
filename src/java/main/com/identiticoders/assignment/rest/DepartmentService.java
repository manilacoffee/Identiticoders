package com.identiticoders.assignment.rest;

import com.identiticoders.assignment.beans.Department;
import com.identiticoders.assignment.dao.DepartmentDao;

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

@Path("/departments")
public class DepartmentService
{
  @Autowired
  private DepartmentDao departmentDao;
  
  @Path("/getAll")
  @GET
  @Produces({"application/json"})
  public Response getAll()
  {
    List<Department> users = this.departmentDao.getAll();
    return Response.status(200).entity(users).build();
  }
  
  @Path("/get/{id}")
  @GET
  @Produces({"application/json"})
  public Response getById(@PathParam("id") int id)
  {
    Department department = this.departmentDao.getById(id);
    return Response.status(200).entity(department).build();
  }
  
  @Path("/save")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response save(Department department)
  {
    this.departmentDao.save(department);
    return Response.status(200).build();
  }
  
  @Path("/update")
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  public Response update(Department department)
  {
    this.departmentDao.update(department);
    return Response.status(200).build();
  }
  
  @Path("/delete/{id}")
  @PUT
  @Produces({"application/json"})
  public Response deleteById(@PathParam("id") int id)
  {
    this.departmentDao.deleteById(id);
    return Response.status(200).build();
  }
}
