package com.identiticoders.assignment.dao;

import java.util.List;

import com.identiticoders.assignment.beans.UserDepartment;

public abstract interface UserDepartmentDao
{
  public abstract void save(UserDepartment paramUserDepartment);
  
  public abstract UserDepartment getById(int paramInt);
  
  public abstract List<UserDepartment> getByUserId(int paramInt);
  
  public abstract List<UserDepartment> getByDepartmentId(int paramInt);
  
  public abstract void update(UserDepartment paramUserDepartment);
  
  public abstract void deleteById(int paramInt);
  
  public abstract List<UserDepartment> getAll();
}
