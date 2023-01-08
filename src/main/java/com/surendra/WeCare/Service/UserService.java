package com.surendra.WeCare.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surendra.WeCare.DTO.LoginDTO;
import com.surendra.WeCare.DTO.UserDTO;
import com.surendra.WeCare.Exception.WeCareException;
import com.surendra.WeCare.Repository.UserRepository;
import com.surendra.WeCare.entity.UserEntity;

@Service(value="uService")
public class UserService {

	
	@Autowired
	private UserRepository uRep;
	
	public String createUser(UserDTO userDTO) {
		UserEntity c= new UserEntity();
		c.setName(userDTO.getName());
		c.setDateOfBirth(userDTO.getDateOfBirth());
		c.setGender(userDTO.getGender());
		c.setMobileNumber(userDTO.getMobileNumber());
		c.setPassword(userDTO.getPassword());
		c.setEmail(userDTO.getEmail());
		c.setCity(userDTO.getCity());
		c.setCountry(userDTO.getCountry());
		c.setState(userDTO.getState());
		c.setPincode(userDTO.getPincode());
		return uRep.save(c).getUserId();
	}
	
	public boolean loginUser(LoginDTO loginDTO) throws WeCareException {
		Optional<UserEntity> op= uRep.findByUserId(loginDTO.getId());
		UserEntity user= op.orElseThrow(()->new WeCareException("USER_NOT_FOUND"));
		if(user.getPassword()==loginDTO.getPassword())
			return true;
		else
			return false;
	}
	
	public UserDTO getUserProfile(String userId) {
		Optional<UserEntity> user= uRep.findByUserId(userId);
		UserEntity c= user.orElse(null);
	if(c!=null) {
		UserDTO userDTO= new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setName(c.getName());
		userDTO.setDateOfBirth(c.getDateOfBirth());
		userDTO.setGender(c.getGender());
		userDTO.setMobileNumber(c.getMobileNumber());
		userDTO.setPassword(c.getPassword());
		userDTO.setCity(c.getCity());
		userDTO.setCountry(c.getCountry());
		userDTO.setEmail(c.getEmail());
		userDTO.setState(c.getState());
		return userDTO;
	}else 
		return null;
	}
	
	
}
