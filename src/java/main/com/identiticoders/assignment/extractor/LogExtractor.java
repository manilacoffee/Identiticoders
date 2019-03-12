package com.identiticoders.assignment.extractor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.identiticoders.assignment.beans.Log;

public class LogExtractor
  implements ResultSetExtractor<Log>
{
  public Log extractData(ResultSet rs)
    throws SQLException, DataAccessException
  {
    Log log = new Log();
    int id = rs.getInt("id");
    int changed_by = rs.getInt("changed_by");
    int changed_to = rs.getInt("changed_to");
    String action = rs.getString("action");
    String field = rs.getString("field");
    String date = rs.getString("date");
    
    log.setId(id);
    log.setChanged_by(changed_by);
    log.setChanged_to(changed_to);
    log.setField(field);
    log.setDate(date);
    log.setAction(action);
    
    return log;
  }
}
