package com.identiticoders.assignment.dao;

import com.identiticoders.assignment.beans.Log;
import com.identiticoders.assignment.mapper.LogMapper;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("logDao")
public class LogDaoImpl
  implements LogDao
{
  @Autowired
  DataSource dataSource;
  
  public void save(Log log)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "insert into logs(changed_by, changed_to, action, field, date) values (?,?,?,?,?)";
    Object[] objs = {log.getChanged_by(), log.getChanged_to(), log.getAction(), log.getField(), log.getDate() };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Log saved with date " + log.getDate());
    } else {
      System.out.println("Log saved with date " + log.getDate());
    }
  }
  
  public Log getById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from logs where id = ?";
    Log log = (Log)jdbcTemplate.queryForObject(sql, new Object[] { Integer.valueOf(id) }, new LogMapper());
    
    return log;
  }
  
  public void deleteById(int id)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "DELETE FROM logs WHERE id=?";
    int output = jdbcTemplate.update(sql, new Object[] { Integer.valueOf(id) });
    if (output != 0) {
      System.out.println("Log deleted with id " + id);
    } else {
      System.out.println("Log deletion failed with id " + id);
    }
  }
  
  public List<Log> getAll()
  {
    List<Log> logs = new ArrayList<Log>();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "select * from logs";
    logs = jdbcTemplate.query(sql, new LogMapper());
    return logs;
  }
  
  public void update(Log log)
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = "UPDATE Logs SET changed_by=?,changed_to=?,field=?,date=? where id=?";
    Object[] objs = { log.getChanged_by(), log.getChanged_to(), log.getAction(), log.getField(), log.getDate(), Integer.valueOf(log.getId()) };
    int output = jdbcTemplate.update(sql, objs);
    if (output != 0) {
      System.out.println("Log updated with id " + log.getId());
    } else {
      System.out.println("Log update failed with id " + log.getId());
    }
  }
}
