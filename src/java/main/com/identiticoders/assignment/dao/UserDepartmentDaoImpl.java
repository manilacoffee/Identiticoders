package com.identiticoders.assignment.dao;

import com.identiticoders.assignment.beans.UserDepartment;
import com.identiticoders.assignment.mapper.UserDepartmentMapper;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDepartmentDao")
public class UserDepartmentDaoImpl
  implements UserDepartmentDao
{
  @Autowired
  DataSource dataSource;
  
  public void save(UserDepartment userDepartment)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "insert into user_department(user_id, role_id) values (?,?)";
    Object[] objs = { Integer.valueOf(userDepartment.getUserId()), Integer.valueOf(userDepartment.getDepartmentId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("UserDepartment saved with id " + userDepartment.getId());
    } else {
      System.out.println("UserDepartment save failed with id " + userDepartment.getId());
    }
  }
  
  public UserDepartment getById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_department where id = ?";
    UserDepartment userDepartment = (UserDepartment)jdbcTemplate.queryForObject(sql, new Object[] { Integer.valueOf(id) }, new UserDepartmentMapper());
    
    return userDepartment;
  }
  
  public List<UserDepartment> getByUserId(int id)
  {
    List<UserDepartment> userDepartment = new ArrayList<UserDepartment>();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_department where user_id = ?";
    userDepartment = jdbcTemplate.query(sql, new Object[] { Integer.valueOf(id) }, new UserDepartmentMapper());
    
    return userDepartment;
  }
  
  public List<UserDepartment> getByDepartmentId(int id)
  {
    List<UserDepartment> userDepartment = new ArrayList<UserDepartment>();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_department where department_id = ?";
    userDepartment = jdbcTemplate.query(sql, new Object[] { Integer.valueOf(id) }, new UserDepartmentMapper());
    
    return userDepartment;
  }
  
  public void update(UserDepartment userDepartment)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "UPDATE user_department SET user_id=?, department_id=? where id=?";
    Object[] objs = { Integer.valueOf(userDepartment.getUserId()), Integer.valueOf(userDepartment.getDepartmentId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("UserDepartment updated with id " + userDepartment.getId());
    } else {
      System.out.println("UserDepartment update failed with id " + userDepartment.getId());
    }
  }
  
  public void deleteById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "DELETE FROM user_department WHERE id=?";
    int output = jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
    if (output != 0) {
      System.out.println("UserRole deleted with id " + id);
    } else {
      System.out.println("UserRole deletion failed with id " + id);
    }
  }
  
  public List<UserDepartment> getAll()
  {
    List<UserDepartment> userDepartment = new ArrayList();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_department";
    userDepartment = jdbcTemplate.query(sql, new UserDepartmentMapper());
    return userDepartment;
  }
}
