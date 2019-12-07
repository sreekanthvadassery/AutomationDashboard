package com.ezeon.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezeon.capp.domain.Contact;
import com.ezeon.capp.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/user/contact_form")
	public ModelAndView contactForm() {
		//We are not creating a separate ContactCommand class, but reusing the Contact class
		ModelAndView modelAndView = new ModelAndView();
		Contact contact = new Contact();
		modelAndView.addObject("contactCommand",contact);
		modelAndView.setViewName("contact_form"); //JSP Contact form view
		return modelAndView;
	}

	@PostMapping(value = "/user/save-contact")
	public ModelAndView saveOrUpdateContact(@ModelAttribute("contactCommand") Contact contact,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		//Try to get the contactId from session --> Only for edit operation we are saving the contactId in session 
		Integer contactId = (Integer) session.getAttribute("aContactId");
		
		if(contactId==null) {
			//If contactId is NULL in session object --> Save 
			try {
				//Get the userId for the logged in User
				Integer userId=(Integer) session.getAttribute("userId");
				contact.setUserId(userId); //FK ;Logged in UserId
				contactService.save(contact);
				modelAndView.setViewName("redirect:clist?action=sv"); //JSP : Redirect User to contact list url
			}
			catch(Exception e) {
				e.printStackTrace();
				modelAndView.addObject("error","Failed to save Contact! "+e.getLocalizedMessage());
				modelAndView.setViewName("contact_form"); //JSP Contact form view
				return modelAndView;
			}
		}
		else {
			//If contactId is NOT NULL in session object --> Update 
			try {
				contact.setContactId(contactId); //PK
				contactService.update(contact);
				//Removing the attribute after edit
				session.removeAttribute("aContactId");
				modelAndView.setViewName("redirect:clist?action=ed"); //JSP : Redirect User to contact list url
			}
			catch(Exception e) {
				e.printStackTrace();
				modelAndView.addObject("error","Failed to Edit Contact! "+e.getLocalizedMessage());
				modelAndView.setViewName("contact_form"); //JSP Contact form view
				//Removing the attribute after edit
				session.removeAttribute("aContactId");
				return modelAndView;
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/user/clist")
	public ModelAndView contactList(HttpSession session) {
		//Get the userId for the logged in User
		Integer userId=(Integer) session.getAttribute("userId");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("contactList", contactService.findUserContact(userId));
		modelAndView.setViewName("clist"); //JSP
		return modelAndView;
	}

	@RequestMapping(value = "/user/del-contact")
	public ModelAndView deleteContact(@RequestParam("cid") Integer contactId) {
		ModelAndView modelAndView = new ModelAndView();
		contactService.delete(contactId);
		modelAndView.setViewName("redirect:clist?action=del"); 
		return modelAndView;
	}

	@RequestMapping(value = "/user/edit-contact")
	public ModelAndView prepareEditForm(HttpSession session,@RequestParam("cid") Integer contactId) {
		ModelAndView modelAndView = new ModelAndView();
		//Storing the contactId into session for future use
		session.setAttribute("aContactId", contactId);
		//Finding the corresponding Contact object
		Contact contact =  contactService.findByContactId(contactId);
		//Adding the contactCommand to the JSP page
		modelAndView.addObject("contactCommand",contact);
		modelAndView.setViewName("contact_form"); //JSP Contact form view
		return modelAndView;
	}
}
