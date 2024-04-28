package com.utkarshhardwareandplywood.springboot.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utkarshhardwareandplywood.springboot.website.models.Login;
import com.utkarshhardwareandplywood.springboot.website.models.User;
import com.utkarshhardwareandplywood.springboot.website.repo.Repo;

@RestController
public class UserController {

	@Autowired
	private Repo repo;
	
	@GetMapping("/registerUserpage")
	public ModelAndView showregisterPage() {
		
		ModelAndView modelAndView = new ModelAndView("userRegister");
		return modelAndView;
	}
	
	@PostMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute("user") User user, ModelMap model) {
        
		ModelAndView modelAndView = new ModelAndView("userRegister");
		
		User save = repo.save(user);
		model.addAttribute("id" , "your Id is: " + save.getId() );
		return modelAndView;

	}
	
	@GetMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/loginVerification")
	public ModelAndView loginVerification(@ModelAttribute("login") Login login) {
		
		ModelAndView modelAndView = new ModelAndView("productPage");
		ModelAndView modelAndView2 = new ModelAndView("login");
		User user = repo.findById(login.getId()).get();
		
		if((login.getEmail()).equals(user.getEmail())) {
			return modelAndView;	
		}else {
			modelAndView2.addObject("message", "Invalid Credential");
			return modelAndView2;
		}
		
		
		
	}
}
