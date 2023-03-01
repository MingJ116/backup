package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// WebServlet = @Controller + @RequestMapping
@Controller
@RequestMapping ("/home/*")
public class HomeController {
	@GetMapping ("index")
	public String home () {
		return "home/index";
	}
}
