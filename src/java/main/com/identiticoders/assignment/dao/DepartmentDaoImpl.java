package com.identiticoders.assignment.dao;

import com.identiticoders.assignment.beans.Department;
import com.identiticoders.assignment.mapper.DepartmentMapper;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("departmentDao")
public class DepartmentDaoImpl
  implements DepartmentDao
{
  @Autowired
  DataSource dataSource;
  
  public void save(Department department)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "insert into Department(name) values (?)";
    Object[] objs = { department.getName() };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Department saved with name " + department.getName());
    } else {
      System.out.println("Department saved with name " + department.getName());
    }
  }
  
  public Department getById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from department where id = ?";
    Department department = (Department)jdbcTemplate.queryForObject(sql, new Object[] { Integer.valueOf(id) }, new DepartmentMapper());
    
    return department;
  }
  
  public void update(Department department)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "UPDATE Department SET name=? where id=?";
    Object[] objs = { department.getName(), Integer.valueOf(department.getId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Department updated with id " + department.getId());
    } else {
      System.out.println("Department update failed with id " + department.getId());
    }
  }
  
  public void deleteById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "DELETE FROM Department WHERE id=?";
    int output = jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
    if (output != 0) {
      System.out.println("Department deleted with id " + id);
    } else {
      System.out.println("Department deletion failed with id " + id);
    }
  }
  
  public List<Department> getAll()
  {
    List<Department> roles = new ArrayList();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from department";
    roles = jdbcTemplate.query(sql, new DepartmentMapper());
    return roles;
  }
}
