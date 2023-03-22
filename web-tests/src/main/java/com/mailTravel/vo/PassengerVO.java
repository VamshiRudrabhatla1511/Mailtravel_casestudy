package com.mailTravel.vo;

public class PassengerVO {
	private String title;
	private String firstName;
	private String lastName;
	private String dob_date;
	private String dob_month;
	private String dob_year;
	
	public PassengerVO(String title,String firstName,String lastName, String dob_date, 
			String dob_month,String dob_year ) {
		super();
		this.title = title;
		this.firstName= firstName;
		this.lastName = lastName;
		this.dob_date = dob_date;
		this.dob_month = dob_month;
		this.dob_year = dob_year;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob_date() {
		return dob_date;
	}
	public void setDob_date(String dob_date) {
		this.dob_date = dob_date;
	}
	public String getDob_month() {
		return dob_month;
	}
	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}
	public String getDob_year() {
		return dob_year;
	}
	public void setDob_year(String dob_year) {
		this.dob_year = dob_year;
	}
	
	
}
