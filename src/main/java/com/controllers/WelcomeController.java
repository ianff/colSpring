package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Users;
import com.services.UserServices;

@Controller
public class WelcomeController {
	private UserServices userServices;
	
	@Autowired
	public void setUserService(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public ModelAndView getPage(@ModelAttribute("user") Users user) {
		ModelAndView view = new ModelAndView("welcome");
		return view;
	}
	
	@RequestMapping(value= "/welcome/login", method = RequestMethod.POST)
//	public String checkUser(@PathVariable("userName") String userName, @PathVariable("password") String password){
	public String checkUser(@ModelAttribute("user") Users user){
		System.out.println("username: " + user.getUserName());		
		System.out.println("password: " + user.getPassword());
		return "redirect:/welcome";
	}
}
