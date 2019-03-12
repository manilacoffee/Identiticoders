package com.identiticoders.assignment.mapper;

import com.identiticoders.assignment.beans.Log;
import com.identiticoders.assignment.extractor.LogExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LogMapper
  implements RowMapper<Log>
{
  public Log mapRow(ResultSet rs, int rowNum)
    throws SQLException
  {
    LogExtractor logExtractor = new LogExtractor();
    return logExtractor.extractData(rs);
  }
}
