package com.te.springmvc.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	@GetMapping("/cookie")
	public String getCookies() {
		return "cookiePage";
	}

	@GetMapping("/createcookie")
	public String createCookies(HttpServletResponse response,ModelMap map) {
		Cookie cookie=new Cookie("EmpName", "Varma");
		response.addCookie(cookie);
		map.addAttribute("msg", "cookie created sucessfully");
		return "cookiePage";
	}

	@GetMapping("/showcookie")
	public String showCookies(@CookieValue(name = "EmpName",required = false) String name,ModelMap map) {
		map.addAttribute("emp",name);
		return "cookiePage";
	}

}
