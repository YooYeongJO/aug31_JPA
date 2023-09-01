package com.jose1593.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value={"/", "/index"}) // "/", "/index" 둘다 처리하겠다는 의미이다
	public String index() {
		
		return "index";
	}

}
