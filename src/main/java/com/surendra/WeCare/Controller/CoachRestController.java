package com.surendra.WeCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surendra.WeCare.DTO.CoachDTO;
import com.surendra.WeCare.Service.CoachService;

@RestController
@RequestMapping
@CrossOrigin(origins ="*")
public class CoachRestController {
     @Autowired
     private CoachService cService;
     
    // @PostMapping(value="/caoches")
     //public ResponseEntity<String> createCoach(CoachDTO coachDTO, Errors error){
    	 	
     //}
}
