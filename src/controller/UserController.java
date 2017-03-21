package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.User;
import service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String listUsers(Model model){
		
		List<User> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		return "list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user){
		
		userService.saveUser(user);
		
		return "redirect:/list";
	}
	
	@GetMapping("/user/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model){
		
		User user = userService.getUser(id);
		
		model.addAttribute("user", user);
		
		return "user-form";
	}
	
	
}
