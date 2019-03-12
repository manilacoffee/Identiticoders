package com.identiticoders.assignment.mapper;

import com.identiticoders.assignment.beans.Role;
import com.identiticoders.assignment.extractor.RoleExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoleMapper
  implements RowMapper<Role>
{
  public Role mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    RoleExtractor roleExtractor = new RoleExtractor();
    return roleExtractor.extractData(rs);
  }
}
