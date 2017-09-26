package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.configuration.Pager;
import com.example.model.Contract;
import com.example.model.Department;
import com.example.model.Division;
import com.example.model.Location;
import com.example.model.Position;
import com.example.model.User;
import com.example.service.ContractService;
import com.example.service.DepartmentService;
import com.example.service.DivisionService;
import com.example.service.LocationService;
import com.example.service.PositionService;
import com.example.service.UserService;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {
	
	@Value("${form.error.duplicate}") private String formErrorDuplicate;
	  
	
	@Autowired private UserService userService;
	@Autowired private DepartmentService departmentService;
	@Autowired private LocationService locationService;
	@Autowired private DivisionService divisionService;
	@Autowired private PositionService positionService;
	@Autowired private ContractService contractService;
	
	private static final int BUTTONS_TO_SHOW = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20 };
	private static final int INITIAL_PAGE_SIZE = 5;
	 
	private List<Location> location;
	private List<Division> division;
	private List<Position> position;
	private List<Department> depts;
	private List<Contract>  contract;
	
//	private User user;
	 
	 
	 

	@RequestMapping(value={"/users"}, method = RequestMethod.GET)	 
	public ModelAndView index(@RequestParam(value = "pageSize",defaultValue = "5") Optional<Integer> pageSize
			,@RequestParam(value = "page",defaultValue = "1") Optional<Integer> page
			,@RequestParam(value = "keyword",defaultValue = "NULL") String keyword
			,@RequestParam(value = "locId", defaultValue = "0",required=false) Integer locId
			,@RequestParam(value = "divId", defaultValue = "0",required=false) Integer divId){
		
		ModelAndView modelAndView = new ModelAndView();
		division = divisionService.findAll();
		location = locationService.findAll();
		depts = departmentService.findAll();
		 
		
		Page<User> users =  userService.findAll(pageSize,page,keyword,locId,divId);
		Pager pager = new Pager(users.getTotalPages(), users.getNumber(), BUTTONS_TO_SHOW);
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		
		
		modelAndView.addObject("users", users);
		modelAndView.addObject("division", division);
		modelAndView.addObject("location", location);
		modelAndView.addObject("pageSize", pageSize.get());
		modelAndView.addObject("page", page.get());
		
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		
		 
		modelAndView.addObject("departments",depts);
		
		modelAndView.setViewName("01-users/1-users");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/users/add"}, method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView modelAndView = new ModelAndView();		 
		User user = new User();
		location = locationService.findAll();
		division = divisionService.findAll();
		contract = contractService.findAll();
		
		modelAndView.addObject("location", location);
		modelAndView.addObject("division", division);
		modelAndView.addObject("contract", contract);
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("01-users/2-add");
		return modelAndView;
	}
	
	@RequestMapping(value={"/users/add"}, method = RequestMethod.POST)
	public ModelAndView insert(@Valid User user, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();	
		location = locationService.findAll();
		division = divisionService.findAll();		
		contract = contractService.findAll();
		
		modelAndView.addObject("location", location);
		modelAndView.addObject("division", division);		 	
		modelAndView.addObject("contract", contract);
		
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.username",formErrorDuplicate);
		}
		 
		
		if (bindingResult.hasErrors()) {			 
			modelAndView.setViewName("01-users/2-add");
		} else {
			 
			userService.saveOrUpdate(user);
			modelAndView.addObject("successMessage",true);
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("01-users/2-add");
			
		}
	 
		return modelAndView;
	}
	
 
	
	@RequestMapping(value={"/users/list_pos_by_div"},method=RequestMethod.POST)
    public @ResponseBody List<Position> sayHello(@RequestBody Division div) {		 
		position = positionService.findByDivId(div.getId());
        return position;
    }
	
	@RequestMapping(value={"/users/view"}, method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("userId") Integer userId){
		ModelAndView modelAndView = new ModelAndView();		 
		 
		User user = userService.findByUserId(userId);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("01-users/4-view");
		return modelAndView;
	}
	
	@RequestMapping(value={"/users/active"}, method = RequestMethod.GET)
	public String active(@RequestParam("userId") Integer userId,
			@RequestParam("active") int active,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("page") Integer page){		
		userService.active(userId, active);
		return "redirect:/users?pageSize="+pageSize+"&page="+page;
	}
	
	@RequestMapping(value={"/users/edit"}, method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("userId") Integer userId){
		ModelAndView modelAndView = new ModelAndView();		 
		 
		User user = userService.findByUserId(userId);
	 
		location = locationService.findAll();
		division = divisionService.findAll();
		contract = contractService.findAll();
		
		modelAndView.addObject("location", location);
		modelAndView.addObject("division", division);
		modelAndView.addObject("contract", contract);		
		modelAndView.addObject("user", user);
		
		modelAndView.setViewName("01-users/3-edit");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/users/edit", method = RequestMethod.POST)
	public ModelAndView doEdit(@Valid User user, BindingResult bindingResult ) {
		
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUsername(user.getUsername());	
		
		location = locationService.findAll();
		division = divisionService.findAll();
		contract = contractService.findAll();
		
		modelAndView.addObject("location", location);
		modelAndView.addObject("division", division);
		modelAndView.addObject("contract", contract);
		 
		if (userExists != null && userExists.getId() != user.getId()) {
			bindingResult
					.rejectValue("username", "error.username",
							"There is already a user registered with the username provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("01-users/3-edit");
		} else {
			userService.saveOrUpdate(user);
			modelAndView.addObject("successMessage", "User has been updated successfully");
			modelAndView.addObject("user", user);
			modelAndView.setViewName("01-users/3-edit");
			
		}
		modelAndView.setViewName("01-users/3-edit");
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-M-yyyy"), true));
	}
	
}
