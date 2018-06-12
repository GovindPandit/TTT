package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.mobocart.UserDetails;
import com.niit.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	UserService userService;
	
	@GetMapping(value= {"/","/index","/home"})
	public String getUserDetails(Model model) throws Exception
	{
		model.addAttribute("user",new UserDetails());
		model.addAttribute("userList",userService.getuserDetails());
		return "index";
	}
	@PostMapping(value= {"/addUser"})
	public String addUser(@ModelAttribute("user") UserDetails user) throws Exception
	{
		userService.addUserDetails(user);
		return "redirect:/";
	}
	@GetMapping(value= {"/delete{userid}"})
	public String deleteUser(@PathVariable("userid") int id) throws Exception
	{
		UserDetails user=userService.getUserDetailsById(id);
		userService.deleteUserDetails(user);
		return "redirect:/";
	}
	@RequestMapping(value= {"/edit{userid}"})
	public String editUser(@PathVariable("userid") int id,Model model) throws Exception
	{
		UserDetails user=userService.getUserDetailsById(id);
		model.addAttribute("user",user);
		return "index";
	}
	@RequestMapping(value= {"/updateuser"})
	public String updateUser(@ModelAttribute("user") UserDetails user) throws Exception
	{
		userService.updateUserDetails(user);
		return "redirect:/";
	}
}
