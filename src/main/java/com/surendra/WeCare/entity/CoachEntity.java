package com.surendra.WeCare.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

//import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name="coachtable")
public class CoachEntity {
	
	@Id
    @GeneratedValue(generator = "coach-generator")
    @GenericGenerator(name = "coach-generator", 
      strategy = "com.surendra.WeCare.Utility.CoachIdGenerator")
	 private String coachId;
     private String password;
     private String name;
     private char gender;
     private LocalDate dateOfBirth;
     private long mobileNumber;
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
