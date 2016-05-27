package org.biblioteca.model;

import java.sql.Date;

public class Author {
	private int ID;
	private String aName;
	private String lastName;
	private Date DOB;
	private String nationality;
	
	
	public Integer getID() {
		return this.ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getAName() {
		return aName;
	}
	public void setAName(String aName) {
		this.aName = aName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}
