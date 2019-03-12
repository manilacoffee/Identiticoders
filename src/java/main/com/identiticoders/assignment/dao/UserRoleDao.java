package com.identiticoders.assignment.dao;

import java.util.List;

import com.identiticoders.assignment.beans.UserRole;

public abstract interface UserRoleDao
{
  public abstract void save(UserRole paramUserRole);
  
  public abstract UserRole getById(int paramInt);
  
  public abstract List<UserRole> getByUserId(int paramInt);
  
  public abstract List<UserRole> getByRoleId(int paramInt);
  
  public abstract void update(UserRole paramUserRole);
  
  public abstract void deleteById(int paramInt);
  
  public abstract List<UserRole> getAll();
}
	