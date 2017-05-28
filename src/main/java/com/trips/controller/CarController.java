package com.trips.controller;

import com.trips.entity.Car;
import com.trips.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.service.CarService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/car")
public class CarController {
	
	@Autowired
	private CarService carService;

	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
		int currentPage = 1;
		String redirectUrl = "redirect:/admin/car/list?page=1";
		try {
			currentPage = Integer.parseInt(page);
		} catch (Exception e) {
			return redirectUrl;
		}
		if (currentPage <= 0) {
			return redirectUrl;
		}
		PaginationUtil<Car> paging = carService.paging(currentPage);
		if (!paging.isFound()) {
			return redirectUrl;
		} else {
			model.addAttribute("paging", paging);
			return "admin/car/list";
		}
	}
	
	
}
