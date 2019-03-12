package com.identiticoders.assignment.mapper;

import com.identiticoders.assignment.beans.Department;
import com.identiticoders.assignment.extractor.DepartmentExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DepartmentMapper
  implements RowMapper<Department>
{
  public Department mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    DepartmentExtractor departmentExtractor = new DepartmentExtractor();
    return departmentExtractor.extractData(rs);
  }
}
