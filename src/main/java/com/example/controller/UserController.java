package com.example.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.configuration.BaseAction;
import com.example.configuration.Pager;
import com.example.model.User;
import com.example.service.UserService;

@Controller
public class UserController extends BaseAction{	
	
	 @Autowired UserService userService;	  
	
	@RequestMapping(value={"/user"}, method = RequestMethod.GET)	 
	public ModelAndView index(@RequestParam(value = "pageSize",defaultValue = "5") Optional<Integer> pageSize,
			@RequestParam(value = "page",defaultValue = "1") Optional<Integer> page,
			@RequestParam(value = "keyword",defaultValue = "") String keyword){
		
		ModelAndView modelAndView = new ModelAndView();
			
 
		Page<User> users =  userService.findAll(pageSize,page);
		Pager pager = new Pager(users.getTotalPages(), users.getNumber(), BUTTONS_TO_SHOW);
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		
		modelAndView.addObject("users", users);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		
		modelAndView.addObject("pageSize", pageSize.get());
		modelAndView.addObject("page", page.get());
	
		
		modelAndView.setViewName("01-users/1-users");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/user/add"}, method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView modelAndView = new ModelAndView();		 
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("01-users/2-add");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
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
	
	
	@RequestMapping(value={"/user/edit"}, method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("userId") Integer userId){
		ModelAndView modelAndView = new ModelAndView();		 
		 
		User user = userService.findByUserId(userId);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("01-users/3-edit");
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public ModelAndView doEdit(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUsername(user.getUsername());		 
		if (userExists != null && userExists.getId() != user.getId()) {
			bindingResult
					.rejectValue("username", "error.username",
							"There is already a user registered with the username provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("01-users/3-edit");
		} else {
			userService.saveOrUpdateUser(user);
			modelAndView.addObject("successMessage", "User has been updated successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("01-users/3-edit");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value={"/user/active"}, method = RequestMethod.GET)
	public String active(@RequestParam("userId") Integer userId,
			@RequestParam("active") int active,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("page") Integer page){		
		userService.active(userId, active);
		return "redirect:/user?pageSize="+pageSize+"&page="+page;
	}
	
}
