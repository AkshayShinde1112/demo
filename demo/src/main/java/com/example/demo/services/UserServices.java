package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userrepo;
	
	public User addUser(User user) {
		return userrepo.save(user);
	}
	
	public User login(User user) {
		User  user2 = userrepo.findByEmail(user.getEmail());
		if(user.getPassword().equals(user2.getPassword())) {
			return user2;
		}
		return null;
	}
	
	public List<User> userlist(){
		return userrepo.findAll();
		
	}

	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		User user = userrepo.findById(id).get();
		return user;
	}

	public User editUser(Integer id, User user) {
		// TODO Auto-generated method stub
		User user2 =userrepo.findById(id).get();
		user2.setCity(user.getCity());
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		return userrepo.save(user2);
	}

	public String deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User user = userrepo.findById(id).get();
		if(user!=null) {
			userrepo.delete(user);
			return "User Deleted successfully";
		}
		
		return "user not found";
	}
	
}
