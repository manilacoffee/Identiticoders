package com.identiticoders.assignment.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.identiticoders.assignment.beans.Department;

public class DepartmentExtractor
  implements ResultSetExtractor<Department>
{
  public Department extractData(ResultSet rs)
    throws SQLException, DataAccessException
  {
    Department department = new Department();
    int id = rs.getInt("id");
    String name = rs.getString("name");
    
    department.setId(id);
    department.setName(name);
    
    return department;
  }
}
