package org.biblioteca.model;

public class Publisher {
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZC() {
		return ZC;
	}
	public void setZC(String zC) {
		ZC = zC;
	}
	private String pName;
	private String countrycode;
	private String address;
	private String ZC;
}
