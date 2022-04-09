package com.model;

import java.util.Date;

public class User {
	private String name;
	private int rollno;
	private String lname;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
public void setLname(String lname)
{
	this.lname= lname;
}
public String getLname()
{
	return lname;
	
}
	@Override
	public String toString() {
		return ""+name+""+rollno+""+lname;
	}
}
