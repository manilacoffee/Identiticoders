package com.identiticoders.assignment.beans;

import java.sql.Date;

public class Log {
	private int id;
	  private int changed_by;
	  private int changed_to;
	  private String field;
	  private String date;
	  private String action;
	  
	  public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Log() {}
	  
	  public int getId() { return id; }
	  
	  public void setId(int id) {
	    this.id = id;
	  }
	  
	  public int getChanged_by() { return changed_by; }
	  
	  public void setChanged_by(int changed_by) {
	    this.changed_by = changed_by;
	  }
	  
	  public int getChanged_to() { return changed_to; }
	  
	  public void setChanged_to(int changed_to) {
	    this.changed_to = changed_to;
	  }
	  
	  public String getField() { return field; }
	  
	  public void setField(String field) {
	    this.field = field;
	  }
	  
	  public String getDate() { return date; }
	  
	  public void setDate(String date) {
	    this.date = date;
	  }

	@Override
	public String toString() {
		return "Log [id=" + id + ", changed_by=" + changed_by + ", changed_to=" + changed_to + ", field=" + field
				+ ", date=" + date + ", action=" + action + "]";
	}

}
