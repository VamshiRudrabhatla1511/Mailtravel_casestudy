package com.mailTravel.vo;

public class ContactDetailsVO {
	private String contactName;
	private String phone;
	private String email;
	private String addressLine1;
	private String city;
	private String postcode;
	
	public ContactDetailsVO(String contactName, String phone, String email, String addressLine1, String city,
			String postcode) {
		super();
		this.contactName = contactName;
		this.phone = phone;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.postcode = postcode;
	}
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	

}
