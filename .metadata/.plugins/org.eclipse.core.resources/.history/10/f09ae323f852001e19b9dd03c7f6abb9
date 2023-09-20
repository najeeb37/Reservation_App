package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.UserDao;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.exception.IdNotFoundException;
import org.jsp.reservationapi.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
	public UserDao dao;
	
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(dao.saveUser(user));
		structure.setMessege("User created");
		structure.setStstusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(dao.updateUser(user));
		structure.setMessege("User created");
		structure.setStstusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<User>> findById(int id){
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.findById(id);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessege("User found");
			structure.setStstusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verifyUser(phone, password);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessege("User verified");
			structure.setStstusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}
