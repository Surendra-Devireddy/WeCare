package com.surendra.WeCare.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.surendra.WeCare.Entity.BookingEntity;

public interface BookRepository extends CrudRepository<BookingEntity, Integer>{
        public Optional<BookingEntity> finByUserId(String userId);
        
        @Query("select * from bookingtable b where b.user_id=:userId and b.appointment_date>:today")
        public List<BookingEntity> findBookingByUserId(@Param("userId")String userId, @Param("today")LocalDate today);
        
        @Query("select * from bookingtable b where b.coach_id=:coachId and b.appointment_date>:today")
        public List<BookingEntity> findBookingByCoachId(@Param("coachId")String coachId, @Param("today")LocalDate today);
        
        @Query("select * from bookingtable b where b.user_id=:userid and b.appointmentDate=:appointmentDate and b.slot=:slot")
        public BookingEntity findAllBookings(@Param("userId")String userId, @Param("appointmentDate")LocalDate appointmentDate,@Param("slot")String slot);
}
