package com.identiticoders.assignment.mapper;

import com.identiticoders.assignment.beans.UserRole;
import com.identiticoders.assignment.extractor.UserRoleExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRoleMapper
  implements RowMapper<UserRole>
{
  public UserRole mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    UserRoleExtractor userRoleExtractor = new UserRoleExtractor();
    return userRoleExtractor.extractData(rs);
  }
}
