package com.surendra.WeCare.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.surendra.WeCare.entity.BookingEntity;


public interface BookRepository extends CrudRepository<BookingEntity, Integer>{
        public Optional<BookingEntity> findByUserId(String userId);
        
        @Query("select b from BookingEntity b where b.userId=:userId and b.appointmentDate>:today")
        public List<BookingEntity> findBookingByUserId(@Param("userId")String userId, @Param("today")LocalDate today);
        
        @Query("select b from BookingEntity b where b.coachId=:coachId and b.appointmentDate>:today")
        public List<BookingEntity> findBookingByCoachId(@Param("coachId")String coachId, @Param("today")LocalDate today);
        
        @Query("SELECT b FROM BookingEntity b WHERE b.userId=:userId and b.appointmentDate=:appointmentDate and b.slot=:slot")
        public BookingEntity findAllBookings(@Param("userId")String userId, @Param("appointmentDate")LocalDate appointmentDate,@Param("slot")String slot);
}
