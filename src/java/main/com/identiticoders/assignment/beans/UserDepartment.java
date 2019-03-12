package com.identiticoders.assignment.beans;

	public class UserDepartment {
		  private int id;
		  private int userId;
		  private int departmentId;
		  
		  public UserDepartment() {}
		  
		  public int getDepartmentId() {
		    return departmentId;
		  }
		  
		  public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
		  
		  public int getId() {
		    return id;
		  }
		  
		  public void setId(int id) { this.id = id; }
		  
		  public int getUserId() {
		    return userId;
		  }
		  
		  public void setUserId(int userId) { this.userId = userId; }
		  
		  public String toString()
		  {
		    return "UserDepartment [id=" + id + ", userId=" + userId + ", departmentId=" + departmentId + "]";
		  }
}
