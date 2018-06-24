package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.mobocart.Projects;
import com.niit.mobocart.UserDetails;
import com.niit.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<UserDetails>> getUserDetails() throws Exception 
	{
		userService.getuserDetails();
		return new ResponseEntity<List<UserDetails>>(userService.getuserDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/{searchBy}/{search}")
	public ResponseEntity<List<UserDetails>> searchUser(@PathVariable("searchBy") String searchBy,@PathVariable("search") String search ) throws Exception 
	{
		System.out.println(searchBy+"\n");
		System.out.println("search "+search);
		userService.searchUser(searchBy, search);
		return new ResponseEntity<List<UserDetails>>(userService.searchUser(searchBy, search),HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> addUser(@RequestBody UserDetails user) throws Exception
	{
		userService.addUserDetails(user,user.getRole());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserDetails> getUserByUsername(@RequestBody UserDetails user) throws Exception
	{
		UserDetails u=null;
		if(userService.getUserDetailsByUsername(user.getUsername())!=null)
		{
			u=userService.getUserDetailsByUsername(user.getUsername());
			System.out.println("Login successfull");
		}
		else
		{
			System.out.println("Login unsusscessfull");
		}
		return new ResponseEntity<UserDetails>(u,HttpStatus.OK);
	}

	@PostMapping("/assignproject")
	public ResponseEntity<Void> assignProject(@RequestBody Projects projects) throws Exception
	{
		userService.assignProject(projects.getUserid(),projects.getProjectName(), projects.getDescription());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userid") int  id) throws Exception
	{
		UserDetails userDetails=userService.getUserDetailsById(id);
		userService.deleteUserDetails(userDetails);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateUser(@RequestBody UserDetails user) throws Exception
	{
		userService.updateUserDetails(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
