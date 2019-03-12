package com.identiticoders.assignment.dao;

import java.util.List;

import com.identiticoders.assignment.beans.Log;

public abstract interface LogDao
{
  public abstract void save(Log paramLog);
  
  public abstract Log getById(int paramInt);
  
  public abstract void update(Log paramLog);
  
  public abstract void deleteById(int paramInt);
  
  public abstract List<Log> getAll();
}