package com.surendra.WeCare.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.surendra.WeCare.DTO.CoachDTO;
import com.surendra.WeCare.DTO.LoginDTO;
import com.surendra.WeCare.Entity.CoachEntity;
import com.surendra.WeCare.Exception.WeCareException;
import com.surendra.WeCare.Repository.CoachRepository;

public class CoachService {
	
	@Autowired
	private CoachRepository cRep;
	
	public String createCoach(CoachDTO coachDTO) {
		CoachEntity c= new CoachEntity();
		c.setName(coachDTO.getName());
		c.setDateOfBirth(coachDTO.getDateOfBirth());
		c.setGender(coachDTO.getGender());
		c.setMobileNumber(coachDTO.getMobileNumber());
		c.setPassword(coachDTO.getPassword());
		c.setSpeciality(coachDTO.getSpeciality());
		return cRep.save(c).getCoachId();
	}
	
	public boolean loginCoach(LoginDTO loginDTO)throws WeCareException {
		Optional<CoachEntity> c= cRep.findByCoachId(loginDTO.getId());
			CoachEntity coach=c.orElseThrow(()->new WeCareException("COACH_NOT_FOUND"));
		    if(coach.getPassword()==loginDTO.getPassword()) {
		    	return true;
		    }
		    else return false;
	}
	
	public CoachDTO getCoachProfile(String coachId) {
		Optional<CoachEntity> coach= cRep.findByCoachId(coachId);
			CoachEntity c= coach.orElse(null);
		if(c!=null) {
			CoachDTO coachDTO= new CoachDTO();
			coachDTO.setCoachId(coachId);
			coachDTO.setName(c.getName());
			coachDTO.setDateOfBirth(c.getDateOfBirth());
			coachDTO.setGender(c.getGender());
			coachDTO.setMobileNumber(c.getMobileNumber());
			coachDTO.setPassword(c.getPassword());
			coachDTO.setSpeciality(c.getSpeciality());
			return coachDTO;
		}else 
			return null;
	}
	
	public List<CoachDTO> showAllCoaches(){
		Iterable<CoachEntity> i= cRep.findAll();
		List<CoachDTO> l = new ArrayList<CoachDTO>();
		for(CoachEntity e: i ) {
			CoachDTO c= new CoachDTO();
			c.setCoachId(e.getCoachId());
			c.setName(e.getName());
			c.setGender(e.getGender());
			c.setDateOfBirth(e.getDateOfBirth());
			c.setMobileNumber(e.getMobileNumber());
			c.setSpeciality(e.getSpeciality());
			l.add(c);
		}
		return l;
	}

}
