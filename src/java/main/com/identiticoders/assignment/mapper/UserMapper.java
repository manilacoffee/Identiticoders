package com.identiticoders.assignment.mapper;

import com.identiticoders.assignment.beans.User;
import com.identiticoders.assignment.extractor.UserExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper
  implements RowMapper<User>
{
  public User mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    UserExtractor userExtractor = new UserExtractor();
    return userExtractor.extractData(rs);
  }
}
