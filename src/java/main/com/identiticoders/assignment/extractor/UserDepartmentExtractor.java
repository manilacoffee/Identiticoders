package com.identiticoders.assignment.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.identiticoders.assignment.beans.UserDepartment;

public class UserDepartmentExtractor
  implements ResultSetExtractor<UserDepartment>
{
  public UserDepartment extractData(ResultSet rs)
    throws SQLException, DataAccessException
  {
    UserDepartment userDepartment = new UserDepartment();
    int id = rs.getInt("id");
    int userId = rs.getInt("user_id");
    int departmentId = rs.getInt("department_id");
    
    userDepartment.setId(id);
    userDepartment.setUserId(userId);
    userDepartment.setDepartmentId(departmentId);
    
    return userDepartment;
  }
}
