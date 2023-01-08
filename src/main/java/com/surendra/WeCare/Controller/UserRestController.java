package com.surendra.WeCare.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surendra.WeCare.DTO.BookingDTO;
import com.surendra.WeCare.DTO.LoginDTO;
import com.surendra.WeCare.DTO.UserDTO;
import com.surendra.WeCare.Exception.WeCareException;
import com.surendra.WeCare.Service.BookService;
import com.surendra.WeCare.Service.UserService;

@RestController
@RequestMapping
@Validated
@CrossOrigin
public class UserRestController {

     @Autowired
     private BookService bService;
     @Autowired
     private UserService uService;
     
     @PostMapping(value="/users")
     public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO){
    	 String id= uService.createUser(userDTO);
    	 return new ResponseEntity<String>(id, HttpStatus.OK);
     }
     
     @PostMapping(value="/users/login")
     public ResponseEntity<Boolean> createUser(@Valid @RequestBody LoginDTO loginDTO) throws WeCareException{
    	 Boolean id= uService.loginUser(loginDTO);
    	 return new ResponseEntity<Boolean>(id, HttpStatus.OK);
     }
     
     @GetMapping(value="/users/{userId}")
     public ResponseEntity<UserDTO> getUserProfile(@PathVariable String userId){
    	UserDTO user= uService.getUserProfile(userId);
    	return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
     }
     
     @GetMapping(value="/users/booking/{userId}")
     public List<BookingDTO> showMyAppointments(@PathVariable String userId){
    	 return bService.findBookingByUserId(userId);
     }
}
