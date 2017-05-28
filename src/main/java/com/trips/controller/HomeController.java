package com.trips.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.util.DateTimeUtil;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("nextDate", DateTimeUtil.getNextDate());
		return "main/home";
	}
	
}
