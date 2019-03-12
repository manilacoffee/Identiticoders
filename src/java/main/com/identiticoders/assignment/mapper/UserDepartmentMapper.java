package com.identiticoders.assignment.mapper;

import com.identiticoders.assignment.beans.UserDepartment;
import com.identiticoders.assignment.extractor.UserDepartmentExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserDepartmentMapper
  implements RowMapper<UserDepartment>
{
  public UserDepartment mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    UserDepartmentExtractor userDepartmentExtractor = new UserDepartmentExtractor();
    return userDepartmentExtractor.extractData(rs);
  }
}
