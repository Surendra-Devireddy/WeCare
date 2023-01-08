package com.surendra.WeCare.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surendra.WeCare.DTO.BookingDTO;
import com.surendra.WeCare.DTO.CoachDTO;
import com.surendra.WeCare.DTO.LoginDTO;
import com.surendra.WeCare.Exception.WeCareException;
import com.surendra.WeCare.Service.BookService;
import com.surendra.WeCare.Service.CoachService;

@RestController
@RequestMapping
@CrossOrigin(origins ="*")
@Validated
public class CoachRestController {
     @Autowired
     private CoachService cService;
     @Autowired
     private BookService bService;
     
     @PostMapping(value="/coaches",consumes="application/json")
     public ResponseEntity<String> createCoach(@Valid @RequestBody CoachDTO coachDTO, Errors errors){
    	 
    	 	String id=cService.createCoach(coachDTO);
    	 	return new ResponseEntity<String>(id, HttpStatus.OK);
     }
     
     @PostMapping(value="/caoches/login",consumes="application/json")
     public ResponseEntity<Boolean> loginCoach(@Valid @RequestBody LoginDTO loginDTO, Errors errors) throws WeCareException{
    	 
    	 	Boolean id=cService.loginCoach(loginDTO);
    	 	return new ResponseEntity<Boolean>(id, HttpStatus.OK);
     }
     
     @GetMapping(value="/coaches/{coachId}")
     public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable String coachId){
    	 CoachDTO c = cService.getCoachProfile(coachId);
    	 return new ResponseEntity<CoachDTO>(c, HttpStatus.OK);
     }
     

     @GetMapping(value="/coaches/all")
     public List<CoachDTO> showAllCoaches(){
    	return cService.showAllCoaches();
     }
     
     @GetMapping(value="/coaches/booking/{coachId}")
     public List<BookingDTO> showMySchedule(@PathVariable String coachId){
    	 return bService.findBookingByCoachId(coachId);
     }
}
