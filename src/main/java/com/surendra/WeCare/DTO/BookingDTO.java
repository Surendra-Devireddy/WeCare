package com.surendra.WeCare.DTO;

import java.time.LocalDate;

public class BookingDTO {
     private int bookingId;
     private String userId;
     private String caochId;
     private LocalDate appointmentDate;
     private String slot;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCaochId() {
		return caochId;
	}
	public void setCoachId(String caochId) {
		this.caochId = caochId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
     
     
}
