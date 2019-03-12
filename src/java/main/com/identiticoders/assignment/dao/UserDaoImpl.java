package com.identiticoders.assignment.dao;

import com.identiticoders.assignment.beans.User;
import com.identiticoders.assignment.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl
  implements UserDao
{
  @Autowired
  DataSource dataSource;
  
  public void save(User user)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "insert into User(name, number, username, department, role) values (?,?,?,?,?)";
    Object[] objs = { user.getName(), user.getNumber(), user.getUsername(), user.getDepartment(), user.getRole() };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Employee saved with id " + user.getUsername());
    } else {
      System.out.println("Employee save failed with id " + user.getUsername());
    }
  }
  
  public User getByUserName(String username)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user where username = ?";
    User user = (User)jdbcTemplate.queryForObject(sql, new Object[] { username }, new UserMapper());
    
    return user;
  }
  
  public User getById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user where id = ?";
    User user = (User)jdbcTemplate.queryForObject(sql, new Object[] { Integer.valueOf(id) }, new UserMapper());
    
    return user;
  }
  
  public void update(User user)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "UPDATE User SET name=?, number=?, username=?, department=?, role=? where id=?";
    Object[] objs = { user.getName(), user.getNumber(), user.getUsername(), user.getDepartment(), user.getRole(), user.getId() };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Employee updated with id " + user.getId());
    } else {
      System.out.println("Employee update failed with id " + user.getId());
    }
  }
  
  public void deleteById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "DELETE FROM User WHERE id=?";
    int output = jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
    if (output != 0) {
      System.out.println("Employee deleted with id " + id);
    } else {
      System.out.println("Employee deletion failed with id " + id);
    }
  }
  
  public List<User> getAll()
  {
    List<User> users = new ArrayList<User>();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from User";
    users = jdbcTemplate.query(sql, new UserMapper());
    return users;
  }
  
  public List<User> getUsersByDepartment(String department)
  {
    List<User> users = new ArrayList<User>();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from User where department = ?";
    users = jdbcTemplate.query(sql, new Object[] { department }, new UserMapper());
    return users;
  }
}
	