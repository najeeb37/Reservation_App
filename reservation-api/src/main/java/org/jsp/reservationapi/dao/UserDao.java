package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
	public Optional<User> findById(int id){
		return repository.findById(id);
	}
	
	public Optional<User> verifyUser(String email,String password){
		return repository.verifyUser(email, password);
	}
}
