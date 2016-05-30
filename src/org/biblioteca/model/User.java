package org.biblioteca.model;

public class User {
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCName() {
		return cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOCR() {
		return OCR;
	}
	public void setOCR(String oCR) {
		OCR = oCR;
	}
	private int ID;
	private String cName;
	private String lastName;
	private String OCR;
}
