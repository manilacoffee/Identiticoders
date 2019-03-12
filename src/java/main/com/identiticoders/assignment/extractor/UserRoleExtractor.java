package com.identiticoders.assignment.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.identiticoders.assignment.beans.UserRole;

public class UserRoleExtractor
  implements ResultSetExtractor<UserRole>
{
  public UserRole extractData(ResultSet rs)
    throws SQLException, DataAccessException
  {
    UserRole userRole = new UserRole();
    int id = rs.getInt("id");
    int userId = rs.getInt("user_id");
    int roleId = rs.getInt("role_id");
    
    userRole.setId(id);
    userRole.setUserId(userId);
    userRole.setRoleId(roleId);
    
    return userRole;
  }
}
