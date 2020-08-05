package com.AddressBook.demo.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.AddressBook.demo.model.Address;

public class AddressDTO {

	
	@NotBlank(message = "First name should not be blank")
	String firstName;
	@NotBlank(message = "Last name should not be blank")
	String lastName;
	@NotBlank(message = "Address should not be blank")
	String address;
	@NotBlank(message = "City should not be blank")
	String city;
	@NotBlank(message = "State should not be blank")
	String state;
	
	@Pattern(regexp ="[0-9]{6}",message = "Zip should be six digits and only numeric")
	String zip;
	
	
	@Pattern(regexp ="[0-9]{10}",message = "Mobile number should be ten digits and only numeric")
	String phoneNo;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public Address valueOf() {
		Address address = new Address();
		address.setFirstName(this.firstName);
		address.setLastName(this.lastName);
		address.setAddress(this.address);
		address.setCity(this.city);
		address.setState(this.state);
		address.setZip(this.zip);
		address.setPhoneNo(this.phoneNo);
		return address;
	
	}
	
}
