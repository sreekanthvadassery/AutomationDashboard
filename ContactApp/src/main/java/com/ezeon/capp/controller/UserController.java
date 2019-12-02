package com.ezeon.capp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezeon.capp.domain.User;
import com.ezeon.capp.exception.UserBlockedException;
import com.ezeon.capp.service.UserService;

/**
 * @author User
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","/index"})
	public ModelAndView index(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); //JSP - /WEB-INF/view/index.jsp
		return modelAndView;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView handleLogin(@ModelAttribute User user,HttpServletRequest request,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			User loggedInUser = userService.login(user.getLoginName(), user.getPassword());
			if(loggedInUser==null) {
				//FAILED
				//Add error message and go back to login-form
				modelAndView.addObject("error", "Login Failed! Enter valid credentials.");
				modelAndView.setViewName("index");//JSP - Login form
			}
			else {
				//SUCCESS
				//Check the role and re direct to the appropriate dash board
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					//Add user detail in session (assign session to logged in User)
					addUserInSession(loggedInUser, session);
					modelAndView.setViewName("redirect:admindashboard");
				}
				else if(loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					//Add user detail in session (assign session to logged in User)
					addUserInSession(loggedInUser, session);
					modelAndView.setViewName("redirect:userdashboard");
				}
				else {
					//Add error message and go back to login-form
					modelAndView.addObject("error", "No such role present");
					modelAndView.setViewName("index");//JSP - Login form
				}
			}
		} 
		catch (UserBlockedException e) {
			//Add error message and go back to login-form
			modelAndView.addObject("error", e.getMessage());
			modelAndView.setViewName("index");//JSP - Login form
		}
		return modelAndView;
	}
	
	@RequestMapping(value= {"/userdashboard"})
	public ModelAndView userDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dashboard_user"); //JSP 
		return modelAndView;
	}
	
	@RequestMapping(value= {"/admindashboard"})
	public ModelAndView adminDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dashboard_admin"); //JSP 
		return modelAndView;
	}
	
	public void addUserInSession(User user,HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("role", user.getRole());
	}
	
}
