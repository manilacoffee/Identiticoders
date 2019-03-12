package com.identiticoders.assignment.dao;

import com.identiticoders.assignment.beans.Role;
import com.identiticoders.assignment.mapper.RoleMapper;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImpl
  implements RoleDao
{
  @Autowired
  DataSource dataSource;
  
  public void save(Role role)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "insert into Role(name) values (?)";
    Object[] objs = { role.getName() };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Role saved with name " + role.getName());
    } else {
      System.out.println("Role saved with name " + role.getName());
    }
  }
  
  public Role getById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from role where id = ?";
    Role role = (Role)jdbcTemplate.queryForObject(sql, new Object[] { Integer.valueOf(id) }, new RoleMapper());
    
    return role;
  }
  
  public void update(Role role)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "UPDATE Role SET name=? where id=?";
    Object[] objs = { role.getName(), Integer.valueOf(role.getId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Role updated with id " + role.getId());
    } else {
      System.out.println("Role update failed with id " + role.getId());
    }
  }
  
  public void deleteById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "DELETE FROM Role WHERE id=?";
    int output = jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
    if (output != 0) {
      System.out.println("Role deleted with id " + id);
    } else {
      System.out.println("Role deletion failed with id " + id);
    }
  }
  
  public List<Role> getAll()
  {
    List<Role> roles = new ArrayList();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from role";
    roles = jdbcTemplate.query(sql, new RoleMapper());
    return roles;
  }
}
