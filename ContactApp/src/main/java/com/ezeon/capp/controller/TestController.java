package com.ezeon.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test/ajax-test")
	public String testPage() {
		return "test";
	}

}
