package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserServices userservice;
	
	//
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userservice.addUser(user);	
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userservice.login(user);
	}
	
	@GetMapping("/allusers")
	public List<User> userlist(){
		return userservice.userlist();		
	}
	
	@GetMapping("/getuser/{id}")
	public User getuser(@PathVariable Integer id ) {
		return userservice.getUser(id);
	}
	
	
	@PutMapping("/edit/{id}")
	public User updateUser(@PathVariable Integer id,@RequestBody User user) {	
		return userservice.editUser(id,user);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		
		return userservice.deleteUser(id);
		
	}
}
