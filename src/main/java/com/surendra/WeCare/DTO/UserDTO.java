package com.surendra.WeCare.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;

public class UserDTO {
	 private String userId;
	 @NotNull(message="{password.empty}")
     @Pattern(regexp="[a-zA-Z0-9]{5,10}",message="{password.invalid}")
     private String password;
	 @NotNull(message="{name.empty}")
     @Pattern(regexp="[A-Za-z]{5,30}",message="{name.invalid}")
     private String name;
     private char gender;
     private LocalDate dateOfBirth;
     @NotNull(message="{mobilenumber.empty}")
     @Pattern(regexp="[0-9]{10}",message="{mobilenumber.invalid}")
     private long mobileNumber;
     @NotNull(message="{email.empty}")
     @Email(message="{email.invalid}")
     private String email;
     @NotNull(message="{pincode.empty}")
     @Pattern(regexp="[0-9]{6}",message="{pincode.invalid}")
     private int pincode;
     @NotNull(message="{city.empty}")
     @Pattern(regexp="[A-Za-z]{5,30}",message="{city.invalid}")
     private String city;
     @NotNull(message="{state.empty}")
     @Pattern(regexp="[A-Za-z]{5,30}",message="{state.invalid}")
     private String state;
     @NotNull(message="{country.empty}")
     @Pattern(regexp="[A-Za-z]{5,30}",message="{country.invalid}")
     private String country;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
     
     
}
