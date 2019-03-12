package com.identiticoders.assignment.dao;

import java.util.List;

import com.identiticoders.assignment.beans.User;

public abstract interface UserDao
{
  public abstract void save(User paramUser);
  
  public abstract User getById(int paramInt);
  
  public abstract User getByUserName(String paramString);
  
  public abstract void update(User paramUser);
  
  public abstract void deleteById(int paramInt);
  
  public abstract List<User> getUsersByDepartment(String department);
  
  public abstract List<User> getAll();
}
