package com.identiticoders.assignment.dao;

import java.util.List;

import com.identiticoders.assignment.beans.Role;

public abstract interface RoleDao
{
  public abstract void save(Role paramRole);
  
  public abstract Role getById(int paramInt);
  
  public abstract void update(Role paramRole);
  
  public abstract void deleteById(int paramInt);
  
  public abstract List<Role> getAll();
}
