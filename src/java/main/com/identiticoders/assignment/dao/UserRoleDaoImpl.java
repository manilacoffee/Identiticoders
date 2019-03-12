package com.identiticoders.assignment.dao;

import com.identiticoders.assignment.beans.UserRole;
import com.identiticoders.assignment.mapper.UserRoleMapper;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userRoleDao")
public class UserRoleDaoImpl
  implements UserRoleDao
{
  @Autowired
  DataSource dataSource;
  
  public void save(UserRole userRole)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "insert into user_role(user_id, role_id) values (?,?)";
    Object[] objs = { Integer.valueOf(userRole.getUserId()), Integer.valueOf(userRole.getRoleId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("UserRole saved with id " + userRole.getId());
    } else {
      System.out.println("UserRole save failed with id " + userRole.getId());
    }
  }
  
  public UserRole getById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_role where id = ?";
    UserRole userRole = (UserRole)jdbcTemplate.queryForObject(sql, new Object[] { Integer.valueOf(id) }, new UserRoleMapper());
    
    return userRole;
  }
  
  public List<UserRole> getByUserId(int id)
  {
    List<UserRole> userRoles = new ArrayList<UserRole>();
    
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_role where user_id = ?";
    userRoles = jdbcTemplate.query(sql, new Object[] { Integer.valueOf(id) }, new UserRoleMapper());
    
    return userRoles;
  }
  
  public List<UserRole> getByRoleId(int id)
  {
    List<UserRole> userRoles = new ArrayList<UserRole>();
    
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_role where role_id = ?";
    userRoles = jdbcTemplate.query(sql, new Object[] { Integer.valueOf(id) }, new UserRoleMapper());
    
    return userRoles;
  }
  
  public void update(UserRole userRole)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "UPDATE User SET user_id=?, role_id=? where id=?";
    Object[] objs = { Integer.valueOf(userRole.getUserId()), Integer.valueOf(userRole.getRoleId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("UserRole updated with id " + userRole.getId());
    } else {
      System.out.println("UserRole update failed with id " + userRole.getId());
    }
  }
  
  public void deleteById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "DELETE FROM user_role WHERE id=?";
    int output = jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
    if (output != 0) {
      System.out.println("UserRole deleted with id " + id);
    } else {
      System.out.println("UserRole deletion failed with id " + id);
    }
  }
  
  public List<UserRole> getAll()
  {
    List<UserRole> userRoles = new ArrayList<UserRole>();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from user_role";
    userRoles = jdbcTemplate.query(sql, new UserRoleMapper());
    return userRoles;
  }
}
