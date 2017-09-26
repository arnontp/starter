package com.example.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;

	

@Controller
public class DefaultController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());		 		
		  Set<Role> roles =  user.getRoles();		 
		  for (Role role : roles) {
			 System.out.println("ROLE IS = "+role.getRole());
			  if(role.getRole().endsWith("ADMIN")) {
				  System.out.println("YES");
				  return "redirect:/admin/home";
			  }
		  }		
		  return "redirect:/";
    }
}
