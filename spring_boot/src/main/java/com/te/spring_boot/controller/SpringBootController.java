package com.te.spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@GetMapping("/")
	public String firstHandlerMethod() {

		return "TechnoElevate";
	}
}
