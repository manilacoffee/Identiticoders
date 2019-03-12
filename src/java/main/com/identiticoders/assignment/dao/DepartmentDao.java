package com.identiticoders.assignment.dao;

import java.util.List;

import com.identiticoders.assignment.beans.Department;

public abstract interface DepartmentDao
{
  public abstract void save(Department paramDepartment);
  
  public abstract Department getById(int paramInt);
  
  public abstract void update(Department paramDepartment);
  
  public abstract void deleteById(int paramInt);
  
  public abstract List<Department> getAll();
}
