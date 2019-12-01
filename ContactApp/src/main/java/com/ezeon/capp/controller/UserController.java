package com.ezeon.capp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezeon.capp.domain.User;
import com.ezeon.capp.exception.UserBlockedException;
import com.ezeon.capp.service.UserServiceImpl;

/**
 * @author User
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value= {"/","/index"})
	public ModelAndView index(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); //JSP - /WEB-INF/view/index.jsp
		return modelAndView;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView handleLogin(@ModelAttribute User user,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			User loggedInUser = userServiceImpl.login(user.getLoginName(), user.getPassword());
			if(loggedInUser==null) {
				//FAILED
				//Add error message and go back to login-form
				modelAndView.addObject("error", "Login Failed! Enter valid credentials.");
				modelAndView.setViewName("index");//JSP - Login form
				//return modelAndView;
			}
			else {
				//SUCCESS
				//Check the role and re direct to the appropriate dashboard
				if(loggedInUser.getRole().equals(userServiceImpl.ROLE_ADMIN)) {
					//modelAndView.setViewName("redirect:/dashboard_admin");
					modelAndView.setViewName("dashboard_admin");
					//return modelAndView;
				}
				else if(loggedInUser.getRole().equals(userServiceImpl.ROLE_USER)) {
					//modelAndView.setViewName("redirect:/dashboard_user");
					modelAndView.setViewName("dashboard_user");
					//return modelAndView;
				}
				else {
					//Add error message and go back to login-form
					modelAndView.addObject("error", "No such role present");
					modelAndView.setViewName("index");//JSP - Login form
					//return modelAndView;
				}
			}
		} 
		catch (UserBlockedException e) {
			//Add error message and go back to login-form
			modelAndView.addObject("error", e.getMessage());
			modelAndView.setViewName("index");//JSP - Login form
			//return modelAndView;
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
	
}
