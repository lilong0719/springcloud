package com.ll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)  
    public String login() {
        return "login";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)  
    public String home() {
        return "home";
    }
	
	@RequestMapping(value = "/home2", method = RequestMethod.GET)  
    public String home2() {
        return "home2";
    }
}
