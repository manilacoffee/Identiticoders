package com.identiticoders.assignment.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.identiticoders.assignment.beans.Role;

public class RoleExtractor
  implements ResultSetExtractor<Role>
{
  public Role extractData(ResultSet rs)
    throws SQLException, DataAccessException
  {
    Role role = new Role();
    int id = rs.getInt("id");
    String name = rs.getString("name");
    
    role.setId(id);
    role.setName(name);
    
    return role;
  }
}
