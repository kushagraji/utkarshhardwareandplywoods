package com.utkarshhardwareandplywood.springboot.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utkarshhardwareandplywood.springboot.website.models.ShippingDetails;
import com.utkarshhardwareandplywood.springboot.website.repo.RepoShippingDetails;

@RestController
public class ShippingDetailsController {

	@Autowired
	private RepoShippingDetails repoShippingDetails;
	
	@GetMapping("/shippingdetails")
	public ModelAndView showShippingAddressPage() {
		ModelAndView modelAndView = new ModelAndView("shippingdetailspage");
		return modelAndView;
	}
	
	@PostMapping("/registerDetails")
	public ModelAndView registerDetails(@ModelAttribute("details") ShippingDetails details,Model m) {
		
		ModelAndView modelAndView = new ModelAndView("payment");
	//	m.addAttribute("price", price);
	//	System.out.println(price);
		repoShippingDetails.save(details);
		return modelAndView;
		
	}
	
	
}
