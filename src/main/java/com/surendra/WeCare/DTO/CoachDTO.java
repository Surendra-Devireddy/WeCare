package com.surendra.WeCare.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CoachDTO {
       private String coachId;
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
       @NotNull(message="{speciality.empty}")
       @Pattern(regexp="[A-Za-z]{5,30}",message="{speciality.invalid}")
       private String speciality;
	public String getCoachId() {
		return coachId;
	}
	public void setCoachId(String coachId) {
		this.coachId = coachId;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
       
       
       
}
