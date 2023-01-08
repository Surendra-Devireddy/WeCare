package com.surendra.WeCare.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surendra.WeCare.Exception.WeCareException;
import com.surendra.WeCare.Service.BookService;

@RestController
@RequestMapping
@Validated
@CrossOrigin
public class BookRestController {
  
	@Autowired
	private BookService bService;
	
	@PostMapping(value="/users/{userId}/booking/{coachId}",consumes="application/json")
	public ResponseEntity<Boolean> bookAppointment(@PathVariable("userId")String userId, @PathVariable("coachId") String coachId, 
			@RequestBody String slot, @RequestBody LocalDate dateOfAppointment) throws WeCareException{
		boolean s=bService.bookAppointment(userId, coachId, dateOfAppointment, slot);
		return new ResponseEntity<Boolean>(s, HttpStatus.OK);
	}
	
	@PutMapping(value="/booking/{bookingId}")
	public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Integer bookingId,@RequestBody String slot, 
			@RequestBody LocalDate dateOfAppointment) throws WeCareException{
		boolean s = bService.rescheduleAppointment(bookingId, dateOfAppointment, slot);
		return new ResponseEntity<Boolean>(s,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/booking/{bookingId}")
	public ResponseEntity<?> cancelAppointment(@PathVariable Integer bookingId) throws WeCareException{
		bService.cancelAppointment(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
