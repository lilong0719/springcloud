package com.ll;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demo")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getDemo(){
        return "good";
    }
	
	@GetMapping("/demo1")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getDemo1(){
        return "good1";
    }
}
