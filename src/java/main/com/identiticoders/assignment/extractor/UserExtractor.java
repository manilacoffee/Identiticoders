package com.identiticoders.assignment.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.identiticoders.assignment.beans.User;

public class UserExtractor
  implements ResultSetExtractor<User>
{
  public User extractData(ResultSet rs)
    throws SQLException, DataAccessException
  {
    User user = new User();
    int id = rs.getInt("id");
    String name = rs.getString("name");
    String number = rs.getString("number");
    String username = rs.getString("username");
    String department = rs.getString("department");
    String role = rs.getString("role");
    
    user.setId(id);
    user.setName(name);
    user.setNumber(number);
    user.setUsername(username);
    user.setDepartment(department);
    user.setRole(role);
    
    return user;
  }
}
