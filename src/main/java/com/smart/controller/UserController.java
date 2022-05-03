package com.smart.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.entities.Message;
import com.smart.entities.User;
import com.smart.service.UserService;

@Controller
public class UserController
{
    @Autowired	
	private UserService userService;
	
	
	@GetMapping("/dashboard")
	public String userDetail() {
		return "dashboard";
	}
	@GetMapping("/login")
	public String login() 
	{
		return "login";
	}
	@GetMapping("/signup")
	public String userSignup(Model model) 
	{
		model.addAttribute("user",new User());
		return "signup";
	}
	
	
	
	@PostMapping("/do_register")
	public String userRegister(@Valid @ModelAttribute User user, BindingResult result, Model model,@RequestParam(value="agreement",defaultValue ="false") boolean agreement,HttpSession session) 
	{
		
		try
		{
			if(!agreement)
			{
				System.out.println("You have not agreed the term and conditiions..");
				throw new Exception("You have not agreed the term and conditiions.. ");
			}
			if(result.hasErrors())
			{
				System.out.println("1----------");
				System.out.println(result.toString());
				System.out.println("2----------");
				model.addAttribute("user",user);
				return "signup";
			}
			System.out.println("3----------");
			user.setRole("USER_ROLE");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			
			model.addAttribute("user",new User());
			
			System.out.println(user);
			System.out.println(agreement);
			
		  Optional<User>  obj=	Optional.ofNullable(userService.addUser(user));
		  System.out.println("4----------");
		  if(obj.isPresent())
		  {
			  System.out.println("5----------");
			  session.setAttribute("message", new Message("Successfully Registered","alert-success"));
				model.addAttribute("title","Smart Contact Registration successfully");
				
				 return "signup";
		  }
		 
		
		 
		}
		catch(Exception e)
		{
			System.out.println("Exception has occurred ");
			session.setAttribute("message", new Message("Something went wrong !","alert-danger"));
		
		}
		return "signup";
	}

}
