package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.configuration.BaseAction;
import com.example.model.Shop;
import com.example.model.User;
import com.example.service.ShopService;
import com.example.service.UserService;

@Controller
public class ShopController extends BaseAction{
	
		@Autowired UserService userService;	
		@Autowired ShopService shopService;	
		
		 
	 	 
		@RequestMapping(value={"/shop"}, method = RequestMethod.GET)	 
		public ModelAndView index(@RequestParam(value = "userId") int userId){	
			
			ModelAndView modelAndView = new ModelAndView();				 
			List<Shop> shop = shopService.listShopByUserId(userId);
		 
			System.out.println("LOG : "+shop);
				 
			modelAndView.addObject("shop", shop);			 					
			modelAndView.setViewName("02-shop/1-shop");
			return modelAndView;
		}
		
		
		@RequestMapping(value={"/shop/add"}, method = RequestMethod.GET)
		public ModelAndView add(){
			ModelAndView modelAndView = new ModelAndView();		 
			Shop shop = new Shop();
			modelAndView.addObject("shop", shop);
			modelAndView.setViewName("02-shop/2-add");
			return modelAndView;
		}
		
		@RequestMapping(value = "/shop/add", method = RequestMethod.POST)
		public ModelAndView doAdd(@Valid User user, BindingResult bindingResult) {
			ModelAndView modelAndView = new ModelAndView();
			User userExists = userService.findUserByUsername(user.getUsername());
			if (userExists != null) {
				bindingResult
						.rejectValue("username", "error.username",
								"There is already a user registered with the username provided");
			}
			if (bindingResult.hasErrors()) {
				modelAndView.setViewName("01-users/2-add");
			} else {
				userService.saveOrUpdateUser(user);
				modelAndView.addObject("successMessage", "User has been registered successfully");
				modelAndView.addObject("user", new User());
				modelAndView.setViewName("01-users/2-add");
				
			}
			return modelAndView;
		}
	
}
