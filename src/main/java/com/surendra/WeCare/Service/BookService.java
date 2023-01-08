package com.surendra.WeCare.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surendra.WeCare.DTO.BookingDTO;
import com.surendra.WeCare.Exception.WeCareException;
import com.surendra.WeCare.Repository.BookRepository;
import com.surendra.WeCare.Repository.UserRepository;
import com.surendra.WeCare.Utility.MailUtility;
import com.surendra.WeCare.entity.BookingEntity;
import com.surendra.WeCare.entity.UserEntity;

@Service(value="bService")
public class BookService {
   
	@Autowired
	private BookRepository bRep;
	@Autowired
	private UserRepository uRep;
	@Autowired
	private MailUtility mail;
	
	public boolean bookAppointment(String userId, String coachId, LocalDate appointmentDate, String slot) throws WeCareException {
		
		BookingEntity book=bRep.findAllBookings(userId, appointmentDate, slot);
		
		Optional<UserEntity> u= uRep.findById(userId);
		UserEntity u1= u.orElseThrow(()-> new WeCareException("NO_USER_EXISTS"));
		
		if(book!=null) {
			throw new WeCareException("BOOKING_ALREADY_EXISTS");
		}else {
			BookingEntity b = new BookingEntity();
			b.setUserId(userId);
			b.setCoachId(coachId);
			b.setSlot(slot);
			b.setAppointmentDate(appointmentDate);
			BookingEntity b1=bRep.save(b);
			mail.sendSchedulingEmail(userId, coachId, u1.getEmail(), b1.getBookingId(), slot, appointmentDate);
			return true;
		}
	}
	
	public boolean rescheduleAppointment(Integer bookingId, LocalDate appointmentDate, String slot) throws WeCareException {
		Optional<BookingEntity> op= bRep.findById(bookingId);
		BookingEntity b= op.orElseThrow(()-> new WeCareException("NO_BOOKING_EXISTS"));
		
		Optional<UserEntity> u= uRep.findById(b.getUserId());
		UserEntity u1= u.orElseThrow(()-> new WeCareException("NO_USER_EXISTS"));
		
		BookingEntity book=bRep.findAllBookings(b.getUserId(), appointmentDate, slot);
		if(book!=null) {
			throw new WeCareException("BOOKING_ALREADY_EXISTS");
		}else {
			BookingEntity b1 = new BookingEntity();
			b1.setUserId(b.getUserId());
			b1.setCoachId(b.getCoachId());
			b1.setSlot(slot);
			b1.setAppointmentDate(appointmentDate);
			BookingEntity b2=bRep.save(b);
			mail.sendSchedulingEmail(b.getUserId(), b.getCoachId(), u1.getEmail(), b2.getBookingId(), slot, appointmentDate);
			return true;
		}
	}
	
	public void cancelAppointment(Integer bookingId) throws WeCareException {
		Optional<BookingEntity> op= bRep.findById(bookingId);
		BookingEntity b= op.orElseThrow(()-> new WeCareException("NO_BOOKING_EXISTS"));
		
		Optional<UserEntity> u= uRep.findById(b.getUserId());
		UserEntity u1= u.orElseThrow(()-> new WeCareException("NO_USER_EXISTS"));
		
		bRep.deleteById(bookingId);
		mail.sendCancellingEmail(b.getUserId(), b.getCoachId(), u1.getEmail(), bookingId, b.getSlot(), b.getAppointmentDate());
	}
	
	public BookingDTO findByBookingId(Integer bookingId) throws WeCareException {
		
		Optional<BookingEntity> op=bRep.findById(bookingId);
		BookingEntity s=op.orElseThrow(()-> new WeCareException("BOOKING_ID_NOT_FOUND"));
		BookingDTO b= new BookingDTO();
		b.setBookingId(s.getBookingId());
		b.setAppointmentDate(s.getAppointmentDate());
		b.setSlot(s.getSlot());
		b.setCoachId(s.getCoachId());
		b.setUserId(s.getUserId());
		return b;
	}
	
   public List<BookingDTO> findBookingByUserId(String userId) {
		List<BookingEntity> l= bRep.findBookingByUserId(userId, LocalDate.now());
		List<BookingDTO> list= new ArrayList<>();
		l.forEach((s)->{
		BookingDTO b= new BookingDTO();
		b.setBookingId(s.getBookingId());
		b.setAppointmentDate(s.getAppointmentDate());
		b.setSlot(s.getSlot());
		b.setCoachId(s.getCoachId());
		b.setUserId(s.getUserId());
		list.add(b);
		});
		return list;
	}

   public List<BookingDTO> findBookingByCoachId(String coachId) {
		List<BookingEntity> l= bRep.findBookingByUserId(coachId, LocalDate.now());
		List<BookingDTO> list= new ArrayList<>();
		l.forEach((s)->{
		BookingDTO b= new BookingDTO();
		b.setBookingId(s.getBookingId());
		b.setAppointmentDate(s.getAppointmentDate());
		b.setSlot(s.getSlot());
		b.setCoachId(s.getCoachId());
		b.setUserId(s.getUserId());
		list.add(b);
		});
		return list;
}
}
